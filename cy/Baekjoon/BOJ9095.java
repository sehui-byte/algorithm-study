package Baekjoon;

import java.util.Scanner;

public class BOJ9095 {

    static int answer;

    private static void cal(int sum, int num){
        if(sum > num){
            return;
        } else if(sum == num){
            answer++;
        }
        for(int i=1; i <= 3; i++){
            cal(sum+i, num);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sum = 0;
        int num = 0;

        int total = sc.nextInt();

        for(int i=0; i < total; i++){
            answer = 0;
            sum = 0;
            num = sc.nextInt();

            cal(sum, num);
            System.out.println(answer);
        }
    }
}
