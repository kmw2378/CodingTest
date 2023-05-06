import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> queue = Arrays.stream(scoville).boxed().collect(Collectors.toCollection(PriorityQueue::new));
        
        while (queue.size() > 1 && queue.peek() < K) {
            queue.add(getNewScoville(queue.poll(), queue.poll()));
            answer++;
        }
        
        if (queue.size() == 1 && queue.peek() < K) {
            return -1;
        }
        return answer;
    }
    
    private int getNewScoville(int n1, int n2) {
        return n1 + n2 * 2;
    }
}
