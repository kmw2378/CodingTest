class Solution {
    public int solution(int n) {
        int answer = 0;
        int st = 1;
        int ed = 1;
        int sum = 0;
        while (st <= n) {
            while (sum < n) {
                sum += (ed++);
            }

            while (sum > n) {
                sum -= (st++);
            }
            
            if (n == sum) {
                answer++;
                sum -= (st++);
            }
        }
        
        return answer;
    }
}
