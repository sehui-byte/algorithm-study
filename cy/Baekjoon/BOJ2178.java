package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2178 {

    public static final Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {
        // N 세로 ,M 가로

        int N = sc.nextInt();
        int M = sc.nextInt();

        // 최단 거리
        int answer = -1;

        // 배열 생성
        int[][] maze = new int[N+1][M+1];

        // 지나온 길 체크 배열
        int[][] visited = new int[N+1][M+1];

        // 배열 입력
        for(int i=0; i < N; i++) {
            String rowNums = sc.next();

            for(int j=0; j < M; j++) {
                maze[i][j] = Character.getNumericValue(rowNums.charAt(j));
            }
        }

        // 출력 테스트
//		for(int i=0; i < N; i++) {
//			for(int j=0; j < M; j++) {
//				System.out.print(visited[i][j]);
//			}
//			System.out.println();
//		}

        // 미로 시작점
        MazeState initialMazeState = new MazeState(0, 0, 1);

        Queue<MazeState> queue = new LinkedList<>();

        queue.add(initialMazeState);

        int index = 0;
        while(!queue.isEmpty()) {

            index++;

            MazeState MazeState = queue.poll();

            int currentN = MazeState.getCurrentN();
            int currentM = MazeState.getCurrentM();
            int currentCount = MazeState.getCount();

            // System.out.println("(" + currentN + ", " + currentM + ")");
            // 이미 지나간 길이거나 미로에 길이 없을 때
            if(visited[currentN][currentM] == 1 || maze[currentN][currentM] != 1) {
                continue;
            }

            // 지나온 길 체크
            visited[currentN][currentM] = 1;

            // 아래로 갈 때(배열 최대 최소 값 및 이미 지나온 길인지 확인)
            if(currentN + 1 < N && visited[currentN+1][currentM] == 0) {
                queue.add(new MazeState(currentN+1, currentM, MazeState.getCount()+1));
            }
            // 위로 갈 때
            if(currentN - 1 >= 0 && visited[currentN-1][currentM] == 0) {
                queue.add(new MazeState(currentN-1, currentM, MazeState.getCount()+1));
            }
            // 오른쪽으로 갈 때
            if(currentM + 1 < M && visited[currentN][currentM+1] == 0) {
                queue.add(new MazeState(currentN, currentM+1, MazeState.getCount()+1));
            }
            // 왼쪽으로 갈 때
            if(currentM - 1 >= 0 && visited[currentN][currentM-1] == 0) {
                queue.add(new MazeState(currentN, currentM-1, MazeState.getCount()+1));
            }

            // 미로 최종지 확인
            if(N-1 == currentN && M-1 == currentM) {
                if(answer > MazeState.getCount() || answer == -1) {
                    answer = MazeState.getCount();
                }
            }
        }
        System.out.println(answer);
    }
}

class MazeState {
    public final int currentN;
    public final int currentM;
    public final int count;

    public MazeState(int currentN, int currentM, int count) {
        this.currentN = currentN;
        this.currentM = currentM;
        this.count = count;
    }

    public int getCurrentN() {
        return currentN;
    }

    public int getCurrentM() {
        return currentM;
    }

    public int getCount() {
        return count;
    }
}
