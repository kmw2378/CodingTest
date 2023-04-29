package bignumber;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        String number = "1231234";
        int k = 3;
        String result = new Solution().solution(number, k);
        System.out.println("result = " + result);
    }
}
class Solution {
    public String solution(String number, int k) {
        PriorityQueue<Info> queue = initQueue(number);
        List<Info> list = getMaxNumberList(number.length() - k, queue);
        List<Integer> sortedList = getSortedList(list);
        return getString(sortedList);
    }

    private String getString(List<Integer> sortedList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int e : sortedList) {
            stringBuilder.append(e);
        }

        return stringBuilder.toString();
    }

    private List<Integer> getSortedList(List<Info> list) {
        return list.stream().sorted(Comparator.comparingInt(e -> e.index)).mapToInt(e -> e.number).boxed().collect(Collectors.toList());
    }

    private List<Info> getMaxNumberList(int k, PriorityQueue<Info> queue) {

        List<Info> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(queue.poll());
        }

        return list;
    }

    private PriorityQueue<Info> initQueue(String number) {
        PriorityQueue<Info> queue = new PriorityQueue<>(Comparator.reverseOrder());
        String[] split = number.split("");
        for (int i = 0; i < split.length; i++) {
            queue.add(new Info(i, Integer.parseInt(split[i])));
        }

        return queue;
    }

    static class Info implements Comparable<Info> {
        int index;
        int number;

        public Info(int index, int number) {
            this.index = index;
            this.number = number;
        }

        @Override
        public int compareTo(Info o) {
            return this.number - o.number;
        }
    }
}