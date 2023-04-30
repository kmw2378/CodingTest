package java.level2.onetwofourcountry;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        int n = 9;
        String result1 = new Solution().solution(11);
        String result2 = new Solution().solution(10);

        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
    }
}
class Solution {
    public String solution(int n) {
        LinkedList<Integer> list = new LinkedList<>();
        int[] nums = {1, 2, 4};
        if (n <= 3) {
            return String.valueOf(nums[n - 1]);
        }

        int digit = getDigit(n);
        int start = getSum(digit - 1) + 1;
        int diff = n - start;
        while (list.size() < digit) {
            list.addFirst(nums[diff % 3]);
            diff /= 3;
        }

        return listToString(list);
    }

    private int getDigit(int n) {
        for (int i = 1;;i++) {
            int sum = getSum(i);
            if (sum > n) {
                return i;
            }
        }
    }
    private int getSequence(int n) {
        return (int) Math.pow(3, n);
    }

    private int getSum(int n) {
        return 3 * (getSequence(n) - 1) / 2;
    }

    private String listToString(LinkedList<Integer> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int e : list) {
            stringBuilder.append(e);
        }

        return stringBuilder.toString();
    }
}