package java.level2.convertbrackets;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        String p = "()))((()";
        String result = new Solution().solution(p);

        System.out.println("result = " + result);
    }
}
class Solution {
    public String solution(String w) {

        if (w.isEmpty()) {
            return "";
        }

        String[] split = w.split("");
        List<String> u = new ArrayList<>();
        List<String> v = new ArrayList<>();

        int leftBracketCnt = 0;
        int rightBracketCnt = 0;
        int i = 0;
        do {
            if (split[i].equals("(")) {
                leftBracketCnt++;
            } else {
                rightBracketCnt++;
            }
            u.add(split[i++]);
        } while (leftBracketCnt != rightBracketCnt);

        while (i < w.length()) {
            v.add(split[i++]);
        }

        if (isCorrectBracketsString(u)) {
            return listToString(u) + solution(listToString(v));
        } else {
            return "(" + solution(listToString(v)) + ")" + removeLastAndReverseBrackets(u);
        }
    }

    private boolean isCorrectBracketsString(List<String> u) {

        if (!u.get(0).equals("(")) {
            return false;
        }

        Stack<String> stack = new Stack<>();
        stack.add(u.get(0));

        for (String s : u) {

            if (stack.isEmpty() && s.equals(")")) {
                return false;
            }

            if (s.equals("(")) {
                stack.add(s);
            } else {
                stack.pop();
            }
        }

        return true;
    }

    private String listToString(List<String> v) {

        StringBuilder stringBuilder = new StringBuilder();
        for (String s : v) {
            stringBuilder.append(s);
        }

        return stringBuilder.toString();
    }

    private String removeLastAndReverseBrackets(List<String> u) {
        u.remove(0);
        u.remove(u.size() - 1);
        return listToString(u.stream().map(this::bracketsMapper).collect(Collectors.toList()));
    }

    private String bracketsMapper(String e) {
        return e.equals("(") ? ")" : "(";
    }
}