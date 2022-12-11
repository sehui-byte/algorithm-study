// 플로이드 워셜 알고리즘 문제

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ11404 {

    static int[][] dist; // array of minimum distances

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); // 도시의 개수 (vertex) <= 100
        int m = Integer.parseInt(br.readLine()); // 버스의 개수 (edge)  ≤ 100000
        dist = new int[n + 1][n + 1];

        // dist 초기화
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    // 거쳐가는 경우 100000 을 넘을 수 있으므로
                    // bus 최댓값 * 도시 최댓값 + 1
                    dist[i][j] = 100000001; // Integer.MAX_VALUE로 하면 연산시에 오버플로우 에러 발생
                }
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dist[a][b] = Math.min(dist[a][b], c);
        }


        // 플로이드 워셜 알고리즘
        // k 는 거쳐가는 도시 : 1~N개의 도시를 거쳐가는 경우를 모두 고려한다
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                //     i에서 k로 가는 최소비용 + k에서 j로 가는 최소비용 = i에서 j로 가는 최소비용
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] == 100000001) {
                    sb.append("0");
                } else {
                    sb.append(dist[i][j]);
                }
                sb.append(" ");
            }

            sb.append("\n");
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
