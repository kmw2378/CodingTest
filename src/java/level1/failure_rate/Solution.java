import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int N, int[] stages) {
        PriorityQueue<Integer> queue = Arrays.stream(stages).boxed().distinct().collect(Collectors.toCollection(PriorityQueue::new));
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= N + 1; i++) {
            map.put(i, 0);
        }
        
        for (int stage : stages) {
            map.put(stage, map.get(stage) + 1);
        }
        
        List<User> users = new ArrayList<>();
        int length = stages.length;
        for (int num = 1; num <= N; num++) {
            int current = map.get(num);
            users.add(new User(current, length, num));
            length -= current;
        }
        
        return users.stream().sorted((u1, u2) -> u1.compareTo(u2)).mapToInt(u -> u.num).toArray();
    }
    
    static class User implements Comparable<User> {
        int current;
        int length;
        int num;
        
        public User(int current, int length, int num) {
            this.current = current;
            this.length = length;
            this.num = num;
        }
        
        @Override
        public int compareTo(User user) {
            if (user.current * (long)this.length != this.current * (long)user.length) {
                return Long.compare(user.current * (long)this.length, this.current * (long)user.length);
            }
            
            return Integer.compare(this.num, user.num);
        }
    }
}
