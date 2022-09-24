package com.pantos.vms.biz.test;

import java.util.Scanner;

public class BOJ2805 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		int M = in.nextInt();

		int[] tree = new int[N];

		int min = 0;
		int max = 0;

		for (int i = 0; i < N; i++) {
			tree[i] = in.nextInt();

			/*
			 * 나무들 중 최댓값을 구하기 위해 매 입력 때마다 max 변수와 비교하여
			 * 입력 받은 나무가 max보다 클 경우 max 값을 해당 나무의 높이로 갱신해준다.
			 */
			if (max < tree[i]) {
				max = tree[i];
			}
		}

		// 이분 탐색 (upper bound)
		while (min < max) {

			int mid = (min + max) / 2;
			long sum = 0;
			for (int treeHeight : tree) {

				/*
				 *  tree의 잘린 길이 = tree의 높이 - 자르는 위치(mid)
				 *  tree의 잘린 길의의 합을 구한다.
				 *  이 때 자르는 위치가 주어진 나무의 높이보다 클 수 있기 때문에
				 *  0 이하인 경우(=음수)에는 합산을 하지 않고 양수만 합산하도록 해야한다.
				 *  왜냐햐면... 지정한 높이보다 낮은 길이의 나무는 잘리지 않으므로 가져갈 대상이 아님...
				 */
				if (treeHeight - mid > 0) {
					sum += (treeHeight - mid);
				}
			}

			/*
			 * 자른 나무 길의의 합이 M보다 작다는 것은
			 * 자르는 위치(높이)가 높다는 의미이므로 높이를 낮춰야 한다.
			 * 즉, 상한(max)를 줄여야 한다.
			 * 문제에서 "적어도 M 미터의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 높이의 최댓값을 구하는 프로그램을 작성하시오" 라고 했으므로, 가장 최적의 지정할 길이를 구해야함.
			 */
			if (sum < M) {
				max = mid;
			}

			/*
			 * 자른 나무 길이의 합이 M보다 크다는 것은
			 * 자르는 위치(높이)가 낮다는 의미이므로 높이를 높여야 한다.
			 * 또한, 같을 경우에는 최대한 적게 자르기 위해 자르는 높이를
			 * 높여야 하므로 하한(min)을 올려야 한다.
			 */
			else {
				min = mid + 1;
			}
		}

		// 참고한 링크 : https://minhamina.tistory.com/127
		System.out.println(min - 1);

	}
}
