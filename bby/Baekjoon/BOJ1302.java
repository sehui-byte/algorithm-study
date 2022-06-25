package com.pantos.vms.biz.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestSeller {

	public static void main(String[] args) throws IOException {

		// 문자열 읽어오기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new HashMap<>();

		// 시작 값 0
		int max = 0;

		for (int i = 0; i < n; i++) {
			String book = br.readLine();
			// 읽은 문자열 맵에다 저장하고 팔린 만큼 카운트 증가.
			map.put(book, map.getOrDefault(book, 0) + 1);
			// max 로 팔린 책들 구하기...
			max = Math.max(max, map.get(book));
		}
		List<String> list = new ArrayList<>();
		// 가장 많이 팔린 책들 배열 선언하고 요소로 추가.
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() == max)
				list.add(entry.getKey());
		}
		// 베스트 셀러들 정렬
		Collections.sort(list);
		// 가장 앞으로 온게 제일 잘 팔리고 카운트가 높으므로 베스트 셀러 출력.
		System.out.print(list.get(0));
	}
}
