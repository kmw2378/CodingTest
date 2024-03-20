import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        final char[] characters = reader.readLine().toCharArray();
        final Map<Character, Integer> map = new HashMap<>();
        for (char character : characters) {
            map.put(character, map.getOrDefault(character, 0) + 1);
        }

        final int total = characters.length;
        System.out.println(recursive(total, 0, new ArrayList<>(), map));
    }

    private static int recursive(final int total,
                                 final int current,
                                 final List<Character> list,
                                 Map<Character, Integer> map) {
        if (current == total) {
            return 1;
        }
        final List<Character> collect = map.keySet().stream()
                .filter(character -> list.isEmpty() || list.get(list.size() - 1) != character)
                .collect(Collectors.toList());
        int count = 0;
        for (Character character : collect) {
            if (map.get(character) == 0) {
                continue;
            }
            list.add(character);
            map.put(character, map.get(character) - 1);
            count += recursive(total, current + 1, list, map);
            list.remove(list.size() - 1);
            map.put(character, map.get(character) + 1);
        }

        return count;
    }
}
