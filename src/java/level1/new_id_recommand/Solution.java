import java.util.*;

class Solution {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < new_id.length(); i++) {
            char c = new_id.charAt(i);
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '.' && c == '.') {
                continue;
            }
            
            if (
                ('a' <= c && c <= 'z') ||
                ('0' <= c && c <= '9') ||
                c == '-' ||
                c == '_' ||
                c == '.'
            ) {
                sb.append(c);
            }
        }
        
        if (sb.charAt(0) == '.') {
            sb.deleteCharAt(0);
        }
        
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '.') {
            sb.deleteCharAt(sb.length() - 1);
        }
        
        
        if (sb.length() == 0) {
            sb.append('a');
        }
        
        if (sb.length() >= 16) {
            String s = sb.substring(0, 15);
            sb.setLength(0);
            sb.append(s);
            if (sb.charAt(sb.length() - 1) == '.') {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        
        while (sb.length() <= 2) {
            sb.append(sb.charAt(sb.length() - 1));
        }
        
        return sb.toString();
    }
}
