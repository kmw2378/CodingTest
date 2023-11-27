import java.util.*;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.Comparator;

class Solution {
    public long solution(String expression) {
        Queue<Long> queue = new PriorityQueue<>(Comparator.reverseOrder());
        createOperators().forEach(o -> queue.add(getTotalResult(getExpressionList(expression), o)));
        return queue.peek();
    }
    
    private List<List<String>> createOperators() {
        List<List<String>> operators = new ArrayList<>();
        operators.add(List.of("*", "+", "-"));
        operators.add(List.of("*", "-", "+"));
        operators.add(List.of("+", "*", "-"));
        operators.add(List.of("+", "-", "*"));
        operators.add(List.of("-", "+", "*"));
        operators.add(List.of("-", "*", "+"));
        
        return operators;
    }
    
    private long getTotalResult(List<String> list, List<String> operators) {
        for (String operator : operators) {
            list = getSingleResult(list, operator);
        }
        
        return Math.abs(list.stream()
            .mapToLong(Long::parseLong)
            .sum());
    }
    
    private List<String> getSingleResult(List<String> list, String operator) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (s.equals(operator)) {
                stack.push(String.valueOf(getCaculationResult(stack.pop(), operator, list.get(i + 1))));
                i++;
            } else {
                stack.push(list.get(i));
            }
        }
            
        return stack.stream()
            .collect(Collectors.toList());
    }
    
    private List<String> getExpressionList(String expression) {
        List<String> list = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (isOperator(c)) {
                list.add(expression.substring(start, i));
                list.add(expression.substring(i, i + 1));
                start = i + 1;
            }
        }
        
        list.add(expression.substring(start));
        return list;
    }
    
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
    
    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
    
    private long getCaculationResult(String s1, String op, String s2) {
        long x = Long.parseLong(s1);
        long y = Long.parseLong(s2);
        
        if (op.equals("+")) {
            return x + y;
        } else if (op.equals("-")) {
            return x - y;
        } else if (op.equals("*")) {
            return x * y;
        } else if (op.equals("/")) {
            return x / y;
        }
        
        throw new IllegalArgumentException();
    }
}
