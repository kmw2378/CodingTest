package java.level2.primecnt;

public class Main {

    public static void main(String[] args) {
        int n = 1012031203;
        int k = 8;

        Solution solution = new Solution();
        int answer = solution.solution(n, k);
        System.out.println("answer = " + answer);
    }
}
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        StringBuilder stringBuilder = new StringBuilder();

        while (true) {
            stringBuilder.append(n % k);
            n /= k;

            if (n < k) {
                stringBuilder.append(n);
                break;
            }
        }

        String[] split = stringBuilder.reverse().toString().split("0");

        for (String s : split) {

            if (s.equals("")) {
                continue;
            }

            if (isPrimeNumber(Long.parseLong(s))) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isPrimeNumber(long element) {

        if (element == 1) {
            return false;
        }

        for (long i = 2; i < Math.sqrt(element); i++) {

            if (element % i == 0) {
                return false;
            }
        }

        return true;
    }
}