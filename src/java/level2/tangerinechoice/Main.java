package java.level2.tangerinechoice;

import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {

        int[] tangerines = {1, 3, 2, 5, 4, 5, 2, 3};
        int k = 4;

        int result = new Solution().solution(k ,tangerines);
        System.out.println("result = " + result);
    }
}
class Solution {
    public int solution(int k, int[] tangerines) {

        int[] cnts = new int[10000000];
        for (int tangerine : tangerines) {
            cnts[tangerine - 1]++;
        }

        Queue<Integer> queue = new PriorityQueue<>();
        for (int cnt : cnts) {
            if (cnt == 0) {
                continue;
            }

            queue.add(cnt);
        }

        int excludeCnt = tangerines.length - k;

        while (excludeCnt > 0 && !queue.isEmpty()) {
            excludeCnt -= queue.poll();
        }

        if (excludeCnt < 0) {
            return queue.size() + 1;
        }

        return queue.size();
    }
}