package java.level2.fatigue;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        int k = 80;
        int[][] dungeons = { {80, 20}, {50, 40}, {30, 10}};
        int result = new Solution().solution(k, dungeons);

        System.out.println("result = " + result);
    }
}

class Solution {

    public int solution(int k, int[][] dungeons) {

        LinkedList<DungeonFatigue> dungeonFatigues = new LinkedList<>();
        for (int[] dungeon : dungeons) {
            dungeonFatigues.add(new DungeonFatigue(dungeon));
        }

        return rSolution(k, dungeonFatigues);
    }

    private int rSolution(int k, LinkedList<DungeonFatigue> dungeonFatigues) {

        if (k <= 0) {
            return 0;
        }

        int maxCnt = 0;
        for (DungeonFatigue dungeonFatigue : dungeonFatigues) {
            if (k >= dungeonFatigue.min) {
                LinkedList<DungeonFatigue> list = new LinkedList<>(dungeonFatigues);
                list.remove(dungeonFatigue);

                maxCnt = Math.max(maxCnt, 1 + rSolution(k - dungeonFatigue.consumption, list));
            }
        }

        return maxCnt;
    }

    static class DungeonFatigue {
        int min;
        int consumption;

        public DungeonFatigue(int[] dungeon) {
            this.min = dungeon[0];
            this.consumption = dungeon[1];
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DungeonFatigue that = (DungeonFatigue) o;
            return min == that.min && consumption == that.consumption;
        }
    }
}