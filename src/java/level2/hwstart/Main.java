package java.level2.hwstart;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        String[][] plans = {{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}};
//        String[][] plans = {{"aaa", "12:00", "20"}, {"bbb", "12:10", "30"}, {"ccc", "12:40", "10"}};
        String[] result = new Solution().solution(plans);
        System.out.println("result = " + Arrays.toString(result));
    }
}
class Solution {
    public String[] solution(String[][] plans) {
        PriorityQueue<Plan> queue = Arrays.stream(plans).map(Plan::new).collect(Collectors.toCollection(PriorityQueue::new));
        LinkedList<Plan> waiting = new LinkedList<>();
        while (!queue.isEmpty()) {
            Plan poll = queue.poll();

            int currentIdx = -1;
            for (int i = 0; i < waiting.size(); i++) {
                Plan plan = waiting.get(i);
                if (plan.endTime.compareTo(poll.startTime) > 0) {
                    currentIdx = i;
                    System.out.println(poll);
                    break;
                }
            }

            if (currentIdx == -1) {
                waiting.addLast(poll);
                continue;
            } else {
                waiting.add(currentIdx, poll);
                waiting.get(currentIdx + 1).refactorTime(poll.startTime.diff(waiting.get(currentIdx + 1).startTime));
            }

            Time endTime = poll.endTime;
            for (int i = currentIdx + 1; i < waiting.size(); i++) {
                Plan plan = waiting.get(i);
                plan.startTime = new Time(endTime);
                plan.initEndTime();
                endTime = plan.endTime;
            }
        }

        return waiting.stream().map(p -> p.name).toArray(String[]::new);
    }

    static class Plan implements Comparable<Plan> {

        String name;
        Time startTime;
        Time endTime;
        int playtime;

        public Plan(String[] plan) {
            this.name = plan[0];
            this.playtime = Integer.parseInt(plan[2]);
            initTimes(plan[1].split(":"));
        }

        private void initTimes(String[] split) {
            this.startTime = new Time(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
            initEndTime();
        }

        public void refactorTime(int min) {
            this.playtime -= min;
            initEndTime();
        }

        public void initEndTime() {
            this.endTime = new Time(startTime.hour + (startTime.min + playtime) / 60, (startTime.min + playtime) % 60);
        }

        @Override
        public int compareTo(Plan o) {
            return startTime.compareTo(o.startTime);
        }

        @Override
        public String toString() {
            return "Plan{" +
                    "name='" + name + '\'' +
                    ", startTime=" + startTime +
                    ", endTime=" + endTime +
                    ", playtime=" + playtime +
                    '}';
        }
    }

    static class Time implements Comparable<Time> {
        int hour;
        int min;

        public Time(int hour, int min) {
            this.hour = hour;
            this.min = min;
        }

        public Time(Time time) {
            this.hour = time.hour;
            this.min = time.min;
        }

        public void add(int min) {
            this.min += min;
            this.hour += (this.min / 60);
            this.min %= 60;
        }

        public int diff(Time time) {
            return (this.hour - time.hour) * 60 + (this.min - time.min);
        }

        private int getTotal() {
            return hour * 100 + min;
        }

        @Override
        public int compareTo(Time o) {
            return getTotal() - o.getTotal();
        }

        @Override
        public String toString() {
            return "Time{" +
                    "hour=" + hour +
                    ", min=" + min +
                    '}';
        }
    }
}