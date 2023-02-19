package level2.stringcompression;

public class Main {

    public static void main(String[] args) {

        String s = "aabaaabaaabaaab";
        int answer = new Solution().solution(s);

        System.out.println("answer = " + answer);
    }
}
class Solution {
    public int solution(String s) {

        int min = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            int length = getParseLength(s, i);
            min = Math.min(min, length);
        }

        return min;
    }

    private int getParseLength(String s, int length) {

        StringBuilder result = new StringBuilder();

        String beforeSubstring = s.substring(0, length);
        int count = 1;

        for (int i = length; i <= s.length() - length; i += length) {
            String substring = s.substring(i, i + length);

            if (beforeSubstring.equals(substring)) {
                count++;
            } else {

                if (count > 1) {
                    result.append(count);
                }

                result.append(beforeSubstring);
                count = 1;
            }

            beforeSubstring = substring;
        }

        if (count > 1) {
            result.append(count);
        }

        result.append(beforeSubstring);
        result.append(s.substring(s.length() - s.length() % length));

        return result.length();
    }
}