import java.util.*;
import java.util.Comparator;

class Solution {
    public int solution(int []A, int []B) {
        Queue<Integer> q1 = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Integer> q2 = new PriorityQueue<>();
        
        copy(q1, A);
        copy(q2, B);
        
        int answer = 0;
        for (int i = 0; i < A.length; i++) {
            answer += (q1.poll() * q2.poll());
        }
        
        return answer;
    }
    
    private void copy(Queue<Integer> queue, int[] arr) {
        for (int e : arr) {
            queue.add(e);
        }
    }
}
