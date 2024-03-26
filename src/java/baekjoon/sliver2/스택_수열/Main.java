package baekjoon.silver2.스택_수열;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        int seq = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int x = sc.nextInt();
            final int length = sb.length();
            while (seq <= x) {
                sb.append("+\n");
                stack.push(seq++);
            }

            while (!stack.isEmpty()) {
                int pop = stack.pop();
                sb.append("-\n");
                if (pop == x) {
                    break;
                }
            }

            if (length == sb.length()) {
                System.out.println("NO");
                return;
            }
        }

        if (!stack.isEmpty()) {
            System.out.println("NO");
        } else {
            System.out.println(sb);
        }
    }
}
