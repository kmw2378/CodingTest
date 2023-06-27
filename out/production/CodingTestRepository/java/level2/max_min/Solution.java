import java.util.*;
import java.util.Comparator;

class Solution {
    public String solution(String s) {
        Queue<Integer> q1 = new PriorityQueue<>();
        Queue<Integer> q2 = new PriorityQueue<>(Comparator.reverseOrder());
        String[] split = s.split(" ");
        
        for (String s1 : split) {
            if (s1.charAt(0) == '-') {
                q1.add(-1 * Integer.parseInt(s1.substring(1)));
                q2.add(-1 * Integer.parseInt(s1.substring(1)));
            } else {
                q1.add(Integer.parseInt(s1));
                q2.add(Integer.parseInt(s1));
            }
        }
        
        return String.valueOf(q1.peek()) + " " + String.valueOf(q2.peek());
    }
}
