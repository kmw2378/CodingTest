import java.util.*;
import java.util.stream.Collectors;

class SolutionRefactorVer {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Queue<Info>> map = getStringQueueMap(genres, plays);
        List<String> keyList = getSortedKeyList(map);
        return getResultList(map, keyList);
    }

    private Map<String, Queue<Info>> getStringQueueMap(String[] genres, int[] plays) {
        Map<String, Queue<Info>> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            if (!map.containsKey(genres[i])) {
                map.put(genres[i], new PriorityQueue<>(Comparator.reverseOrder()));
            }
            map.get(genres[i]).add(new Info(i, plays[i]));
        }
        return map;
    }

    private List<String> getSortedKeyList(Map<String, Queue<Info>> map) {
        List<String> keyList = map.keySet().stream()
                .sorted((g1, g2) -> Integer.compare(
                        map.get(g2).stream().mapToInt(i -> i.play).sum(),
                        map.get(g1).stream().mapToInt(i -> i.play).sum()
                )).collect(Collectors.toList());
        return keyList;
    }

    private int[] getResultList(Map<String, Queue<Info>> map, List<String> keyList) {
        List<Integer> list = new ArrayList<>();
        for (String genre : keyList) {
            try {
                list.add(map.get(genre).poll().num);
                list.add(map.get(genre).poll().num);
            } catch (NullPointerException ignored) {}
        }
        return list.stream().mapToInt(e -> e).toArray();
    }

    static class Info implements Comparable<Info> {
        int num;
        int play;

        public Info(int num, int play) {
            this.num = num;
            this.play = play;
        }

        @Override
        public int compareTo(Info o) {
            if (this.play != o.play) {
                return this.play - o.play;
            }

            return o.num - this.num;
        }
    }
}
