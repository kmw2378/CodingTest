package level2.saleevent;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        String[] wants = {"banana", "apple", "rice", "pork", "pot"};
        int[] numbers = {3, 2, 2, 2, 1};
        String[] discounts = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

        int answer = new Solution().solution(wants, numbers, discounts);
        System.out.println("answer = " + answer);
    }

}
class Solution {
    public int solution(String[] wants, int[] numbers, String[] discounts) {

        int answer = 0;
        for (int i = 0; i <= discounts.length - 10; i++) {

            int cnt = 0;
            int[] result = numbers.clone();

            for (int j = 0; j < 10; j++) {
                int index = findIndex(wants, discounts[i + j]);

                if (index == -1) {
                    break;
                }

                if (result[index] > 0) {
                    result[index]--;
                    cnt++;
                }
            }

            if (cnt == 10) {
                answer++;
            }
        }

        return answer;
    }
    private int findIndex(String[] wants, String discount) {

        for (int i = 0; i < wants.length; i++) {

            if (wants[i].equals(discount)) {
                return i;
            }
        }

        return -1;
    }
}