import java.util.*;
import java.util.Comparator;

class Solution {
    public String solution(String X, String Y) {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            char c = (char)(i + '0');
            arr[i] = Math.min(count(X, c), count(Y, c));
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            if (arr[i] == 0) {
                continue;
            }
            
            sb.append(String.valueOf(i).repeat(arr[i]));
        }
        
        if (sb.length() == 0) {
            sb.append(-1);
        }
        
        if (sb.charAt(0) == '0') {
            return "0";
        }

        return sb.toString();
    }
    
    private int count(String s, char c) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                cnt++;
            }
        }
        
        return cnt;
    }
}
