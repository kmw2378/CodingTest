package java.level1.keyboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        String[] keymap = {"ABACD", "BCEFD"};
        String[] targets = {"ABCD","AABB"};
        int[] result = new Solution().solution(keymap, targets);
        System.out.println("result = " + Arrays.toString(result));
    }
}
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        List<Word> wordList = getWords(keymap);

        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            char[] charArray = target.toCharArray();
            for (char c : charArray) {
                Word word = wordList.stream().filter(w -> w.word.equals(String.valueOf(c))).findFirst().orElse(null);
                if (word == null) {
                    return new int[]{-1};
                }

                answer[i] += word.index;
            }
        }
        return answer;
    }

    private List<Word> getWords(String[] keymap) {
        List<Word> wordList = new ArrayList<>();

        for (String s : keymap) {
            char[] charArray = s.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                char c = charArray[i];
                wordList.add(new Word(i + 1, String.valueOf(c)));
            }
        }

        return wordList.stream().sorted(Comparator.comparingInt(a -> a.index)).distinct().collect(Collectors.toList());
    }

    static class Word {
        int index;
        String word;

        public Word(int index, String word) {
            this.index = index;
            this.word = word;
        }

        public void replace(int index) {
            this.index = Math.min(this.index, index);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Word word1 = (Word) o;
            return Objects.equals(word, word1.word);
        }

        @Override
        public int hashCode() {
            return Objects.hash(word);
        }

        @Override
        public String toString() {
            return "Word{" +
                    "index=" + index +
                    ", word='" + word + '\'' +
                    '}';
        }
    }
}