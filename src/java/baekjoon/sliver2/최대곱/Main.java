package baekjoon.silver2.최대곱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final String[] split = reader.readLine().split(" ");
        final int s = Integer.parseInt(split[0]);
        final int k = Integer.parseInt(split[1]);

        final List<Integer> list = new ArrayList<>();
        IntStream.range(0, k)
                .map(i -> s / k)
                .forEach(i -> list.add(s / k));

        IntStream.range(0, s % k)
                .forEach(i -> list.set(i, list.get(i) + 1));

        long result = 1;
        for (Integer e : list) {
            result *= e;
        }

        System.out.println(result);
    }
}
