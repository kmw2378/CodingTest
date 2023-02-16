package level2.stockprice;

import java.util.Arrays;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] prices = {10, 3, 5, 5, 3, 4, 1, 2};
        int[] result = solution.solution(prices);

        System.out.println("result = " + Arrays.toString(result));
    }
}
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<Integer> stack = new Stack<>();
        stack.add(0);

        for (int i = 1; i < prices.length; i++) {

            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int currentIdx = stack.pop();
                answer[currentIdx] = i - currentIdx;
            }
            stack.add(i);
        }

        for (int i = 0; i < answer.length - 1; i++) {

            if (answer[i] == 0) {
                answer[i] = answer.length - i - 1;
            }
        }

        return answer;
    }
}