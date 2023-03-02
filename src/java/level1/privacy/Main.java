package java.level1.privacy;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        int[] result = solution.solution(today, terms, privacies);
        System.out.println(Arrays.toString(result));
    }
}

/**
 * <가정>
 * 모든 달은 28일
 * <약관>
 * A : 6달
 * B : 12달
 * C : 3달
 */
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = { };
        List<Integer> notValidList = new ArrayList<>();

        // 현재 날짜를 Date 객체로 변환
        Date date = new Date(today);

        // 약관 종류별 유효 기간을 저장할 Map 자료형
        Map<String, Integer> typeAndValidDateMap = new HashMap<>();

        // 약관 종류별 유효 기간 저장
        for (String term : terms) {
            String[] splitTerm = term.split(" ");
            typeAndValidDateMap.put(splitTerm[0], Integer.parseInt(splitTerm[1]));
        }

        int number = 1;

        for (String privacy : privacies) {
            String[] splitPrivacy = privacy.split(" ");

            Date currentDate = new Date(splitPrivacy[0]);
            Integer month = typeAndValidDateMap.get(splitPrivacy[1]);

            currentDate.addMonth(month);

            if (!currentDate.isValidFromToday(date)) {
                notValidList.add(number);
            }

            number++;
        }

        return notValidList.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}
class Date {

    int year;
    int month;
    int day;

    public Date(String string) {
        String[] splitToday = string.split("\\.");

        year = Integer.parseInt(splitToday[0]);
        month = Integer.parseInt(splitToday[1]);
        day = Integer.parseInt(splitToday[2]);
    }

    public void addMonth(int month) {

        int year = month / 12;
        month %= 12;

        if (year > 0) {
            this.year += year;
        }

        this.month += month;

        if (this.month > 12) {
            this.year++;
            this.month =  this.month % 13 + 1;
        }
    }

    public boolean isValidFromToday(Date today) {

        boolean result;

        if (this.year == today.year) {
            if (this.month == today.month) {
                result = this.day > today.day;
            } else {
                result = this.month > today.month;
            }
        } else {
            result = this.year > today.year;
        }

        return result;
    }
}