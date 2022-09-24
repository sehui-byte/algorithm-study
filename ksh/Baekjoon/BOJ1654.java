/*
 *  백준 : 랜선자르기
 *   분류 : 이분탐색
 * */

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1654 {
    static long[] lan;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt(); //이미 가지고 있는 랜선의 개수 k
        long n = sc.nextInt(); // 필요한 랜선의 개수 n
        lan = new long[k];
        int result = 0; // 만들 수 있는 최대 랜선의 길이
        for (int i = 0; i < k; i++) {
            lan[i] = sc.nextInt();
            sc.nextLine();
        }

        // Todo: 랜선의 적정 길이 범위를 어떻게 설정할 것인가?
        long low = 1;
        long high = Arrays.stream(lan).max().getAsLong();
        long middle = 0;

        //Todo: 탈출조건 설정
        while (low <= high) {
            middle = (low + high) / 2;
            if (check(middle) >= n) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        System.out.println(high);
    }

    // 만들 수 있는 length 길이의 랜선의 개수를 리턴한다
    public static long check(long length) {
        int count = 0;
        for (long j : lan) {
            count += j / length;
        }
        return count;
    }
}
