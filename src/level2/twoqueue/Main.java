package level2.twoqueue;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        int[] queue1 = {1, 2, 1, 2};
        int[] queue2 = {1, 10, 1, 2};

        Solution solution = new Solution();
        int answer = solution.solution(queue1, queue2);

        System.out.println("answer = " + answer);
    }
}
class Solution {
    public int solution(int[] queue1, int[] queue2) {

        int idx1 = 0;
        int idx2 = 0;

        Queue<Integer> memory1 = new PriorityQueue<>();
        Queue<Integer> memory2 = new PriorityQueue<>();

        long sum1 = Arrays.stream(queue1).sum();
        long sum2 = Arrays.stream(queue2).sum();

        int cnt = 0;

        while (idx1 < queue1.length && idx2 < queue2.length) {
            if (sum1 < sum2) {
                sum1 += queue2[idx2];
                sum2 -= queue2[idx2];
                memory1.add(queue2[idx2++]);
                cnt++;
            } else if (sum1 > sum2) {
                sum1 -= queue1[idx1];
                sum2 += queue1[idx1];
                cnt++;
                memory2.add(queue1[idx1++]);
            } else {
                return cnt;
            }
        }

        while (!memory1.isEmpty() && idx2 < queue2.length) {
            sum1 -= memory1.peek();
            sum2 += memory1.poll();
            cnt++;

            if (sum1 == sum2) {
                return cnt;
            }
        }

        while (sum1 > sum2 && idx1 < queue1.length) {
            sum1 -= queue1[idx1];
            sum2 += queue1[idx1++];
            cnt++;
        }

        while (sum1 < sum2 && idx2 < queue2.length) {
            sum1 += queue2[idx2];
            sum2 -= queue2[idx2++];
            cnt++;
        }

        return sum1 == sum2 ? cnt : -1;
    }
}