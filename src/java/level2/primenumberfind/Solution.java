class Solution {
    public int solution(String numbers) {
        int answer = 0;
        
        int[] ints = new int[10];
        String[] split = numbers.split("");
        for (String s : split) {
            ints[Integer.parseInt(s)]++;
        }
        
        for (int i = 2; i < 10000000; i++) {       
            if (isPrime(i) && isContain(ints, i)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean isPrime(int n) {
        
        if (n == 1) {
            return false;
        }
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean isContain(int[] ints, int k) {
        
        int[] temp = ints.clone();
        
        while (k > 0) {
            if (temp[k % 10] == 0) {
                return false;
            }
            
            temp[k % 10]--;
            k /= 10;
        }
        
        return true;
    }
}
