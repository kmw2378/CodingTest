package level2.functiondevelope;

import java.util.*;

public class Main {

    public static void main(String[] args) {

//        int[] progresses = {93, 30, 55};
        int[] progresses = {95, 90, 99, 99, 80, 99};
//        int[] speeds = {1, 30, 5};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        Solution solution = new Solution();
        int[] result = solution.solution(progresses, speeds);
        System.out.println("result = " + Arrays.toString(result));
    }
}

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        int currentProcessScheduleIdx = 0;

        while (true) {

            boolean isCompleted = true;

            for (int i = 0; i < progresses.length; i++) {
                progresses[i] += speeds[i];

                if (progresses[i] < 100) {
                    isCompleted = false;
                } else if (progresses[i] >= 100 && currentProcessScheduleIdx == i) {
                    stack.push(i);
                    currentProcessScheduleIdx++;
                }
            }

            if (!stack.isEmpty()) {
                list.add(stack.size());
                stack.clear();
            }

            if (isCompleted) {
                break;
            }
        }

        return list.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}