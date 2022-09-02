package com.pantos.vms.biz.test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1260 {

	// 인접 2차원 Array 생성
	static int[][] arr;

	// 방문한 노드인지 기록용으로
	static boolean[] visited;

	// 메인에서 dfs / bfs 둘 다 호출하기.
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int N = scan.nextInt();   // 정점의 개수
		int M = scan.nextInt();   // 간선의 개수
		int V = scan.nextInt();   // 탐색을 시작할 정점

		// 인접행렬 노드 생성
		// 첫번째 노드에 몇개의 인접한 노드가 있는지를 2차원으로.
		arr = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			arr[a][b] = 1;
			arr[b][a] = 1;
		}

		// 재귀 함수를 호출하여 푸는게 유리한 dfs 에서 방문한 탐색 정점 = 노드를 체크해둠.
		// 이유는 메모리 사용량을 줄이기 위해..
		visited = new boolean[N + 1];
		dfs(V);

		System.out.println();

		visited = new boolean[N + 1];
		bfs(V);
	}

	//깊이우선탐색 : dfs : 재귀호출로 진행
	public static void dfs(int V) {
		visited[V] = true;
		System.out.print(V + " ");

		if (V == arr.length) {
			return;
		}
		for (int j = 1; j < arr.length; j++) {
			//연결은 되어있는데, 방문하지 않았다면 재귀
			// 위에서 설정한 visited 노드 값이 방문한 노드가 아니라면
			// 기억을 했던 곳으로 바로 오기 위해 재귀 방법을 씀.
			if (arr[V][j] == 1 && visited[j] == false) {
				dfs(j);
			}
		}
	}

	//너비우선탐색
	public static void bfs(int V) {

		// 연결된 노드를 리스트화 하여, 방문했던 노드를 큐의 자료구조 방법으로 탐색하기.
		// 이유는 너비우선탐색은 자식노드 간의 깊이 탐색이 아닌, 층 별로 탐색을 하기 때문.
		Queue<Integer> que = new LinkedList<Integer>();

		// 큐에 탐색했던 노드를 넣고
		que.add(V);
		// 방문 기록을 찍기. 안하면.. 루프를 돈다..
		visited[V] = true;
		System.out.print(V + " ");

		while (!que.isEmpty()) {
			// 먼저 방문한 노드
			int temp = que.poll();
			for (int i = 1; i < arr.length; i++) {
				// 도달한 곳이 방문한 노드가 아니면 큐에 추가하고 방문한 것으로 체크하기.
				// dfs 랑 다르게 [][] 형태가 아닌 이유는
				// bfs 는 노드의 층 별로만 움직여서.. 인접한 부모노드 - 자식 노드 리스트 [][] 구조가 아님..
				if (arr[temp][i] == 1 && visited[i] == false) {
					que.add(i);
					visited[i] = true;
					// 출력.
					System.out.print(i + " ");
				}
			}
		}
	}

	/*
	 * 탐색할 과제 : 그래프 형이나, 행렬 형이나 사고가 살짝 다른듯 함. 이 부분에 대해서 찾아보기.
	 * */
}
