package java.level2.integral;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int k = 5;
        int[][] ranges = {{0, 0}, {0, -1}, {2, -3}, {3, -3}};

        double[] result = new Solution().solution(k, ranges);

        System.out.println("result = " + Arrays.toString(result));
    }
}
class Solution {
    public double[] solution(int k, int[][] ranges) {

        List<Double> result = new LinkedList<>();

        List<Integer> points = getCollatzConjecturePoints(k);

        for (int[] range : ranges) {

            int start = range[0];
            int end = points.size() - 1 + range[1];

            double area = 0;
            if (start > end || end >= points.size()) {
                area = -1;
            } else {
                for (int i = start; i < end; i++) {
                    int minY = Math.min(points.get(i), points.get(i + 1));
                    int maxY = Math.max(points.get(i), points.get(i + 1));

                    area += (minY + (maxY - minY) / 2.);
                }
            }

            result.add(area);
        }
        return result.stream().mapToDouble(e -> e).toArray();
    }

    private List<Integer> getCollatzConjecturePoints(int k) {

        List<Integer> points = new LinkedList<>();

        while (true) {
            points.add(k);

            if (k == 1) {
                break;
            } else if (k % 2 == 0) {
                k /= 2;
            } else {
                k = 3 * k + 1;
            }
        }

        return points;
    }
}