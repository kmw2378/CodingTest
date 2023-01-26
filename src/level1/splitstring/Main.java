package level1.splitstring;

public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int result = solution.solution("abracadabra");
        System.out.println(result);
    }
}
class Solution {
    public int solution(String s) {
        int answer = 0;

        String currentString = s;

        while (true) {
            int i = 0;
            char x = currentString.charAt(i++);
            int xCount = 1;
            int notXCount = 0;

            while (xCount != notXCount && i < currentString.length()) {

                if (currentString.charAt(i) != x) {
                    notXCount++;
                } else {
                    xCount++;
                }

                i++;
            }

            answer++;
            currentString = currentString.substring(i);

            if (currentString.length() == 0) {
                break;
            }
        }

        return answer;
    }
}