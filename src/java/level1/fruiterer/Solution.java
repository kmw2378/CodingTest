import java.util.*;

class Solution {
    public int solution(int k, int m, int[] scores) {
        int answer = 0;
        int begin = scores.length % m;
        
        Arrays.sort(scores);
        for (int i = begin; i < scores.length; i += m) {
            answer += (scores[i] * m);
        }
        
        return answer;
    }
}
