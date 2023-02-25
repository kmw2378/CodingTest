package level2.lineupway;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int n = 4;
        long k = 18;
        int[] answer = new Solution().solution(n, k);

        System.out.println("answer = " + Arrays.toString(answer));
    }
}
class Solution {
    public int[] solution(int n, long k) {
        int[] result = new int[n];
        List<Integer> people = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            people.add(i);
        }

        int completedIdx = 0;
        long currentCasesCnt = factorial(n - 1);

        for (int i = 1; i <= n; i++) {

            int sequence = (int) (k / currentCasesCnt);
            k %= currentCasesCnt;

            if (k % currentCasesCnt == 0) {
                sequence--;
                k = currentCasesCnt;
            }

            result[completedIdx++] = people.remove(sequence);
            currentCasesCnt /= (n - i);

            if (k == 1) {
                break;
            }
        }

        for (int i = completedIdx; i < n; i++) {
            result[i] = people.remove(0);
        }

        return result;
    }
    
    private long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        return result;
    }
}