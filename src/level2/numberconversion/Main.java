package level2.numberconversion;

public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int x = 10;
        int y = 40;
        int n = 5;
        int answer = solution.solution(x, y, n);

        System.out.println("answer = " + answer);
    }
}
class Solution {

    boolean isCalculable;
    public Solution() {
        isCalculable = false;
    }

    public int solution(int x, int y, int n) {
        return isCalculable ? recursion_solution(x, y, n) : -1;
    }

    public int recursion_solution(int x, int y, int n) {

        if (x == y) {
            isCalculable = true;
            return 0;
        } else if (x > y) {
            return 0;
        } else {
            return getMin(1 + recursion_solution(x + n, y, n), 1 + recursion_solution(x * 2, y, n), 1 + recursion_solution(x * 3, y, n));
        }
    }

    private int getMin(int a, int b, int c) {

        if (a < b && a < c) {
            return a;
        }

        if (b < a && b < c) {
            return b;
        }

        return c;
    }
}