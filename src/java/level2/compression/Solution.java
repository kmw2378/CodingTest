import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> map = initMap();
        List<Integer> list = new ArrayList<>();
        int last = 27;
        for (int i = 0; i < msg.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < msg.length(); j++) {
                sb.append(msg.charAt(j));
                if (!map.containsKey(sb.toString())) {
                    map.put(sb.toString(), last++);
                    i = j - 1;
                    break;
                }
                
                if (j == msg.length() - 1) {
                    i = j;
                }
            }
            
            if (sb.length() > 1 && map.get(sb.toString()) == last - 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            list.add(map.get(sb.toString()));
        }
        
        return list.stream().mapToInt(e -> e).toArray();
    }
    
    private Map<String, Integer> initMap() {
        Map<String, Integer> map = new HashMap<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            map.put(String.valueOf(c), (int)(c - 'A' + 1));
        }
        
        return map;
    }
}
