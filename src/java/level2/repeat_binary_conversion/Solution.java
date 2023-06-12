import java.util.*;

class Solution {
    public int[] solution(String s) {
        int cnt = 0;
        int removedZeroCnt = 0;
        while (!s.equals("1")) {
            int c = s.replaceAll("0", "").length();
            removedZeroCnt += (s.length() - c);
            s = Integer.toBinaryString(c);
            cnt++;
        }
        
        return new int[]{cnt, removedZeroCnt};
    }
}
