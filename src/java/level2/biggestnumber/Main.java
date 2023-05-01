package java.level2.biggestnumber;

public class Main {

    public static void main(String[] args) {
        int[] numbers = {727, 72};
        String result = new Solution().solution(numbers);
        System.out.println("result = " + result);
    }
}

//23 232 23232
//=> 3 > 2
//
//89 898
//=> 9 > 8
//
//727 72
//=> 7 < 2

class Solution {
    public String solution(int[] numbers) {

        int[] intArray = new int[1001];
        for (int number : numbers) {
            intArray[number]++;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 999; i >= 100; i--) {
            if (equalsAllDigits(i)) {
                refactor(intArray, stringBuilder, i / 100);
                refactor(intArray, stringBuilder, i / 10);
                refactor(intArray, stringBuilder, i);
            }
            else if (equalsBothEndsDigit(i)) {
                if (i / 10 % 10 > i / 100) {
                    refactor(intArray, stringBuilder, i / 10);
                    refactor(intArray, stringBuilder, i);
                } else {
                    refactor(intArray, stringBuilder, i);
                    refactor(intArray, stringBuilder, i / 10);
                }
            } else {
                refactor(intArray, stringBuilder, i);
            }
        }

        refactor(intArray, stringBuilder, 1000);

        if (stringBuilder.isEmpty()) {
            return "0";
        }
        refactor(intArray, stringBuilder, 0);
        return stringBuilder.toString();
    }

    private void refactor(int[] intArray, StringBuilder stringBuilder, int i) {
        stringBuilder.append(String.valueOf(i).repeat(Math.max(0, intArray[i])));
        intArray[i] = 0;
    }

    private boolean equalsBothEndsDigit(int i) {
        return i / 100 == i % 10;
    }

    private boolean equalsAllDigits(int i) {
        return (i / 100 == i / 10 % 10) && (i / 100 == i % 10);
    }
}