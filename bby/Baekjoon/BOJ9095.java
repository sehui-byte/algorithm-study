package com.pantos.vms.biz.test;

import java.util.Scanner;

public class BOJ9095 {

	static int dp[] = new int[11];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		// 1, 2, 3 을 사용하여 정수 n 을 나타낼 수 있는 방법의 개수...
		//초기 값 : 점화식 시작 항은 정해진 경우의 수 이므로 미리 구하자..
		dp[1] = 1; // 1 : 총 1가지
		dp[2] = 2;	// 1+3, 2+2 : 총 2가지
		dp[3] = 4;	// 1+1+1+1 , 1+2+1, 1+3, 2+2 : 총 4가지

		// 만일 4를 표현하기 위함이면  : 1+3(위에서 표현한 4가지 방법), 2+2(위에 나온 2가지 방법), 3+1(위에 적은 1가지 방법) : 총 7가지
		// 만일 5를 표현하고자 한다면 : 1+4(위의 총7가지) , 2+3(위의 총 4가지), 3+2(위의 총2가지) : 총 13가지 방법..

		// dp[5] : dp[4] + dp[3] + dp[2]
		// dp[6] : dp[5] + dp[4] + dp[3]

		// DP 의 목적 : 컴퓨터의 반복 연산 시간을 줄이고 값을 갱신하여 최적의 연산 효율을 내기 위한 목적... / DFS , BFS 와의 차이점 비교도 필요..
		// DP 사용 용도  : 알고리즘의 패턴이 인접한 항들의 연계로 수열 정리가 될때...

		// 위의 dp 계산을 해본 결과 아래의 식이 완성됨.
		for (int j = 4; j <= 10; j++) { // 4부터 반복
			dp[j] = dp[j - 3] + dp[j - 2] + dp[j - 1]; // 점화식
		}

		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();

			System.out.println(dp[n]);
		}

	}

}
