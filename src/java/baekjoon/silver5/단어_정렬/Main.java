package 백준.silver5.단어정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final int count = Integer.parseInt(reader.readLine());
        final Set<Word> set = new HashSet<>();
        for (int i = 1; i <= count; i++) {
            final String value = reader.readLine();
            set.add(new Word(value));
        }

        final Queue<Word> queue = new PriorityQueue<>(set);
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

    static class Word implements Comparable<Word> {
        final String value;

        public Word(final String value) {
            this.value = value;
        }

        @Override
        public int compareTo(final Word other) {
            if (value.length() != other.value.length()) {
                return Integer.compare(value.length(), other.value.length());
            }

            return value.compareTo(other.value);
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }

            if (!(object instanceof Word)) {
                return false;
            }

            final Word other = (Word) object;
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return value.hashCode();
        }

        @Override
        public String toString() {
            return value;
        }
    }
}
