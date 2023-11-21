import java.util.stream.IntStream;
import java.util.Arrays;

class Solution {
    public int[] solution(int num, int total) {
        int start = IntStream.range(-1000, 1000)
            .filter(e -> num * e + num * (num - 1) / 2 == total)
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);

        return IntStream.range(start, start + num)
            .toArray();
    }
}
