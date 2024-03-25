package baekjoon.silver1.오르막_수;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final long[][] cache = new long[n + 10][n + 10];
        System.out.println(combination(n + 9, n, cache));
    }

    private static long combination(final int n,
                                    final int r,
                                    final long[][] cache) {
        if (cache[n][r] != 0L) {
            return cache[n][r];
        }

        if (n == r || r == 0) {
            return 1;
        }

        final long result = (combination(n - 1, r - 1, cache) % 10_007
                + combination(n - 1, r, cache) % 10_007) % 10_007;
        cache[n][r] = result;
        return result;
    }
}
