package com.pantos.vms.biz.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ1654 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Scanner in = new Scanner(System.in);

		int K = in.nextInt();
		int N = in.nextInt();

		int[] arr = new int[K];

		long max = 0;

		// 입력과 동시에 해당 랜선의 길이가 최댓값인지를 확인하고 max를 갱신
		for (int i = 0; i < K; i++) {
			arr[i] = in.nextInt();
			if (max < arr[i]) {
				max = arr[i];
			}
		}


		// 반드시 max에서 +1 값이어야 한다.
		max++;

		long min = 0; // 탐색 길이 최솟값
		long mid = 0;

		while (min < max) {

			// upper bound : 즉 상한은 찾고자 하는 값을 초과한 값을 처음 만나는 위치.
			// lower bound : 찾고자 하는 특정 값 이상인 '첫 위치'를 반환.

			// ex : 배열 [1, 2, 3, 4, 4, 4, 5, 6, 7]
			// 중복되는 값 4를 초과하는 인덱스는 : 6 : upper bound
			// 중복되는 값을 4 이상인 '첫 위치' 인덱스는 : 3 >> lower bound

			// 중복 원소에 대한 길이 =  (상한 - 하한) : 같은 랜선의 길이 최대를 구하는 문제의 풀이로 쓰임.
			// 범위 내에서 중간 길이를 구한다.
			mid = (max + min) / 2;

			long count = 0;

			// 구해진 중간 길이로 잘라서 총 몇 개가 만들어지는지를 구한다.
			for (int i = 0; i < arr.length; i++) {
				count += (arr[i] / mid);
			}

			// 개수가 중복이 될 떄 최대 길이를 찾아야 한다는 것이 문제의 포인트 이므로. upper bound 로 찾기.
			/*
			 *  [upper bound 형식]
			 *  mid길이로 잘랐을 때의 개수가 만들고자 하는 랜선의 개수보다 작다면
			 *  자르고자 하는 길이를 줄이기 위해 최대 길이를 줄인다.
			 *  그 외에는 자르고자 하는 길이를 늘려야 하므로 최소 길이를 늘린다.
			 */
			if (count < N) {
				max = mid;
			} else {
				min = mid + 1;	// 중복되게 동일한 배열 = 랜선 길이의 최대를 못 찾으면 + 1 을 해서 상한 검색을 함.
			}

		}

		// UpperBound로 얻어진 값(min)에 -1이 최대 길이가 된다. : 가장 많이 랜선 개수가 나와야 하므로, 상한 검색을 한거에서 -1 을 하면 최대로 개수가 나옴.
		System.out.println(min - 1);
	}

	/*
	 * 별첨자료
	 * 1.이분 탐색의 기본이 되는 upper bound, lower bound 개념 링크 : https://st-lab.tistory.com/267
	 * 2.BOJ1654 랜선 자르기 참고한 링크 : https://st-lab.tistory.com/269
	 * */
}