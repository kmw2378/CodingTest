package java.level2.seesaw;

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

        int[] countArray = new int[901];
        for (int weight : weights) {
            countArray[weight - 100]++;

        }

        for (int i = 100; i <= 1000; i++) {

            if (countArray[i - 100] == 0) {
                continue;
            }

            answer += (countArray[i - 100] <= 1 ? 0 : (getCombination(countArray[i - 100])));

            if (i * 2 <= 1000) {
                answer += ((long) countArray[i * 2 - 100] * countArray[i - 100]);
            }
            if (i % 2 == 0) {
                if (i / 2 * 3 <= 1000) {
                    answer += ((long) countArray[i / 2 * 3 - 100] * countArray[i - 100]);
                }
            }
            if (i % 3 == 0) {
                if (i / 3 * 4 <= 1000) {
                    answer += ((long) countArray[i / 3 * 4 - 100] * countArray[i - 100]);
                }
            }
        }
        return answer;
    }

    private long getCombination(int n) {
        return (long) n * (n - 1) / 2;
    }
}