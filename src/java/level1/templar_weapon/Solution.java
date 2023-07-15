class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            int cnt = getFactorCnt(i);
            answer += (cnt > limit ? power : cnt);
        }
        
        return answer;
    }
    
    private int getFactorCnt(int n) {
        int cnt = 0;
        for (int i = 1; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                cnt++;
            }
        }
        
        cnt *= 2;
        
        if ((int) Math.sqrt(n) * (int) Math.sqrt(n) == n) {
            cnt++;
        }
        
        return cnt;
    }
}
