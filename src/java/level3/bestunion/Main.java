package java.level3.bestunion;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int n = 2;
        int s = 8;
        int[] result = new Solution().solution(n, s);
        System.out.println("result = " + Arrays.toString(result));
    }
}
class Solution {
    public int[] solution(int n, int s) {
        if (s < n) {
            return new int[]{-1};
        }

        int[] answer = new int[n];
        while (true) {
            int remain = s;
            int current = s > n ? s / n : 1;

            for (int i = 0; i < n; i++) {
                answer[n - i - 1] += current;
                remain -= current;
                if (remain == 0) {
                    return answer;
                }
            }
            s %= n;
        }
    }
}