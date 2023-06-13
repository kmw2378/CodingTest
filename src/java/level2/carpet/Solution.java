class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        for (int y = 2; y <= Math.sqrt(total); y++) {
            if (total % y != 0) {
                continue;
            }
            
            int x = total / y;
            if (total - (x - 2) * (y - 2) == brown) {
                return new int[]{x, y};
            }
        }
        
        return null;
    }
}
