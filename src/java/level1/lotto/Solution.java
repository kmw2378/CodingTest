import java.util.*;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        Set<Integer> set = new HashSet<>(createList(win_nums));
        List<Integer> lottoList = createList(lottos)
            .stream()
            .filter(e -> e != 0)
            .collect(Collectors.toList());
        set.addAll(lottoList);
        
        int uncertainCount = 6 - lottoList.size();
        int matchedCount = 12 - uncertainCount - set.size();
        return new int[]{Math.min(Math.max(7 - matchedCount - uncertainCount, 1), 6), Math.min(7 - matchedCount, 6)};
    }
    
    private List<Integer> createList(int[] arr) {
        return Arrays.stream(arr)
            .boxed()
            .collect(Collectors.toList());
    }
}
