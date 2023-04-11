package java.level3.crackdowncamera;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        int[][] routes = {{-5, -3}, {-9, -6}, {-8, -4}, {-3, 5}};
        int result = new Solution().solution(routes);

        System.out.println("result = " + result);
    }
}
class Solution {
    public int solution(int[][] routes) {
        List<Range> result = new LinkedList<>();
        PriorityQueue<Range> queue = Arrays.stream(routes).map(Range::new).collect(Collectors.toCollection(PriorityQueue::new));

        while (!queue.isEmpty()) {
            Range current = queue.poll();
            Iterator<Range> iterator = result.iterator();
            Range max = null;
            while (iterator.hasNext()) {
                Range next = iterator.next();
                if (next.overlap(current)) {
                    if (max == null) {
                        max = next;
                    } else if (max.getValidLength(current) - max.getLength() < next.getValidLength(current) - next.getLength()) {
                        max = next;
                    }
                }
            }
            if (max == null) {
                result.add(current);
            } else {
                max.reflect(current);
            }

            System.out.println("result = " + result);
        }

        return result.size();
    }

    static class Range implements Comparable<Range> {
        int start;
        int end;

        public Range(int[] route) {
            this.start = route[0];
            this.end = route[1];
        }

        private boolean overlap(Range range) {
            return this.end >= range.start && range.end >= this.start;
        }

        private int getLength() {
            return end - start + 1;
        }

        public int getValidLength(Range range) {
            return Math.min(this.end, range.end) - Math.max(this.start, range.start);
        }

        @Override
        public String toString() {
            return "Range{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }

        public void reflect(Range range) {
            this.start = Math.max(this.start, range.start);
            this.end = Math.min(this.end, range.end);
        }

        @Override
        public int compareTo(Range range) {
            return this.start - range.start;
        }
    }
}