package java.level3.basestationinstallation;

public class Main {

    public static void main(String[] args) {

//        int n = 16;
//        int[] stations = {9};
//        int w = 2;

        int n = 11;
        int[] stations = {4, 11};
        int w = 1;

        int result = new Solution().solution(n, stations, w);

        System.out.println("result = " + result);
    }
}
class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int appliedArea = 2 * w + 1;
        int start = 1;
        for (int station : stations) {
            int newStart = Math.max(station - w, 1);
            int newEnd = Math.min(station + w, n);

            if (newStart > start) {
                int length = newStart - start;
                answer += (length / appliedArea + (length % appliedArea == 0 ? 0 : 1));
            }
            start = newEnd + 1;
        }

        if (start < n) {
            int length = n - start;
            answer += (length / appliedArea + (length % appliedArea == 0 ? 0 : 1));
        }

        return answer;
    }
}