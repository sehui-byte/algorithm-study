package 게임맵최단거리;

/*
분류 : BFS 알고리즘
* */

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    //
    static int[][] count; //이동거리

    public static int solution(int[][] maps) {
        int answer = 0;
        count = new int[maps.length][maps[0].length];

        int[][] move = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}}; // 상하좌우
        Queue<Position> positions = new LinkedList<>(); // 방문한 위치를 저장
        positions.add(new Position(0, 0)); // 시작점
        count[0][0] = 1;

        while (!positions.isEmpty()) {
            // queue에서 최근 방문한 노드를 꺼낸다
            Position position = positions.poll();

            // 상하좌우로 이동
            for (int i = 0; i < 4; i++) {
                Position toMove = new Position(move[i][0] + position.x, move[i][1] + position.y);

                // map 범위를 벗어났을 때
                if (toMove.x < 0 || toMove.y < 0 || toMove.x == maps.length || toMove.y == maps[0].length) continue;

                // 막혀있거나 이미 지난간 길일 때
                if (maps[toMove.x][toMove.y] == 0) continue;

                // 방문
                positions.add(toMove);
                toMove.visit(maps, count[position.x][position.y]);
            }
        }
        return count[maps.length - 1][maps[0].length - 1] == 0 ? -1 : count[maps.length - 1][maps[0].length - 1];
    }


    private static class Position {
        //
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void visit(int[][] maps, int currentCount) {
            count[this.x][this.y] = currentCount + 1;
            maps[this.x][this.y] = 0; // 방문 후 해당 길을 막아버리기
        }
    }

    public static void main(String[] args) {
        //
        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        int result = solution(maps);
        System.out.println(result);
        System.out.println("test result : " + (result == 11));
    }
}




