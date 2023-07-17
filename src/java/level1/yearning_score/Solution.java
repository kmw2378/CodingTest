import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> map = initMap(name, yearning);
        int[] answer = new int[photo.length];
        
        for (int i = 0; i < photo.length; i++) {
            String[] arr = photo[i];
            int score = 0;
            for (String s : arr) {
                score += map.getOrDefault(s, 0);
            }
            
            answer[i] = score;
        }
        
        return answer;
    }
    
    private Map<String, Integer> initMap(String[] name, int[] yearning) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        
        return map;
    }
}
