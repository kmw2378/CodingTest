package level1.year;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();
        String answer = solution.solution(5, 20);

        System.out.println("answer = " + answer);
    }
}
class Solution {
    public String solution(int a, int b) {

        String[] weeks = { "SUN", "MON" ,"TUE", "WED", "THU", "FRI", "SAT"};
        int[] days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int sum = 0;
        for (int i = 0; i < a - 1; i++) {
            sum += days[i];
        }

        sum += b;

        return weeks[(sum + 4) % 7];
    }
}