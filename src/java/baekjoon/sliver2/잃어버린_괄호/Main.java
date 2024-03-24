package baekjoon.silver2.잃어버린_괄호;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String expr = scanner.nextLine();
        final List<Integer> operands = new ArrayList<>();
        final List<Character> operators = new ArrayList<>();
        int begin = 0;
        for (int i = 0; i < expr.length(); i++) {
            if (expr.charAt(i) == '+' || expr.charAt(i) == '-') {
                operands.add(Integer.parseInt(expr.substring(begin, i)));
                operators.add(expr.charAt(i));
                begin = i + 1;
            }
        }
        operands.add(Integer.parseInt(expr.substring(begin)));


        long result = operands.remove(0);
        for (int i = 0; i < operators.size(); i++) {
            if (operators.get(i) == '-') {
                result -= operands.get(i);
                int current = i + 1;
                while (current < operators.size() && operators.get(current) == '+') {
                    result -= operands.get(current);
                    current++;
                }
                i = current - 1;
            } else {
                result += operands.get(i);
            }
        }

        System.out.println(result);
    }
}
