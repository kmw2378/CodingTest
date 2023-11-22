import java.util.*;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public int solution(String dartResult) {
        Map<Character, Integer> bonusMap = initBonusMap();
        List<String> darts = createDarts(dartResult);
        Stack<Integer> stack = new Stack<>();
        for (String dart : darts) {
            char start = dart.charAt(0);
            if (!isNumeric(start)) {
                applyOption(start, stack);
                continue;
            }
            
            char bonus = getBonus(dart);
            int score = getScore(dart);
            int totalScore = (int) Math.pow(score, bonusMap.get(bonus));
            stack.add(totalScore);
            
            char end = dart.charAt(dart.length() - 1);
            if (end == '*' || end == '#') {
                applyOption(end, stack);
            }
        }

        return (int) stack.stream()
            .mapToInt(e -> e)
            .sum();
    }
    
    private boolean isNumeric(char c) {
        return '0' <= c && c <= '9';
    }
    
    private boolean isBonus(char c) {
        return c == 'S' || c == 'D' || c == 'T';
    }
    
    private List<String> createDarts(String dartResult) {
        List<String> darts = new ArrayList<>();
        int start = 0;
        for (int i = 1; i < dartResult.length() - 1; i++) {
            if (!isNumeric(dartResult.charAt(i - 1)) && isNumeric(dartResult.charAt(i))) {
                darts.add(dartResult.substring(start, i));
                start = i;
            }
        }
        
        darts.add(dartResult.substring(start));
        return darts;
    }
    
    private Map<Character, Integer> initBonusMap() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('S', 1);
        map.put('D', 2);
        map.put('T', 3);
        
        return map;
    }
    
    private void applyOption(char c, Stack<Integer> stack) {
        int pop = stack.pop();
        if (c == '#') {
            stack.add(-pop);
            return;
        }
        
        if (!stack.isEmpty()) {
            stack.add(stack.pop() * 2);
        }
        stack.add(pop * 2);
    }
    
    private int getScore(String dart) {
        int score = 0;
        for (char c : dart.toCharArray()) {
            if (!isNumeric(c)) {
                break;
            }
            
            score = score * 10 + (c - '0');
        }
        
        return score;
    }
    
    private char getBonus(String dart) {
        for (char c : dart.toCharArray()) {
            if (c == 'S' || c == 'D' || c == 'T') {
                return c;
            }
        }
        
        throw new IllegalArgumentException();
    }
}
