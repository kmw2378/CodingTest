package java.level2.dot;

public class Main {

    public static void main(String[] args) {
        int k = 1;
        int d = 5;
        long result = new Solution().solution(k, d);
        System.out.println("result = " + result);
    }
}
class Solution {
    public long solution(int k, int d) {
        long answer = 0;

        int a = 0;
        int b = 0;
        int maxA = 0;
        long powD = (long) d * (long) d;
        while (true) {

            if (a == 0) {
                while (getCurrentDistance(k, a, b) <= powD) {
                    b++;
                }
                b--; // b 값이 1 더 증가하는 것을 방지
                maxA = b;
            } else {
                while (b > 0 && getCurrentDistance(k, a, b) > powD) {
                    b--;
                }
            }

            answer += (b + 1);

            if (a == maxA) {
                return answer;
            }

            a++;
        }
    }

    private long getCurrentDistance(long k, long a, long b) {
        return k * k * (a * a +  b * b);
    }
}
