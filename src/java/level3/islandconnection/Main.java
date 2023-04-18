package java.level3.islandconnection;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {

        int n = 4;
        int[][] costs = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};
        int result = new Solution().solution(n, costs);

        System.out.println("result = " + result);
    }
}
class Solution {
    public int solution(int n, int[][] infos) {
        return primJarnik(n, infos);
    }

    private int[][] initMatrix(int n, int[][] infos) {
        int[][] matrix = new int[n][n];

        for (int[] array : infos) {
            int start = Math.min(array[0], array[1]);
            int end = Math.max(array[0], array[1]);
            int cost = array[2];

            matrix[start][end] = cost;
            matrix[end][start] = cost;
        }
        return matrix;
    }

    private int primJarnik(int n, int[][] infos) {

        int[][] matrix = initMatrix(n, infos);
        List<Vertex> vertices = initVertices(n);

        vertices.get(0).distance = 0;
        PriorityQueue<Vertex> queue = new PriorityQueue<>(vertices);

        while (!queue.isEmpty()) {
            Vertex u = queue.poll();

            for (int i = 0; i < n; i++) {
                if (matrix[u.num][i] == 0) {
                    continue;
                }

                Vertex z = vertices.get(i);
                int cost = matrix[u.num][i];

                if (queue.contains(z) && cost < z.distance) {
                    z.distance = cost;
                    queue.remove(z);
                    queue.add(z);
                }
            }
        }

        return vertices.stream().mapToInt(v -> v.distance).sum();
    }

    private List<Vertex> initVertices(int n) {
        List<Vertex> vertices = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            vertices.add(new Vertex(i));
        }
        return vertices;
    }

    static class Vertex implements Comparable<Vertex> {
        int num;
        int distance;

        public Vertex(int num) {
            this.num = num;
            this.distance = Integer.MAX_VALUE;
        }

        @Override
        public int compareTo(Vertex vertex) {
            return this.distance - vertex.distance;
        }
    }
}