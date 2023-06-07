import java.util.*;

class Solution {
    public int solution(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> primeList = initPrimeList();
        for (int e : arr) {
            for (int prime : primeList) {
                if (prime > e) {
                    break;
                }
                
                int cnt = 0;
                while (e % prime == 0) {
                    cnt++;
                    e /= prime;
                }
                
                if (cnt > 0) {
                    if (!map.containsKey(prime) || map.get(prime) < cnt) {
                        map.put(prime, cnt);
                    }
                }
            }
        }
        
        int answer = 1;
        for (int prime : map.keySet()) {
            answer *= Math.pow(prime, map.get(prime));
        }
        
        return answer;
    }
    
    private boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    private List<Integer> initPrimeList() {
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= 97; i++) {
            if (isPrime(i)) {
                list.add(i);
            }
        }
        
        return list;
    }
}
