package java.level1.character;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

//        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        String[] survey = {"TR", "RT", "TR"};
//        int[] choices = {5, 3, 2, 7, 5};
        int[] choices = {7, 1, 3};

        String answer = solution.solution(survey, choices);
        System.out.println("answer = " + answer);
    }
}

/**
 * survey : "RT", "TR", "FC", "CF", "MJ", "JM", "AN", "NA"
 * chocies : 1, 2, 3, 4, 5, 6, 7
 */
class Solution {

    public Solution() {
        initMapList();
    }

    Map<String, Integer> characterTypeCheckMapList = new HashMap<>();

    public String solution(String[] survey, int[] choices) {

        StringBuilder answer = new StringBuilder();

        int loopSize = survey.length;

        for (int i = 0; i < loopSize; i++) {

            String currentSurvey = getSortedString(survey[i]);
            int score = currentSurvey.equals(survey[i]) ? 4 - choices[i] : choices[i] - 4;

            score += characterTypeCheckMapList.get(currentSurvey);
            characterTypeCheckMapList.replace(currentSurvey, score);
        }

        for (String key : characterTypeCheckMapList.keySet()) {

            if (characterTypeCheckMapList.get(key) >= 0) {
                answer.append(key.charAt(0));
            } else {
                answer.append(key.charAt(1));
            }
        }

        return answer.toString();
    }

    private String getSortedString(String survey) {
        char[] charArray = survey.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    private void initMapList() {
        characterTypeCheckMapList.put("RT", 0);
        characterTypeCheckMapList.put("CF", 0);
        characterTypeCheckMapList.put("JM", 0);
        characterTypeCheckMapList.put("AN", 0);
    }
}