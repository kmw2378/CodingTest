package java.level2.seesaw;

import java.util.Iterator;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        int[] weights = {100, 180, 360, 100, 270};
        long answer = new Solution().solution(weights);
        System.out.println("answer = " + answer);
    }
}
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int weight : weights) {
            stack.push(weight);
        }

        for (int weight : weights) {

            int isContainDuplicatedElementCnt = 0;

            Iterator<Integer> iterator = stack.iterator();
            while (iterator.hasNext()) {
                if (iterator.next() == weight) {
                    iterator.remove();
                    isContainDuplicatedElementCnt++;
                }
            }

            if (isContainDuplicatedElementCnt > 1) {
                answer++;
            }

            stack.push(weight);
        }

        System.out.println("stack = " + stack);

        while (!stack.isEmpty()) {

            int pop = stack.pop();

            if (pop % 2 == 0) {
                // 4, 2
                if (stack.contains(pop / 2)) {
                    answer++;
                }

                // 2, 3
                if (stack.contains((pop / 2) * 3)) {
                    answer++;
                }
            }

            // 2, 4
            if (stack.contains(pop * 2)) {
                answer++;
            }

            if (pop % 3 == 0) {
                // 3, 2
                if (stack.contains((pop * 2) / 3)) {
                    answer++;
                }

                // 3, 4
                if (stack.contains((pop * 4) / 3)) {
                    answer++;
                }
            }

            // 4, 3
            if (pop % 4 == 0) {
                if (stack.contains((pop / 4) * 3)) {
                    answer++;
                }
            }
        }

        return answer;
    }
}