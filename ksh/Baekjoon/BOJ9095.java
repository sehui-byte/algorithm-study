import java.util.Scanner;

/*
* 분류 : DP
* */
public class BOJ9095 {
    static int[] table = new int[11];

    public static void main(String[] args) {
        table[1] = 1;
        table[2] = 2; // 1+1, 2
        table[3] = 4; // 2+1, 1+2, 1+1+1, 3
//        table[4] = 7; // 1+1+1+1, 2+2, 2+1+1, 1+2+1, 1+1+2, 3+1, 1+3

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nn = new int[n];
        for (int i = 0; i < n; i++) {
            nn[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            System.out.println(recur(nn[i]));
        }
    }

    public static int recur(int n) {
        if (n < 4 || table[n] > 0) {
            return table[n];
        }

        return table[n] = recur(n - 1) + recur(n - 2) + recur(n - 3);
    }
}
