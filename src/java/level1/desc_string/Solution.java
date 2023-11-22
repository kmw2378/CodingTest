import java.util.Arrays;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(s.split(""))
            .sorted((a, b) -> b.compareTo(a))
            .forEach(w -> sb.append(w));

        return sb.toString();
    }
}
