import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        for (String[] arr : clothes) {
            if (!map.containsKey(arr[1])) {
                map.put(arr[1], 0);
            }
            map.put(arr[1], map.get(arr[1]) + 1);
        }
        
        for (int value : map.values()) {
            answer *= (value + 1);
        }
        
        return answer - 1;
    }
}
