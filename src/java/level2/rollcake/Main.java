package java.level2.rollcake;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
        int result = new Solution().solution(topping);
        System.out.println("result = " + result);
    }
}
class Solution {
    public int solution(int[] topping) {
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int e : topping) {
            if (map.containsKey(e)) {
                map.replace(e, map.get(e) + 1);
            } else {
                map.put(e, 1);
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int e : topping) {

            if (map.containsKey(e)) {

                if (map.get(e) == 1) {
                    map.remove(e);
                } else {
                    map.replace(e, map.get(e) - 1);
                }
            }

            set.add(e);

            if (map.size() == set.size()) {
                answer++;
            }
        }

        return answer;
    }
}