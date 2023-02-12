package level1.twopassword;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();

        String s = "aukks";
        String skip = "wbqd";
        int index = 5;

        String answer = solution.solution(s, skip, index);
    }
}
class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();

        char[] charArray = s.toCharArray();
        for (char c : charArray) {

            int cnt = 0;
            while (cnt < index) {
                c = (char) ((c + - 'a' + 1) % 26 + 'a');
                if (!isContain(skip, c)) {
                    cnt++;
                }
            }

            answer.append(c);
        }

        return answer.toString();
    }

    private boolean isContain(String skip, char c) {
        char[] charArray = skip.toCharArray();
        for (char c1 : charArray) {
            if (c1 == c) {
                return true;
            }
        }

        return false;
    }
}