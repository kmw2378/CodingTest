import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> list = new ArrayList<>();
        Map<String, Queue<Info>> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            
            String genre = genres[i];
            int play = plays[i];
            
            if (!map.containsKey(genre)) {
                map.put(genre, new PriorityQueue<>(Comparator.reverseOrder()));
            }
            
            map.get(genre).add(new Info(i, play));
        }
        
        List<String> keyList = map.keySet().stream()
            .sorted(
                (g1, g2) -> Integer.compare(getSum(map.get(g2)), getSum(map.get(g1)))
            )
            .collect(Collectors.toList());
        
        for (String genre : keyList) {
            Queue<Info> queue = map.get(genre);
            
            if (queue.isEmpty()) {
                continue;
            }
            list.add(map.get(genre).poll().num);
            
            if (queue.isEmpty()) {
                continue;
            }
            list.add(map.get(genre).poll().num);
        }
        
        return list.stream().mapToInt(e -> e).toArray();
    }
            
    private int getSum(Queue<Info> queue) {
        
        int sum = 0;
        for (Info info : queue) {
            sum += info.play;
        }
        
        return sum;
    }
    
    static class Info implements Comparable<Info> {
        int num;
        int play;
        
        public Info(int num, int play) {
            this.num = num;
            this.play = play;
        }
        
        @Override
        public int compareTo(Info o) {
            if (this.play != o.play) {
                return this.play - o.play;
            }
            
            return o.num - this.num;
        } 
    }
}
