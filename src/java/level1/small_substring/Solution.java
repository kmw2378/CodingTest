import java.util.stream.IntStream;

class Solution {
    public int solution(String t, String p) {
        int digit = p.length();
        long max = Long.parseLong(p);
        return (int) IntStream.range(0, t.length() - digit + 1)
            .filter(i -> Long.parseLong(t.substring(i, i + digit)) <= max)
            .count();
    }
}
