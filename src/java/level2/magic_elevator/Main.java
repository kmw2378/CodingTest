package java.level2.magic_elevator;

public class Main {

    public static void main(String[] args) {

        int storey = 10000000;

        int result = new Solution().solution(storey);
        System.out.println("result = " + result);
    }
}
class Solution {

    public int solution(int storey) {

        int c = getPowersOf10(storey) * 10;

        return Math.min(1 + getResult(c - storey) , getResult(storey));
    }

    private int getResult(int storey) {

        int digitValue = getPowersOf10(storey);

        if (digitValue == 1) {
            return storey;
        } else if (storey % digitValue == 0) {
            return storey / digitValue;
        }

        System.out.println(storey);

        return Math.min(
                convertToRockCount(storey / digitValue + 1) + solution(digitValue - storey % digitValue),
                convertToRockCount(storey / digitValue) + solution(storey % digitValue)
        );
    }

    private int convertToRockCount(int n) {
        return n / 10 + n % 10;
    }

    private int getPowersOf10(int i) {

        if (i == 0) {
            return 0;
        }

        return (int) Math.pow(10, (int)Math.log10(i));
    }
}