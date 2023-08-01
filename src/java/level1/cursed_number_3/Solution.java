class Solution {
    public int solution(int n) {
        int answer = 1;
        for (int i = 1; i <= n; i++) {
            while (contains(answer++));
        }
        
        return answer - 1;
    }
    
    private boolean contains(int n) {
        if (n % 3 == 0) {
            return true;
        }
        
        while (n > 0) {
            if (n % 10 == 3) {
                return true;
            }
            
            n /= 10;
        }
        
        return false;
    }
}
