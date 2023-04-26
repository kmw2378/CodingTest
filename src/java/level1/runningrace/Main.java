package java.level1.runningrace;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        String[] result = new Solution().solution(players, callings);
        System.out.println("result = " + Arrays.toString(result));
    }
}
class Solution {
    public String[] solution(String[] players, String[] callings) {

        Map<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for (String calling : callings) {
            int current = map.get(calling);
            map.replace(calling, current - 1);
            map.replace(players[current - 1], current);
            swap(players, current);
        }

        return players;
    }

    private void swap(String[] players, int i) {
        String temp = players[i];
        players[i] = players[i - 1];
        players[i - 1] = temp;
    }
}