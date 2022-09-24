package Baekjoon;

import java.util.Scanner;

public class BOJ1654 {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args){

        // Integer.MAX_VALUE : 2,147,483,647

        // 랜선 갯수 : K는 1이상 10,000이하의 정수이고
        int K = SCANNER.nextInt();
        // 목표 갯수 : N은 1이상 1,000,000이하의 정수이다.
        int N = SCANNER.nextInt();

        int arr[] = new int[K];

        long max = 0;
        long min = 0;
        long mid = 0;

        for(int i=0; i < K; i++){
            arr[i] = SCANNER.nextInt();
            
            // 최대값 찾기
            if(max < arr[i]){
                max = arr[i];
            }
        }

        max++;

        while (min < max) {
            mid = (min + max) / 2;

            // 비교해야 할 타입이 Long 이기 때문에 Long으로 선언
            long count = 0;

            for(int i=0; i < arr.length; i++){
                count += (arr[i] / mid);
            }

            // 목표 갯수보다 작으면 자르는 길이를 적게 만들어야 한다
            // max를 현재 mid로 설정해
            // mid를 작게 만든다
            if(count < N){
                max = mid;
            } 
            // 목표 갯수보다 많으면 자르는 길이를 늘려 잘린 갯수를 적게 만든다
            // min을 mid+1 하면서 이분탐색한다
            else {
                min = mid + 1;
            }
        }
        System.out.println(min-1);
    }
}
