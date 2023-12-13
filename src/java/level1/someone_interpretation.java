import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 0);
        map.put(2, 0);
        map.put(3, 0);
        int[] student2Answers = {1, 3, 4, 5};
        int[] student3Answers = {3, 1, 2, 4, 5};

        for (int i = 0; i < answers.length; i++) {
            if (((i + 1) % 5 == 0 ? 5 : (i + 1) % 5) == answers[i]) {
                map.put(1, map.get(1) + 1);
            }

            if ((i + 1) % 2 == 1) {
                if (answers[i] == 2) {
                    map.put(2, map.get(2) + 1);
                }
            } else {
                int j = ((i + 1) / 2) % 4 == 0 ? 4 : ((i + 1) / 2) % 4;
                if (student2Answers[j - 1] == answers[i]) {
                    map.put(2, map.get(2) + 1);
                }
            }

            if (student3Answers[(((i + 1) % 10 == 0 ? 10 : (i + 1) % 10) + 1) / 2 - 1] == answers[i]) {
                map.put(3, map.get(3) + 1);
            }
        }

        int max = map.keySet().stream()
            .max((a, b) -> Integer.compare(map.get(a), map.get(b)))
            .map(map::get)
            .orElseThrow(IllegalStateException::new);

        return map.keySet().stream()
            .filter(k -> map.get(k).equals(max))
            .mapToInt(e -> e)
            .toArray();
    }
}
