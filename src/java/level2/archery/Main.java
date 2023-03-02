package java.level2.archery;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        int n = 9;

//        int[] info = {2,1,1,1,0,0,0,0,0,0,0};
//        int[] info = {0,0,0,0,0,0,0,0,3,4,3};
        int[] info = {0,0,1,2,0,1,1,1,1,1,1};
        int[] answer = new Solution().solution(n, info);
        System.out.println("answer = " + Arrays.toString(answer));
    }
}
class Solution {

    /**
     *
     * @param n 화살의 개수
     * @param info 어피치가 맞힌 과녁 점수
     * @return 라이언이 가장 큰 점수 차이로 우승하기 위한 과녁 점수
     */
    public int[] solution(int n, int[] info) {
        Stack<Integer> stack = new Stack<>();

        int count = n;
        int start = 0;
        int max = 0;

        while (start < info.length) {

            int apeachTotalScore = getScore(info);
            int sum = 0;

            for (int i = start; i < info.length; i++) {

                int currentArrowCnt = info[i] + 1;

                if (count - currentArrowCnt > 0) {
                    count -= currentArrowCnt;
                    stack.push(i);

                    sum += (10 - i);
                    if (info[i] != 0) {
                        apeachTotalScore -= (10 - i);
                    }
                }

                if (checkReplacement(info, stack.peek(), i) && count - info[stack.peek()] + info[i] >= 0) {

                    sum -= (10 - stack.peek());
                    sum += (10 - i);
                    if (info[i] != 0) {
                        apeachTotalScore -= (10 - i);
                    }

                    stack.pop();
                    stack.push(i);
                }
            }

            int pop = stack.pop();
            int currentIdx = pop + 1;
            int cntSum = info[currentIdx] + 1;

            Queue<Integer> queue = new LinkedList<>();
            while (checkReplacement(info, pop, currentIdx) && count - info[pop] + 1 - cntSum >= 0) {
                queue.add(currentIdx);
                cntSum += (info[currentIdx++] + 1);
            }

            if (currentIdx == pop + 1) {
                stack.push(pop);
            }

            int diff = sum - apeachTotalScore;

            if (max < diff) {
                max = diff;
                System.out.println("diff = " + diff);
                System.out.println("stack = " + stack);
            }

            start++;
        }

        return null;
    }

    private boolean checkReplacement(int[] info, int last, int current) {

        int lastDiff = 10 - last;
        int currentDiff = 10 - current;

        if (info[last] > 0) {
            lastDiff *= 2;
        }

        if (info[current] > 0) {
            currentDiff *= 2;
        }

        return lastDiff < currentDiff;
    }

    private int getScore(int[] info) {

        int sum = 0;

        for (int i = 0; i < info.length; i++) {
            if (info[i] != 0) {
                sum += (10 - i);
            }
        }

        return sum;
    }
}