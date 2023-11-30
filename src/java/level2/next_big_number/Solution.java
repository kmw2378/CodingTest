class Solution {
    public int solution(int n) {
        String binary = Integer.toBinaryString(n);
        int count = getCount(n);
        for (int i = n + 1; i <= 1_000_000; i++) {
            if (getCount(i) == count) {
                return i;
            }
        }
        
        throw new IllegalArgumentException();
    }
    
    private int getCount(int n) {
        int count = 0;
        while (n > 0) {
            if (n % 2 == 1) {
                count++;
            }
            n /= 2;
        }
        
        return count;
    }
}
