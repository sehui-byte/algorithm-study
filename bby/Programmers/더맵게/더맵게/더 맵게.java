package 더맵게;

import java.util.PriorityQueue;

class Solution {
	public int solution(int[] scoville, int k) {
		int returnScore = 0;

		// 들어간 순서에 상관없이 우선순위가 높은 데이터가 먼저 나오는 구조라고 함...
		PriorityQueue<Integer> que = new PriorityQueue<>();
		
		// 먼저 체크할 내용 >>  섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
		// 따라서 문제는 가장 작은 값 2개를 배열에서 뽑는다. >> 우선순위 큐는 작은 값을 기준으로 먼저 뽑혀나오는 최소 힙
		// 작은것과 두번째 작은것을 조건에 맞춰 계산한다.
		// 계산한 값을 다시 배열에 반환한다.
		// 배열의 값이 다 k보다 클 때 까지 반복한다.
		for (int i = 0; i < scoville.length; i++) {
			que.add(scoville[i]);	// 스코빌 숫자 담기
		}

		// k 보다 높아질 경우 >> k 라는 특정 스코빌 지수를 바라보게 하는 기준선.
		// 그전까지 계속 섞고 스코빌 공식 적용.
		while (que.peek() < k) {
			// 문제의 유의사항
			/*
			 *scoville의 길이는 2 이상 1,000,000 이하입니다.
			 *K는 0 이상 1,000,000,000 이하입니다.
			 *scoville의 원소는 각각 0 이상 1,000,000 이하입니다.
			 *모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.			
			 */
			if (que.size() == 1)
				return -1;
			// 
			que.add(que.poll() + que.poll() * 2);	// 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)

			returnScore++;
		}
		return returnScore;
	}
}
