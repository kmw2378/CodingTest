package java.level2.bignumber;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {

        String number = "7741252841";
        int k = 4;
        String result = new Solution().solution(number, k);
        System.out.println("result = " + result);
    }
}
class Solution {
    public String solution(String number, int k) {

        StringBuilder stringBuilder = new StringBuilder();
        String[] split = number.split("");
        Queue<Info> queue = initQueue(split, k);
        int start = 0;
        int end = k;
        while (stringBuilder.length() < split.length - k) {
            Info info = getMaxNumber(queue, start);
            System.out.println("queue = " + queue);
            stringBuilder.append(info.number);
            start = info.index + 1;
            end++;
            if (end < split.length) {
                addQueue(split, end, queue);
            }
        }

        return stringBuilder.toString();
    }

    private void addQueue(String[] split, int i, Queue<Info> queue) {
        queue.add(new Info(i, Integer.parseInt(split[i])));
    }

    private Queue<Info> initQueue(String[] split, int end) {
        Queue<Info> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i <= end; i++) {
            addQueue(split, i, queue);
        }

        return queue;
    }

    private Info getMaxNumber(Queue<Info> queue, int start) {
        while (!queue.isEmpty()) {
            Info poll = queue.poll();
            if (poll.index >= start) {
                return poll;
            }
        }
        return null;
    }

    static class Info implements Comparable<Info> {
        int index;
        int number;

        public Info(int index, int number) {
            this.index = index;
            this.number = number;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "index=" + index +
                    ", number=" + number +
                    '}';
        }

        @Override
        public int compareTo(Info o) {
            if (number - o.number > 0) {
                return 1;
            } else if (number - o.number == 0) {
                return o.index - index;
            } else {
                return -1;
            }
        }
    }
}