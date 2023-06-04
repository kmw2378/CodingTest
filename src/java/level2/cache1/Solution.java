import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        Queue<String> queue = new LinkedList<>();
        int answer = 0;
        for (String city : cities) {
            city = city.toLowerCase();
            if (queue.contains(city)) {
                queue.remove(city);
                answer++;
            } else {
                answer += 5;
            }
            queue.add(city);
            
            if (queue.size() > cacheSize) {
                queue.poll();
            }            
        }
        
        return answer;
    }
}
