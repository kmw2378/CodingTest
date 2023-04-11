package java.level3.numbergame;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        int[] A = {5, 1, 3, 7};
        int[] B = {2, 2, 6 ,8};

        int result = new Solution().solution(A, B);
        System.out.println("result = " + result);
    }
}
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int e : A) {
            queue.add(e);
        }

        LinkedList<Integer> list = Arrays.stream(B).boxed().sorted(Integer::compareTo).collect(Collectors.toCollection(LinkedList::new));

        while (!queue.isEmpty()) {
            int poll = queue.poll();

            if (list.getLast() <= poll) {
                list.removeFirst();
            } else {
                list.removeLast();
                answer++;
            }
        }

        return answer;
    }
}