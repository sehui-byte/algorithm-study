import java.util.Arrays;
import java.util.Scanner;

public class BOJ2457 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        Flower[] flowers = new Flower[n];
        int result = 0;

        for (int i = 0; i < n; i++) {
            flowers[i] = new Flower(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
            sc.nextLine();
        }

        // 꽃이 피는 날짜가 빠르고, 지는 날짜가 느린 순으로 정렬
        Arrays.sort(flowers);

        // 3.1 ~ 11.30까지 매일 꽃이 한가지 이상 피도록 꽃을 선택
        int start = 301;
        int max = 0;
        int idx = 0;

        while (start < 1201) {
            boolean choiced = false;

            // 시작날짜 겹치는 꽃 중 꽃이 지는 날짜가 가장 뒤인 꽃을 고른다
            for (int i = idx; i < n; i++) {
                if (start >= flowers[i].start && max < flowers[i].end) {
                    max = flowers[i].end;
                    idx = i + 1;
                    choiced = true;
                }
            }
            if (choiced) {
                start = max;
                result++;
            } else break;

        }

        if (max < 1201) System.out.println(0);
        else System.out.println(result);
    }

    private static class Flower implements Comparable<Flower> {
        private int start;
        private int end;

        public Flower(int startMonth, int startDay, int endMonth, int endDay) {
            this.start = startMonth * 100 + startDay;
            this.end = endMonth * 100 + endDay;
        }

        // 꽃이 피는 날짜가 빠르고, 지는 날짜가 느린 순으로 정렬
        @Override
        public int compareTo(Flower o) {
            // 꽃이 피는 날짜 오름차순
            if (this.start != o.start) {
                return this.start - o.start;
            }
            // 꽃이 지는 날짜 내림차순
            return o.end - this.end;
        }

        @Override
        public String toString() {
            return "Flower{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
