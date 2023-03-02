package java.level2.skilltree;

public class Main {

    public static void main(String[] args) {

        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        int answer = new Solution().solution(skill, skill_trees);

        System.out.println("answer = " + answer);
    }
}
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String skill_tree : skill_trees) {

            boolean isValid = false;

            char[] skillTreeArray = skill_tree.toCharArray();
            for (char c : skillTreeArray) {
                if (!skill.contains(String.valueOf(c))) {
                    skill_tree = skill_tree.replaceAll(String.valueOf(c), "");
                }
            }

            System.out.println("skill_tree = " + skill_tree);

            for (int i = 0; i < skill.length() + 1; i++) {

                if (skill_tree.equals(skill.substring(0, i))) {
                    isValid = true;
                    break;
                }
            }

            if (isValid) {
                answer++;
            }
        }

        return answer;
    }
}