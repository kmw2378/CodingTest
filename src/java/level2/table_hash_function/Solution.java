import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[][] datas, int col, int row_begin, int row_end) {
        List<Info> list = Arrays.stream(datas).map(d -> new Info(d, col)).sorted().collect(Collectors.toList());
        
        int answer = list.get(row_begin - 1).getSum(row_begin);
        for (int i = row_begin + 1; i <= row_end; i++) {
            answer ^= list.get(i - 1).getSum(i);
        }
        return answer;
    }
    
    static class Info implements Comparable<Info> {
        int[] data;
        int standard;
        
        public Info(int[] data, int standard) {
            this.data = data;
            this.standard = standard;
        }
        
        public int getSum(int r) {
            return Arrays.stream(data).boxed().mapToInt(e -> e % r).sum();
        }
        
        @Override
        public int compareTo(Info o) {
            if (data[standard - 1] != o.data[standard - 1]) {
                return data[standard - 1] - o.data[standard - 1];
            }   
            
            return o.data[0] - data[0];
        }
    }
}
