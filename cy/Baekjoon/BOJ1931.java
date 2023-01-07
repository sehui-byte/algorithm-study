import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ1931 {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // 회의 수
        int N = sc.nextInt();
        // 회의 스케줄
        int[][] meetings = new int[N][2];
        // 가능한 회의 수
        int result = 0;

        for(int i=0; i < N; i++){
            meetings[i][0] = sc.nextInt();
            meetings[i][1] = sc.nextInt();
        }

        // 정렬 : 회의시간 종료 오름차순, 회의시간 시작 오름차순
        Arrays.sort(meetings, (o1, o2) -> {
            if(o1[1] == o2[1]){
                return Integer.compare(o1[0], o2[0]);
            } else {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        // 첫 회의
        int endTime = meetings[0][1];
        result ++;

        // 다음 회의부터 가능 회의 수 계산
        for(int i=1; i < N; i++){
            if(meetings[i][0] >= endTime){
                result++;
                endTime = meetings[i][1];
            }
        }

        System.out.println(result);
    }
}
