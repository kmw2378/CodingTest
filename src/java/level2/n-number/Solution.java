import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder stringBuilder = new StringBuilder();
        int k = 0;
        while (stringBuilder.length() < m * t) {
            stringBuilder.append(getNDigit(n, k++));
        }
        
        while (stringBuilder.length() > m * t) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        
        StringBuilder result = new StringBuilder();
        for (int i = p; i <= stringBuilder.length(); i += m) {
            result.append(stringBuilder.charAt(i - 1));
        }
        
        return result.toString();
    }
    
    private String getNDigit(int n, int i) {
        if (i == 0) {
            return "0";
        }
        
        StringBuilder stringBuilder = new StringBuilder();
        while (i > 0) {
            String s = i % n > 9 ? String.valueOf((char)(i % n - 10 + 'A')) : String.valueOf(i % n);
            stringBuilder.insert(0, s);
            i /= n;
        }
        
        return stringBuilder.toString();
    }
}
