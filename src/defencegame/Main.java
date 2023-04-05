package defencegame;

import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {

//        int n = 7;
//        int k = 3;
//        int[] enemies = {4, 2, 4, 5, 3, 3, 1};
        int n = 22;
        int k = 6;
        int[] enemies = {10, 1, 3, 41, 3, 13, 6, 4, 3, 5, 3, 5, 7, 5, 10, 15, 2, 3};
//        int n = 5;
//        int k = 3;
//        int[] enemies = {4, 3, 4, 1, 2, 5, 3};
        int result = new Solution().solution(n, k, enemies);

        System.out.println("result = " + result);
    }
}
class Solution {
    public int solution(int n, int k, int[] enemies) {

        if (k >= enemies.length) {
            return enemies.length;
        }

        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < enemies.length; i++) {
            int enemy = enemies[i];
            n -= enemy;
            queue.add(-enemy);

            if (n < 0) {
                if (queue.isEmpty() || k == 0) {
                    return i;
                }
                n -= queue.poll();
                k--;
            }
        }

        return enemies.length;
    }
}