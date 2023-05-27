class Solution {
    public int[] solution(int n, int[] info) {
        return rSolution(n, 0, info, new int[info.length]);
    }
    
    private int[] rSolution(int n, int round, int[] info, int[] result) {
        if (n < 0) {
            return new int[]{-1};
        }
        
        if (round == 11) {
            result[10] += n;
            n = 0;
        }
        
        if (n == 0) {
            return getDeviation(result, info) > 0 ? result : new int[]{-1};
        }
        
        int[] clone = result.clone();
        clone[round] = info[round] + 1;
        
        int[] arr1 = rSolution(n - clone[round], round + 1, info, clone);
        int[] arr2 = rSolution(n, round + 1, info, result.clone());
        
        if (getDeviation(arr1, info) > getDeviation(arr2, info)) {
            return arr1;
        } else if (getDeviation(arr1, info) == getDeviation(arr2, info)) {
            return compareResult(arr1, arr2);
        } else {
            return arr2;
        }
    }
    
    private int getDeviation(int[] result, int[] info) {
        int sum = 0;
        
        if (result.length == 1) {
            return -1;
        }
        
        for (int i = 0; i < info.length; i++) {
            if (result[i] == 0 && info[i] == 0) {
                continue;
            }
            
            sum += (result[i] > info[i] ? 10 - i : i - 10);
        }
        
        return sum;
    }
    
    private int[] compareResult(int[] arr1, int[] arr2) {
        for (int i = arr1.length - 1; i >= 0; i--) {
            if (arr1[i] > arr2[i]) {
                return arr1;
            } else if (arr1[i] == arr2[i]) {
                continue;
            } else {
                return arr2;
            }
        }
        
        return arr1;
    }
}
