package com.pantos.vms.biz.test;

import java.util.Arrays;

class Solution {

	public String solution(String[] participant, String[] completion) {

		// 비교를 위한 배열 정렬..
		Arrays.sort(participant);
		Arrays.sort(completion);

		int i;

		// 배열 반복
		for (i = 0; i < completion.length; i++) {
			// 다른거 찾으러 가자...
			if (!participant[i].equals(completion[i])) {
				// 다른게 있으니 리턴
				return participant[i];
			}
		}
		// 결과 반환
		return participant[i];
	}
}