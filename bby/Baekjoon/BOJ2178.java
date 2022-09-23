package com.pantos.vms.biz.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178 {

	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] miro = new char[N][M];  // 미로를 저장할 배열
		int[][] dist = new int[N][M];    // 거리를 계산할 dist 배열
		int[] dx = { 1, 0, -1, 0 };       // 상하좌우 계산할 x좌표
		int[] dy = { 0, 1, 0, -1 };        // 상하좌우 계산할 y좌표

		// 좌표는 큐로 구성을 할거고, 인접해 있기 때문에 LinkedList
		// 최단거리를 구하려면 :: 먼저 갔던 곳을 넣고 바로 빼서 값을 따져야 하기 때문에 선입 선출 구조여야함.
		Queue<PairPoint> qu = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			String line = bf.readLine();
			for (int j = 0; j < M; j++) {
				miro[i][j] = line.charAt(j);
				dist[i][j] = -1;    // 거리를 -1로 세팅하면, 방문여부를 확인가능. (이전 지점까지의 거리를 왔던거인지를 보면 되므로)
			}
		}

		qu.offer(new PairPoint(0, 0));  // 시작 좌표 0, 0
		dist[0][0] = 0;   // 첫 시작이니까 거리는 0 으로

		while (!qu.isEmpty()) {
			PairPoint p = qu.poll();

			// 상, 하, 좌, 우를 계산해준다. (4인 이유는 한 쪽으로 4번 갈수도 있기 때문.)
			for (int i = 0; i < 4; i++) {
				int nX = p.x + dx[i];
				int nY = p.y + dy[i];

				// 벽에 부딪히거나, 범위를 넘어가면 PASS (격자 배치이기 때문에 !!)
				if (nX < 0 || nX >= N || nY < 0 || nY >= M) {
					continue;
				}
				// 길이 아니거나, 방문을 했다면 PASS
				// 큐에서 서로의 경로를 하나씩 넣고 빼고 하기 때문에 결국엔 가장 빠른 경로가 먼저 도달하여 배열에 값을 넣게 된다.
				// 즉, 오래 걸린 경로는 배열에 값을 넣으려고 해도 이미 값이 있기 때문에 값을 넣지 못함.
				// 이하의 조건의 경우에 해당 >> 이리하면 최장의 경로는 저장이 안됨.
				if (miro[nX][nY] == '0' || dist[nX][nY] != -1) {
					continue;
				}

				// 큐에 이동한 좌표를 넣어준다.
				qu.offer(new PairPoint(nX, nY));
				// 한칸 이동하였기 때문에, 이전 출발지점의 거리 +1을 해준다.
				dist[nX][nY] = dist[p.x][p.y] + 1;
			}
		}

		// 마지막 지점의 (거리 + 1)를 출력해주면 된다.
		// 첫 지점에서 1 칸 이동하면 시작부터 1 이므로. : 하지만 배열은 [n-1][m-1] 이다. 배열로 저장하기 때문에...
		System.out.print(dist[N - 1][M - 1] + 1);
	}

	// 큐에 좌표를 넣어주기 위한 클래스
	// X, Y 축으로 각각 몇 칸 만큼 이동했는지 int 로 받아서 그대로 리턴.
	public static class PairPoint {

		int x, y;

		public PairPoint(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public void setX(int x) {
			this.x = x;
		}

		public void setY(int y) {
			this.y = y;
		}
	}
}