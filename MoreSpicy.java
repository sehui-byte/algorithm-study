package com.pantos.vms.biz.test;

import java.util.PriorityQueue;

public class MoreSpicy {

	public static int main(int[] scoville, int k) {

		int returnScore = 0;

		// 들어간 순서에 상관없이 우선순위가 높은 데이터가 먼저 나오는 구조라고 함...
		PriorityQueue<Integer> que = new PriorityQueue<>();

		for (int i = 0; i < scoville.length; i++) {
			que.add(scoville[i]);	// 스코빌 숫자 담기
		}

		while (que.peek() < k) {	// k 보다 높아질 경우,,,?
			if (que.size() == 1)
				return -1;
			que.add(que.poll() + que.poll() * 2);	// 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)

			returnScore++;
		}
		return returnScore;
	}
}