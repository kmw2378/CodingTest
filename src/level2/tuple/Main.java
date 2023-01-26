package level2.tuple;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        MySolution solution = new MySolution();

        String s = "33{{{2";
        String s1 = s.replaceAll("[{]", "");

        int[] result = solution.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
        System.out.println("result = " + Arrays.toString(result));
    }
}
class Solution {
    public int[] solution(String s) {
        Map<Integer, Integer> tupleMapList = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        String substring = s.substring(2, s.length() - 2);
        String[] splitStrings = substring.split(",");

        for (String splitString : splitStrings) {

            int currentNumber = getCurrentNumber(splitString);

            if (tupleMapList.containsKey(currentNumber)) {
                int value = tupleMapList.get(currentNumber);
                tupleMapList.replace(currentNumber, value + 1);
            } else {
                tupleMapList.put(currentNumber, 1);
            }
        }

        LinkedList<Map.Entry<Integer, Integer>> entryLinkedList = new LinkedList<>(tupleMapList.entrySet());
        entryLinkedList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        for (Map.Entry<Integer, Integer> integerIntegerEntry : entryLinkedList) {
            result.add(integerIntegerEntry.getKey());
        }

        return result.stream()
                .mapToInt(i -> i)
                .toArray();
    }

    private int getCurrentNumber(String splitString) {
        return Integer.parseInt(splitString.replaceAll("\\{", "").replaceAll("}", ""));
    }
}
class MySolution {
    public int[] solution(String s) {

        Set<String> set = new HashSet<>();
        String[] splitArray = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
        System.out.println("splitArray = " + Arrays.toString(splitArray));

        Arrays.sort(splitArray, Comparator.comparingInt(String::length));
        int[] answer = new int[splitArray.length];
        int idx = 0;

        for (String s1 : splitArray) {

            for (String s2 : s1.split(",")) {
                if (set.add(s2)) {
                    answer[idx++] = Integer.parseInt(s2);
                }
            }
        }

        return answer;
    }
}
