package java.level2.sequencesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        int[] sequence1 = {1, 2, 3, 4, 5};
//        int k1 = 7;
//        int[] sequence2 = {1, 1, 1, 2, 3, 4, 5};
//        int k2 = 5;
        int[] sequence3 = {2, 2, 2, 2, 2};
        int k3 = 6;

//        int[] result2 = new Solution().solution(sequence2, k2);
//        int[] result1 = new Solution().solution(sequence1, k1);
        int[] result3 = new Solution().solution(sequence3, k3);

//        System.out.println("result = " + Arrays.toString(result2));
//        System.out.println("result = " + Arrays.toString(result1));
        System.out.println("result = " + Arrays.toString(result3));
    }
}
class Solution {
    public int[] solution(int[] sequence, int k) {

        int[] result = {0, sequence.length};

        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] == k) {
                result[0] = i;
                result[1] = i;
                return result;
            }
        }

        List<Integer> accumSums = new ArrayList<>();
        accumSums.add(0);
        int sum = 0;
        for (int value : sequence) {
            sum += value;
            accumSums.add(sum);
        }

        int left = 0;
        int right = 0;
        int minLength = sequence.length + 1;
        while (left <= right && right < accumSums.size()){
            sum = accumSums.get(right) - accumSums.get(left);
            if (sum == k) {
                int length = right - 1 - left;
                if (minLength > length) {
                    result[0] = left;
                    result[1] = right - 1;
                    minLength = length;
                }
            }

            if (sum < k) {
                right++;
            } else {
                left++;
            }
        }

        return result;
    }
}