package com.pantos.vms.biz.test;

import java.util.HashMap;

public class HashMapAthelet {

	public String solution(String[] participant, String[] completion) {
		String answer = "";
		
		// 값이 있으면 해당 key 에 value 로 숫자를 쓰기.
		HashMap<String, Integer> hm = new HashMap<>();
		for (String player : participant)
			// 값이 있으면 가져오고, 아니면 0 뱉는 getOrDefault : + 1 이므로 key 가 존재하면 1을 가져옴.
			hm.put(player, hm.getOrDefault(player, 0) + 1);
		for (String player : completion)
			// 완주자가 있으면 -1 을 해서 +-1 로 0 을 매칭
			hm.put(player, hm.get(player) - 1);
		for (String key : hm.keySet()) {
			// 0이 아니라면 참가자 - 완주자 매핑이 아니라서 완주하지 못한 사람 찾음.
			if (hm.get(key) != 0) {
				answer = key;
				System.out.println(answer);
				break;
			}
		}
		return answer;
	}
}
