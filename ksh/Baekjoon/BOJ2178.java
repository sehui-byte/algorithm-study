import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2178 {
    static int[][] count;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[][] map = new int[n][m];
        count = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0'; // convert char to int
            }
        }

        Queue<Position> positionQueue = new LinkedList<>();
        int[][] move = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}}; // 상하좌우
        positionQueue.add(new Position(0, 0)); // 시작점
        count[0][0] = 1; map[0][0] = 0;

        while (!positionQueue.isEmpty()) {
            Position currentVisit = positionQueue.poll(); // 최근 방문한 노드

            for (int i = 0; i < 4; i++) {
                Position toMove = new Position(move[i][0] + currentVisit.x, move[i][1] + currentVisit.y);

                // 이동 가능 범위 벗어남
                if (toMove.x < 0 || toMove.y < 0 || toMove.x == n || toMove.y == m) continue;
                // 지나갈 수 없는 길이거나 이미 지나간 길
                if (map[toMove.x][toMove.y] == 0) continue;

                // 방문
                positionQueue.add(toMove);
                count[toMove.x][toMove.y] += count[currentVisit.x][currentVisit.y] + 1;
                map[toMove.x][toMove.y] = 0;
            }
        }

        System.out.println(count[n - 1][m - 1]);
        printCountMap();

    }

    private static void printCountMap() {
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[0].length; j++) {
                System.out.print(count[i][j] + " ");
            }
            System.out.println();
        }
    }


    private static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
}
