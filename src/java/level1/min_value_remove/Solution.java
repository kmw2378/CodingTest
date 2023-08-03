import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1) {
            return new int[]{-1};
        }
        
        int min = Arrays.stream(arr).boxed().min(Integer::compareTo).get();
        return Arrays.stream(arr).boxed().filter(e -> e > min).mapToInt(e -> e).toArray();
    }
}
