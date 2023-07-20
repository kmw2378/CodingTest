import java.util.*;
import java.util.stream.Collectors;
import java.util.Arrays;

class Solution {
    public String[] solution(String[] strings, int n) {
        PriorityQueue<Info> queue = Arrays.stream(strings).map(s -> new Info(n, s)).collect(Collectors.toCollection(PriorityQueue::new));
        
        List<String> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            list.add(queue.poll().s);
        }
        
        return list.stream().toArray(String[]::new);
    }
    
    static class Info implements Comparable<Info> {
        int n;
        String s;
        
        public Info(int n, String s) {
            this.n = n;
            this.s = s;
        }
        
        @Override
        public int compareTo(Info o) {
            if (s.charAt(n) != o.s.charAt(n)) {
                return s.charAt(n) - o.s.charAt(n);
            }
            
            return s.compareTo(o.s);
        }
    }
}
