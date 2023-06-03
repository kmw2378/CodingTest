import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        if (str1.toUpperCase().equals(str2.toUpperCase())) {
            return 65536;
        }
        
        Map<String, Integer> map1 = initMap(str1);
        Map<String, Integer> map2 = initMap(str2);
        Set<String> set = new HashSet<>();
        
        int union = 0;
        int intersaction = 0;
        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                intersaction += Math.min(map1.get(key), map2.get(key));
                union += Math.max(map1.get(key), map2.get(key));
            } else {
                union += map1.get(key);
            }
        }
        
        for (String key : map2.keySet()) {
            if (!map1.containsKey(key)) {
                 union += map2.get(key);
            }
        }
        
        return (int)(65536 * ((double) intersaction / union));
    }
    
    private List<String> getMultiSet(String s) {
        s = s.toUpperCase();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; i++) {
            if (!isAlphaBet(s.charAt(i)) || !isAlphaBet(s.charAt(i + 1))) {
                continue;
            }
            String subString = s.substring(i, i + 2);
            list.add(s.substring(i, i + 2));
        }
        
        return list;
    }
    
    private boolean isAlphaBet(char c) {
        return 'A' <= c && c <= 'Z';
    }
    
    private Map<String, Integer> initMap(String str) {
        Map<String, Integer> map = new HashMap<>();
        
        for (String s : getMultiSet(str)) {
            if (!map.containsKey(s)) {
                map.put(s, 0);
            }
            map.put(s, map.get(s) + 1);
        }
        
        return map;
    }
}
