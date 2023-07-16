import java.util.*;

class Solution {
    public int solution(int N, int number) {
        Map<Integer, Integer> map = initMap(N);
        rSolution(N, 0, 0, map);
        return map.getOrDefault(number, -1);
    }
    
    private void rSolution(int N, int cnt, int current, Map<Integer, Integer> map) {
        if (cnt > 8 || (cnt > 0 && current == 0)) {
            return;
        }
        
        map.put(current, Math.min(map.getOrDefault(current, cnt), cnt));
        
        for (int i = N, digit = 1; i <= 1111111111; i = i * 10 + N, digit++) {
            rSolution(N, cnt + digit, current + i, map);
            rSolution(N, cnt + digit, current - i, map);
            rSolution(N, cnt + digit, current * i, map);
            rSolution(N, cnt + digit, current / i, map);
        }
    }
    
    private Map<Integer, Integer> initMap(int N) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = N, digit = 1; i <= 1111111111; i = i * 10 + N, digit++) {
            map.put(i, digit);
        }
        
        return map;
    }
}
