package baekjoon.silver1.후보_추천하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        final int frameCount = inputInteger();
        final int studentCount = inputInteger();
        final List<Integer> ids = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        final Frame frame = new Frame(frameCount);
        ids.forEach(frame::add);
        System.out.println(frame);
    }

    private static int inputInteger() throws IOException {
        return Integer.parseInt(reader.readLine());
    }
}

class Frame {
    private final Map<Integer, Student> map = new HashMap<>();
    private final List<Student> list = new ArrayList<>();
    private final int total;

    public Frame(final int total) {
        this.total = total;
    }

    public void add(final int id) {
        if (map.containsKey(id)) {
            map.get(id).addRecommendedCount();
        } else {
            if (map.size() == total) {
                Collections.sort(list);
                map.remove(list.get(0).getId());
                list.remove(0);
            }
            final Student student = new Student(id);
            map.put(id, student);
            list.add(student);
        }
    }

    @Override
    public String toString() {
        final List<String> values = list.stream()
                .map(Student::getId)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.toList());
        return String.join(" ", values);
    }
}

class Student implements Comparable<Student> {
    private static int createAtSequence = 0;
    private final int id;
    private int recommendedCount;
    private final int createdAt;

    public Student(final int id) {
        this.id = id;
        this.recommendedCount = 1;
        this.createdAt = createAtSequence++;
    }

    public void addRecommendedCount() {
        recommendedCount++;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final Student student = (Student) o;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", recommendedCount=" + recommendedCount +
                ", createdAt=" + createdAt +
                '}';
    }

    @Override
    public int compareTo(final Student student) {
        if (recommendedCount == student.recommendedCount) {
            return Integer.compare(createdAt, student.createdAt);
        }

        return Integer.compare(recommendedCount, student.recommendedCount);
    }
}
