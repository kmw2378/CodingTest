import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final Set<Integer> set = new TreeSet<>();
        for (int i = 1; i <= n; i++) {
            final int e = scanner.nextInt();
            set.add(e);
        }

        final int m = scanner.nextInt();
        for (int i = 1; i <= m; i++) {
            final int e = scanner.nextInt();
            System.out.println(set.contains(e) ? 1 : 0);
        }
    }
}
