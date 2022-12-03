package Baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ11404 {
    public static final Scanner sc = new Scanner(System.in);
    public static final int INF = Integer.MAX_VALUE;
    public static int N = sc.nextInt();
    public static int M = sc.nextInt();
    static int[][] map = new int[N][N];

    public static void main(String args[]){
        // test
        // 경로배열 생성
        int[][] map = new int[N][N];

        // 값 초기화
        for(int i=0; i < N; i++){
            for(int j=0; j < N; j++){

                map[i][j] = INF;

                if(i == j){
                    map[i][j] = 0;
                }
            }
        }

        // 주어진 경로 - 설정
        for(int i=0; i < M; i++){
            int s = sc.nextInt() - 1; // start
            int e = sc.nextInt() - 1; // end
            int c = sc.nextInt(); // cost

            map[s][e] = Math.min(map[e][s], c);
        }

        setShortPath();

        for(int i=0; i < N; i++){
            for(int j=0; j < N; j++){
                if(map[i][j] == INF){
                    map[i][j] = 0;
                }

                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 정답 출력
    private static void setShortPath(){
        // 주어진 경로 - 최단경로 설정
        for(int k=0; k<N; k++) {
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                } // for(j) of End
            } // for(i) of End
        } // for(k) of End
    }
}

class BusNode{
    private int start;
    private int end;
    private int cost;

    public BusNode(int start, int end, int cost){
        this.start = start;
        this.end = end;
        this.cost = cost;
    }
    public void setStart(int start) {
        this.start = start;
    }
    public void setEnd(int end) {
        this.end = end;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getStart() {
        return start;
    }
    public int getEnd() {
        return end;
    }
    public int getCost() {
        return cost;
    }
}
