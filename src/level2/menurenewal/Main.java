package level2.menurenewal;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] courses = {2, 3, 4};

        Solution solution = new Solution();
        String[] solution1 = solution.solution(orders, courses);

        System.out.println(Arrays.toString(solution1));
    }
}

/**
 * 코스요리 메뉴는 최소 2가지 이상의 단품메뉴로 구성
 * 각 손님은 단품메뉴를 2개 이상 주문해야 하며, 각 단품메뉴는 A ~ Z의 알파벳 대문자로 표기
 */
class Solution {
    public String[] solution(String[] orders, int[] courses) {

        List<String> alphabetList = new ArrayList<>();

         // 단품메뉴 조합에서 포함되는 모든 메뉴 조합
        for (String order : orders) {
            alphabetList.addAll(Arrays.asList(order.split("")));
        }

        List<String> collect = alphabetList.stream().distinct().sorted().collect(Collectors.toList());
        Map<String, Integer> result = new HashMap<>();

        for (int course : courses) {
            List<String> subSet = createSubSet(collect, course);
            int max = 0;
            List<String> currentString = new ArrayList<>();
            for (String s : subSet) {

                int cnt = 0;
                for (String order : orders) {
                    if (isContain(order, s)) {
                        cnt++;
                    }
                }

                if (max < cnt && cnt >= 2) {
                    max = cnt;
                    currentString.clear();
                    currentString.add(s);
                } else if (max == cnt) {
                    currentString.add(s);
                }
            }

            if (max > 0) {
                for (String s : currentString) {
                    result.put(s, max);
                }
            }
        }

        return result.keySet().stream()
                .sorted().toArray(String[]::new);
    }

    private boolean isContain(String str, String regex) {

        String[] split = regex.split("");

        for (String s : split) {
            if (!str.contains(s)) {
                return false;
            }
        }

        return true;
    }

    private List<String> createSubSet(List<String> list, int length) {

        List<String> subList = new ArrayList<>();

        for (int i = 0; i < 1 << list.size(); i++) {
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < list.size(); j++) {
                if ((i & 1 << j) != 0) {
                    str.append(list.get(j));
                }
            }
            subList.add(str.toString());
        }

        return subList.stream()
                .filter(e -> e.length() == length)
                .collect(Collectors.toList());
    }
}