package java.level2.parcelbox;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        int[] orders = {5, 4, 3, 2, 1};
        int answer = new Solution().solution(orders);

        System.out.println("answer = " + answer);
    }
}
class Solution {
    public int solution(int[] orders) {

        Queue<Integer> truck = new LinkedList<>();
        Stack<Integer> tempContainer = new Stack<>();
        int boxNumber = 1;

        for (int order : orders) {

            while (boxNumber <= order) {
                tempContainer.add(boxNumber++);
            }

            if (tempContainer.peek() == order) {
                truck.add(tempContainer.pop());
            } else {
                return truck.size();
            }
        }

        return truck.size();
    }
}