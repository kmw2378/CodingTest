import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Process> priorityQueue = new PriorityQueue<>();
        initQueue(priorityQueue, priorities);
        
        Queue<Process> queue = new LinkedList<>();
        initQueue(queue, priorities);
        
        int rank = 0;
        while (!queue.isEmpty()) {
            Process current = queue.poll();
            Process priorityProcess = priorityQueue.peek();
            
            if (current.priority != priorityProcess.priority) {
                queue.add(current);
            } else {
                priorityQueue.poll();
                rank++;
                if (current.location == location + (int)'A') {
                    return rank;
                }
            }
        }
        
        return rank;
    }
    
    private void initQueue(Queue<Process> queue, int[] priorities) {
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Process((char)('A' + i), priorities[i]));
        }
    }
    
    static class Process implements Comparable<Process> {
        char location;
        int priority;
        
        public Process(char location, int priority) {
            this.location = location;
            this.priority = priority;
        }
        
        @Override
        public int compareTo(Process p1) {
            return p1.priority - this.priority;
        }
    }
}
