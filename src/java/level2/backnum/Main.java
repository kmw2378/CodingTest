package java.level2.backnum;

import java.util.Arrays;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

//        int[] numbers = {2, 3, 3, 5};
        int[] numbers = {9, 1, 5, 3, 6, 2};
        int[] answer = new Solution().solution(numbers);

        System.out.println("answer = " + Arrays.toString(answer));
    }
}
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numbers.length; i++) {

            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }

            stack.push(i);
        }

        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == 0) {
                answer[i] = -1;
            }
        }

        return answer;
    }
}