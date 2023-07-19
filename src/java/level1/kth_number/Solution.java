import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int[] command = commands[i];
            int start = command[0] - 1;
            int end = command[1] - 1;
            int k = command[2];
            
            Queue<Integer> queue = new PriorityQueue<>();
            for (int j = start; j <= end; j++) {
                queue.add(array[j]);
            }
            
            for (int j = 0; j < k - 1; j++) {
                queue.poll();
            }
            
            answer[i] = queue.peek();
        }
        
        return answer;
    }
}
