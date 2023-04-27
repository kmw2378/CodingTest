package java.level2.joystick;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String name = "JEROEN";
        int result = new Solution().solution(name);
        System.out.println("result = " + result);
    }
}

class Solution {
    public int solution(String name) {
        List<String> list = Arrays.stream(name.split("")).collect(Collectors.toList());
        return forward(list);
    }

    private int forward(List<String> list) {
        int answer = 0;

        for (String s : list) {
            char c = s.charAt(0);
            answer += (1 + Math.min(c - 'A', 'Z' - c + 1));
        }

        return answer;
    }
}