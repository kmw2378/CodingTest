package java.level2.numbercarddivide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

//        int[] arrayA = {14, 35, 119};
//        int[] arrayB = {18, 30, 102};
        int[] arrayA = {10, 20};
        int[] arrayB = {5, 17};
        int result = new Solution().solution(arrayA, arrayB);
        System.out.println("result = " + result);
    }
}
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        return Math.max(getResult(arrayA, arrayB), getResult(arrayB, arrayA));
    }

    private int getResult(int[] arrayA, int[] arrayB) {
        PriorityQueue<Integer> queueA = Arrays.stream(arrayA).boxed().collect(Collectors.toCollection(PriorityQueue::new));
        int min = queueA.poll();
        List<Integer> factors = getFactors(min);
        int result = 0;
        PriorityQueue<Integer> queueB = Arrays.stream(arrayB).boxed().collect(Collectors.toCollection(PriorityQueue::new));
        for (Integer factor : factors) {

            boolean isMultiple = true;
            boolean isNotMultiple = true;

            for (Integer e : queueA) {
                if (e % factor != 0) {
                    isMultiple = false;
                    break;
                }
            }

            if (!isMultiple) {
                continue;
            }

            for (Integer e : queueB) {
                if (e % factor == 0) {
                    isNotMultiple = false;
                    break;
                }
            }

            if (isNotMultiple) {
                result = Math.max(result, factor);
            }
        }
        return result;
    }

    private List<Integer> getFactors(int n) {

        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i < n; i++) {

            if (n % i == 0) {
                factors.add(i);
            }
        }

        factors.add(n);
        return factors;
    }
}
