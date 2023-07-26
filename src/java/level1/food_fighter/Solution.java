import java.util.*;

class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < food.length; i++) {
            sb.append(String.valueOf(i).repeat(food[i] / 2));
        }

        String r = new StringBuilder(sb.toString()).reverse().toString();
        sb.append(0);
        sb.append(r);
        
        return sb.toString();
    }
}
