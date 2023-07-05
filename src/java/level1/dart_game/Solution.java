import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        List<String> list = new ArrayList<>();
        
        int begin = 0;
        for (int i = 1; i < dartResult.length(); i++) {
            char before = dartResult.charAt(i - 1);
            char current = dartResult.charAt(i);
            if (!isScore(before) && isScore(current)) {
                list.add(dartResult.substring(begin, i));
                begin = i;
            }
        }
        
        list.add(dartResult.substring(begin));
        
        int before = 0;
        for (String s : list) {
            int score = 0;
            int i = 0;
            while (isScore(s.charAt(i))) {
                score = score * 10 + (int)(s.charAt(i++) - '0');
            }
            
            char bonus = s.charAt(i);
            int currentScore = getCurrentScore(score, bonus);
            record[i] = currentScore;
            
            if (i == s.length() - 1) {
                answer += currentScore;
                continue;
            }
            
            char option = s.charAt(s.length() - 1);
            if (option == '*') {
                
                answer += (2 * (before + currentScore));
            } else {
                answer -= currentScore;
            }
        }
        
        return answer;
    }
    
    private boolean isScore(char c) {
        return '0' <= c && c <= '9';
    }
    
    private int getBonus(char c) {
        if (c == 'S') {
            return 1;
        }
        
        if (c == 'D') {
            return 2;
        }
        
        return 3;
    }
    
    private int getCurrentScore(int score, char bonus) {
        return (int)Math.pow(score, getBonus(bonus));
    }
    
    private boolean isBonus(char c) {
        return c == 'S' || c == 'D' || c == 'T';
    }
}
