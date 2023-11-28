import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        return Arrays.stream(numbers)
            .map(this::getResult)
            .toArray();
    }
    
    private Long getResult(long number) {
        String binary = Long.toBinaryString(number);
        if (binary.charAt(binary.length() - 1) == '0') {
            return Long.parseLong(binary.substring(0, binary.length() - 1) + "1", 2);
        }
        
        binary = "0" + binary;
        int i = binary.lastIndexOf("01");
        if (i == -1) {
            int j = binary.lastIndexOf("0");
            return Long.parseLong(binary.substring(0, j) + "1" + binary.substring(j + 1), 2);
        }
        
        return Long.parseLong(binary.substring(0, i) + "10" + binary.substring(i + 2), 2);
    }
}
