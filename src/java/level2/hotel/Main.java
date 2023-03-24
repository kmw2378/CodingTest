package java.level2.hotel;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
//        String[][] book_times = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
        String[][] book_times = {{"09:10", "10:10"}, {"10:20", "12:20"}};

        int result = new Solution().solution(book_times);
        System.out.println("result = " + result);
    }

}
class Solution {
    public int solution(String[][] book_times) {

        Queue<Reservation> reservationQueue = new PriorityQueue<>();
        Queue<Time> endTimeQueue = new LinkedList<>();

        for (String[] book_time : book_times) {
            Time startTime = new Time(book_time[0]);
            Time endTime = new Time(book_time[1]);

            Reservation reservation = new Reservation(startTime, endTime);
            reservationQueue.add(reservation);
        }

        endTimeQueue.add(reservationQueue.remove().end);
        while (!reservationQueue.isEmpty()) {

            Reservation remove = reservationQueue.remove();

            boolean needToNewRoom = true;

            for (Time time : endTimeQueue) {
                if (time.addTenMinute().compareTo(remove.start) <= 0) {
                    needToNewRoom = false;
                    time.hour = remove.end.hour;
                    time.min = remove.end.min;
                    break;
                }
            }

            if (needToNewRoom) {
                endTimeQueue.add(remove.end);
            }

        }

        return endTimeQueue.size();
    }

    static class Reservation implements Comparable<Reservation> {
        Time start;
        Time end;

        public Reservation(Time start, Time end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Reservation o) {
            return Integer.compare(this.start.compareTo(o.start), 0);
        }
    }

    static class Time implements Comparable<Time> {

        int hour;
        int min;

        public Time(String book_time) {
            this.hour = Integer.parseInt(book_time.substring(0, 2));
            this.min = Integer.parseInt(book_time.substring(3));
        }

        private Time(Time time) {
            this.hour = time.hour;
            this.min = time.min;
        }

        public Time addTenMinute() {

            Time time = new Time(this);

            if (time.min + 10 >= 60) {
                time.hour++;
                time.min -= 50;
            } else {
                time.min += 10;
            }

            return time;
        }

        @Override
        public int compareTo(Time o) {
            if (this.hour < o.hour) {
                return -1;
            } else if (this.hour == o.hour) {
                return Integer.compare(this.min, o.min);
            } else {
                return 1;
            }
        }
    }
}