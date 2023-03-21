package javacode.level2.billiards;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int m = 10;
        int n = 10;
        int startX = 3;
        int startY = 7;
        int[][] balls = { {7, 7}, {2, 7}, {7, 3}};

        int[] result = new Solution().solution(m, n, startX, startY, balls);
        System.out.println("result = " + Arrays.toString(result));
    }
}
class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];

        for (int i = 0; i < balls.length; i++) {

            int endX = balls[i][0];
            int endY = balls[i][1];

            if (startX != endX && startY != endY) {
                answer[i] = getMinDistance(m, n, startX, startY, endX, endY);
            } else if (startX == endX){
                int distance = startY < endY ? getDistance(startX, startY, calculate3(endX, endY)) : getDistance(startX, startY, calculate4(n, endX, endY));
                answer[i] = Math.min(distance, m / 2 < endX ? getDistance(startX, startY, calculate2(m, endX, endY)) : getDistance(startX, startY, calculate1(endX, endY)));
            } else {
                int distance = startX < endX ? getDistance(startX, startY, calculate1(endX, endY)) : getDistance(startX, startY, calculate2(m, endX, endY));
                answer[i] = Math.min(distance, n / 2 < endY ? getDistance(startX, startY, calculate4(n, endX, endY)) : getDistance(startX, startY, calculate3(endX, endY)));
            }
        }

        return answer;
    }

    private int[] calculate1(int endX, int endY) {
        return new int[]{-endX, endY};
    }

    private int[] calculate2(int m, int endX, int endY) {
        return new int[]{m + (m - endX), endY};
    }

    private int[] calculate3(int endX, int endY) {
        return new int[]{endX, -endY};
    }

    private int[] calculate4(int n, int endX, int endY) {
        return new int[]{endX, n + (n - endY)};
    }

    private int getMinDistance(int m, int n, int startX, int startY, int endX, int endY) {

        int min = getDistance(startX, startY, calculate1(endX, endY));
        min = Math.min(min, getDistance(startX, startY, calculate2(m, endX, endY)));
        min = Math.min(min, getDistance(startX, startY, calculate3(endX, endY)));
        min = Math.min(min, getDistance(startX, startY, calculate4(n, endX, endY)));

        return min;
    }
    private int getDistance(int startX, int startY, int[] endPoint) {
        return (int) (Math.pow(startX - endPoint[0], 2) + Math.pow(startY - endPoint[1], 2));
    }
}