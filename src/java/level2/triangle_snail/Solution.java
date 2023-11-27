import java.util.Arrays;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int n) {
        int[][] arr = new int[n][];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[i + 1];
        }
        
        int current = 1;
        int depth = 0;
        while (current <= n * (n + 1) / 2) {
            for (int i = 1; i <= n - depth * 3; i++) {
                arr[i - 1 + depth * 2][depth] = current++;
            }
            
            for (int i = 1; i <= n - depth * 3 - 1; i++) {
                arr[n - 1 - depth][i + depth] = current++;
            }
            
            for (int i = 1; i <= n - depth * 3 - 2; i++) {
                arr[n - i - depth - 1][n - i - depth * 2 - 1] = current++;
            }
            
            depth++;
        }
        
        List<Integer> list = new ArrayList<>();
        Arrays.stream(arr)
            .forEach(a -> list.addAll(getList(a)));

        return list.stream()
            .mapToInt(e -> e)
            .toArray();
    }
    
    private List<Integer> getList(int[] arr) {
        return Arrays.stream(arr)
            .boxed()
            .collect(Collectors.toList());
    }
}
