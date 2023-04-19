package java.level3.overtimecount;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        int[] works = {4, 3, 3};
        int n = 4;
        long result = new Solution().solution(n, works);
        System.out.println("result = " + result);
    }
}
class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> queue = Arrays.stream(works).boxed().map(e -> -e).collect(Collectors.toCollection(PriorityQueue::new));
        while (n > 0) {
            int poll = queue.poll();
            if (poll == 0) {
                return 0;
            }
            int current = 0;
            while (poll + current < 0 && getSquare(poll + current) >= getSquare(queue.peek()) && n > 0) {
                current++;
                n--;
            }

            queue.add(poll + current);
        }

        return queue.stream().mapToLong(e -> (long) e * e).sum();
    }

    private long getSquare(int n) {
        return (long) n * n;
    }
}