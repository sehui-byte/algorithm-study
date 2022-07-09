import java.util.Arrays;
import java.util.Scanner;

public class BOJ2805 {

    static int[] trees;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        trees = new int[n];
        for (int i = 0; i < n; i++) {
            trees[i] = sc.nextInt();
        }
        Arrays.sort(trees);
        int first = 0;
        int last = Arrays.stream(trees).max().getAsInt(); //최대 높이의 나무
        int middle = (last + first) / 2;
        long result = findResult(trees, middle);

        while (first <= last) {
            if (result < m) {
                // 더 조금 잘라야 하니 왼쪽으로
                last = middle - 1;
            } else {
                // 더 많이 잘라야 하니 오른쪽으로
                first = middle + 1;
            }
            middle = (last + first) / 2;
            result = findResult(trees, middle);
        }
        System.out.println(middle);
    }

    public static long findResult(int[] trees, int h) {
        long result = 0;
        for (int tree : trees) {
            //음수인 경우는 더하지 않는다
            result += (Math.max((tree - h), 0));
        }
        return result;
    }
}
