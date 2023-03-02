package java.level2.cache1;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

        int runtime = solution.solution(cacheSize, cities);
        System.out.println("실행시간 = " + runtime);
    }
}

/**
 * hit : 1
 * miss : 5
 */
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        return answer;
    }
}