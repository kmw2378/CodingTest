package java.level3.palindrome;

public class Main {

    public static void main(String[] args) {

        String s = "abbadc";
        int answer = new Solution().solution(s);

        System.out.println("answer = " + answer);
    }
}
class Solution {
    public int solution(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            max = Math.max(max, getPalindromeLengthOddCase(s, i));
        }

        return max;
    }

    private int getPalindromeLengthOddCase(String s, int n) {

        char[] charArray = s.toCharArray();
        int idx = 1;

        while (n - idx >= 0 && n + idx <= s.length() - 1) {

            if (charArray[n - idx] != charArray[n + idx]) {
                break;
            }

            idx++;
        }

        return (idx - 1) * 2 + 1;
    }
}