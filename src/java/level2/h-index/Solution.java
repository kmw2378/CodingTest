import java.util.*;

class Solution {
    public int solution(int[] citations) {
        
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int citation : citations) {
            queue.add(citation);
        }
        
        for (int i = 1000; i >= 1; i--) {
            while (!queue.isEmpty() && queue.peek() > i) {
                queue.poll();
            }
            
            if (citations.length - queue.size() == i) {
                return i;
            }
        }
        
        return 0;
    }
}
