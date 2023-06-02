import java.util.*;

class Solution {
    public int solution(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (correct(i, s)) {
                cnt++;
            }
        }
        
        return cnt;
    }
    
    private boolean correct(int n, String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = n; i < s.length() + n; i++) {
            char c = s.charAt(i % s.length());
            if (c == '[' || c == '{' || c == '(') {
                stack.add(c);
                continue;
            }
            
            if (stack.isEmpty()) {
                return false;
            }
            
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(stack.pop());
            stringBuilder.append(c);
            if (!stringBuilder.toString().equals("()") &&
               !stringBuilder.toString().equals("{}") &&
               !stringBuilder.toString().equals("[]")) {
                return false;
            }
        }
        
        return stack.isEmpty();
    }
}
