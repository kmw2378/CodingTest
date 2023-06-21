import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = toLowerCase(s.charAt(i));
            if (i == 0 || (i > 0 && s.charAt(i - 1) == ' ')) {
                c = toUpperChar(c);
            }
            
            sb.append(c);
        }
        
        return sb.toString();
    }
    
    private char toUpperChar(char c) {
        return 'a' <= c && c <= 'z' ? (char)(c - 'a' + 'A') : c;
    }
    
    private char toLowerCase(char c) {
        return 'A' <= c && c <= 'Z' ? (char)(c - 'A' + 'a') : c;
    }
}
