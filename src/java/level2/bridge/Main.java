package java.level2.bridge;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};

        int answer = solution.solution(bridge_length, weight, truck_weights);
        System.out.println("answer = " + answer);
    }
}
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int currentIdx = 0;

        Queue<Integer> timeQueue = new LinkedList<>();
        Queue<Integer> moveQueue = new LinkedList<>();

        while (true) {

            // 다리를 지난 트럭 제거
            while (!timeQueue.isEmpty() && timeQueue.peek() + bridge_length == answer) {
                moveQueue.remove();
                timeQueue.remove();
            }

            // 이제 다리를 건너기 시작할 트럭 추가
            if (currentIdx < truck_weights.length && moveQueue.size() < bridge_length && getSum(moveQueue) + truck_weights[currentIdx] <= weight) {
                moveQueue.add(truck_weights[currentIdx++]);
                timeQueue.add(answer);
            }

            if (moveQueue.isEmpty()) {
                return answer + 1;  // 다리를 지나가는 트럭이 비었다는 것은 다음 시행에서 끝나므로 +1을 해준다.
            }

            answer++;
        }
    }

    /**
     * 큐의 원소들의 합을 반환하는 메소드
     * @param queue
     * @return 원소들의 합
     */
    private int getSum(Queue<Integer> queue) {

        int sum = 0;
        for (Integer integer : queue) {
            sum += integer;
        }

        return sum;
    }
}