package java.level3.doublepriorityqueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
//        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        int[] result = new Solution().solution(operations);
        System.out.println("result = " + Arrays.toString(result));
    }
}
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];

        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();

        int insertCount = 0;
        int deleteCount = 0;
        for (String operation : operations) {

            String[] split = operation.split(" ");
            String command = split[0];
            int n = Integer.parseInt(split[1]);
            if (command.equals("I")) {
                maxQueue.add(n);
                minQueue.add(n);
                insertCount++;
            } else {
                deleteCount++;
                if (insertCount <= deleteCount) {
                    maxQueue.clear();
                    minQueue.clear();
                } else if (n > 0) {
                    if (!maxQueue.isEmpty()) {
                        maxQueue.poll();
                    }
                } else {
                    if (!minQueue.isEmpty()) {
                        minQueue.poll();
                    }
                }
            }
        }

        if (!maxQueue.isEmpty()) {
            answer[0] = maxQueue.peek();
        }

        if (!minQueue.isEmpty()) {
            answer[1] = minQueue.peek();
        }

        return answer;
    }
}