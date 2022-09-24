package Programmers.게임맵최단거리;

import java.util.*;

class Solution {
    public int solution(int[][] maps) {

        int N = maps.length;
        int M = maps[0].length;

        // 최단 거리
        int answer = -1;

        // 지나온 길 체크 배열
        int[][] visited = new int[N+1][M+1];

        // 미로 시작점
        State initialState = new State(0, 0, 1);

        Queue<State> queue = new LinkedList<>();

        queue.add(initialState);

        while(!queue.isEmpty()) {

            State state = queue.poll();

            int currentN = state.getCurrentN();
            int currentM = state.getCurrentM();
            int currentCount = state.getCount();

            // System.out.println("(" + currentN + ", " + currentM + ")");
            // 이미 지나간 길이거나 미로에 길이 없을 때
            if(visited[currentN][currentM] == 1 || maps[currentN][currentM] != 1) {
                continue;
            }

            // 지나온 길 체크
            visited[currentN][currentM] = 1;

            // 아래로 갈 때(배열 최대 최소 값 및 이미 지나온 길인지 확인)
            if(currentN + 1 < N && visited[currentN+1][currentM] == 0) {
                queue.add(new State(currentN+1, currentM, state.getCount()+1));
            }
            // 위로 갈 때
            if(currentN - 1 >= 0 && visited[currentN-1][currentM] == 0) {
                queue.add(new State(currentN-1, currentM, state.getCount()+1));
            }
            // 오른쪽으로 갈 때
            if(currentM + 1 < M && visited[currentN][currentM+1] == 0) {
                queue.add(new State(currentN, currentM+1, state.getCount()+1));
            }
            // 왼쪽으로 갈 때
            if(currentM - 1 >= 0 && visited[currentN][currentM-1] == 0) {
                queue.add(new State(currentN, currentM-1, state.getCount()+1));
            }

            // 미로 최종지 확인
            if(N-1 == currentN && M-1 == currentM) {
                if(answer > state.getCount() || answer == -1) {
                    answer = state.getCount();
                }
            }
        }
        return answer;
    }
}

class State {
    public final int currentN;
    public final int currentM;
    public final int count;

    public State(int currentN, int currentM, int count) {
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