package baekjoon.silver3.이친수;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        if (n == 1) {
            System.out.println(1);
            return;
        }

        final long[] arr = new long[n + 1];
        arr[0] = arr[1] = arr[2] = 1;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }

        System.out.println(arr[n]);
    }
}
