package baekjoon.sliver3.등수매기기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final Queue<Integer> queue = new PriorityQueue<>();

        final int count = inputInteger(reader);
        for (int i = 1; i <= count; i++) {
            queue.add(inputInteger(reader));
        }

        int sequence = 1;
        long result = 0;
        while (!queue.isEmpty()) {
            final int poll = queue.poll();
            result += Math.abs(poll - sequence++);
        }

        System.out.println(result);
    }

    private static int inputInteger(final BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }
}
