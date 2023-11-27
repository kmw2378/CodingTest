class Solution {
    public int[] solution(int[][] arr) {
        int[] result = new int[2];
        rSolution(result, arr, 0, 0, arr.length);
        return result;
    }
    
    private void rSolution(int[] result, int[][] arr, int x, int y, int size) {
        if (compressible(arr, x, y, size, arr[x][y])) {
            result[arr[x][y]]++;
            return;
        }
        
        rSolution(result, arr, x, y, size / 2);
        rSolution(result, arr, x, y + size / 2, size / 2);
        rSolution(result, arr, x + size / 2, y, size / 2);
        rSolution(result, arr, x + size / 2, y + size / 2, size / 2);
    }
    
    private boolean compressible(int[][] arr, int x, int y, int size, int value) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != value) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
