import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class BOJ1302 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int max = 0;

        Map<String, Integer> m = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String title = sc.nextLine();
            int count = m.getOrDefault(title, 0);
            m.put(title, ++count);
            if (count > max) max = count;
        }

        for (String key : m.keySet()) {
            if (max == m.get(key)) {
                System.out.println(key);
                break;
            }
        }
    }
}
