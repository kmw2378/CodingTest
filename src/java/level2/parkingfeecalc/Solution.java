import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> result = new HashMap<>();
        Map<String, String> map = new HashMap<>();
        
        for (String record : records) {
            String[] split = record.split(" ");
            String time = split[0];
            String num = split[1];
            String status = split[2];
            
            if (status.equals("IN")) {
                map.put(num, time);
            } else {
                String startTime = map.remove(num);
                if (result.containsKey(num)) {
                    result.replace(num, result.get(num) + getTotal(startTime, time));
                } else {
                   result.put(num, getTotal(startTime, time)); 
                }
            }
        }
        
        for (String num : map.keySet()) {
            String startTime = map.get(num);
            if (result.containsKey(num)) {
                result.replace(num, result.get(num) + getTotal(startTime, "23:59"));
            } else {
                result.put(num, getTotal(startTime, "23:59"));
            }   
        }
        
        Object[] mapKeys = result.keySet().stream().toArray();
        Arrays.sort(mapKeys);
        
        List<Integer> list = new ArrayList<>();
        for (Object key : mapKeys) {
            int total = result.get(String.valueOf(key));
            list.add(getFee(fees, total));
        }
        
        return list.stream().mapToInt(e -> e).toArray();
    }
    
    private int getTotal(String start, String end) {
        String[] startTime = start.split(":");
        String[] endTime = end.split(":");
        
        int hour = Integer.parseInt(endTime[0]) - Integer.parseInt(startTime[0]);
        int min = Integer.parseInt(endTime[1]) - Integer.parseInt(startTime[1]);
        
        return hour * 60 + min;
    }
    
    private int getFee(int[] fees, int total) {
        if (total <= fees[0]) {
            return fees[1];
        }
        
        return fees[1] + fees[3] * (int)(Math.ceil((total - fees[0]) / (double)fees[2]));
    }
}
