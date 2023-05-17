import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String[] solution(String[] orders, int[] courses) {
        List<String> result = new ArrayList<>();
        
        for (int course : courses) {
            Map<String, Integer> map = new HashMap<>();
            
            for (String order : orders) {
                int n = order.length();
                if (n < course) {
                    continue;
                }
                
                char[] charArray = order.toCharArray();
                boolean[] visited = new boolean[n];
                combination(map, charArray, visited, 0, n, course);
            }
            
            if (map.isEmpty()) {
                continue;
            }
            
            List<String> list = map.keySet().stream().sorted((c1, c2) -> Integer.compare(map.get(c2), map.get(c1))).collect(Collectors.toList());
            
            int max = map.get(list.get(0));
            if (max == 1) {
                continue;
            }
            result.add(list.remove(0));
            
            for (String s : list) {
                if (map.get(s) < max) {
                    break;
                }
                
                result.add(s);
            }
        }
        
        return result.stream().sorted().toArray(String[]::new);
    }
    
    private void combination(Map<String, Integer> map, char[] charArray, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            refactorMap(map, charArray, visited, n);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(map, charArray, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }
    
    private void refactorMap(Map<String, Integer> map, char[] charArray, boolean[] visited, int n) {
        String s = getSortedString(combineString(charArray, visited, n));
        if (map.containsKey(s)) {
            map.replace(s, map.get(s) + 1);
        } else {
            map.put(s, 1);
        }
    }
    
    private String combineString(char[] charArray, boolean[] visited, int n) {
        
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                stringBuilder.append(charArray[i]);
            }
        }
        
        return stringBuilder.toString();
    }
    
    private String getSortedString(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}
