package Baekjoon;

import java.util.Scanner;

public class BOJ2805 {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int K = SCANNER.nextInt();
        int N = SCANNER.nextInt();

        int arr[] = new int[K];

        long max = 0;
        long min = 0;
        long mid = 0;

        for(int i=0; i < K; i++){
            arr[i] = SCANNER.nextInt();

            // 최대값 찾기
            if(max <= arr[i]) {
                max = arr[i];
            }
        }

        while(min <= max){
            long total = 0;

            mid = (min + max) / 2;

            for(int i=0; i < K; i++){
                if(arr[i] - mid > 0){
                    total += arr[i] - mid;
                }
            }

            // 짜른 길이가 원하는 길이보다 더 길면 나무 절단기 높이를 더 올려야 함
            // min을 mid로 설정
            if(total >= N){
                min = mid + 1;
                // 짜른 길이가 원하는 길이보다 더 짧으면 나무 절단기 높이를 더 낮춰야 함
                // max를 mid로 설정
            } else {
                max = mid - 1;
            }
        }
        System.out.println(min-1);
    }
}