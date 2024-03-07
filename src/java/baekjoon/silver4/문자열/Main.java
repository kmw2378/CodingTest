package baekjoon.silver4.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final String[] split = reader.readLine().split(" ");
        final String word = split[0];
        final String destination = split[1];

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= destination.length() - word.length(); i++) {
            final String substring = destination.substring(i, i + word.length());
            int count = 0;
            for (int j = 0; j < word.length(); j++) {
                if (substring.charAt(j) != word.charAt(j)) {
                    count++;
                }
            }

            min = Math.min(count, min);
        }

        System.out.println(min);
    }
}
