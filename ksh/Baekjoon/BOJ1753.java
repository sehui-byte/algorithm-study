import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ1753 {
    //
    static int V, E;
    static final int MAX_W = 10; // 최대 가중치
    static int[][] Graph;
    static int[] Dist = new int[MAX_W]; // K에서 V로 가는 최단경로 가중치 저장

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        V = sc.nextInt(); // 정점의 개수
        E = sc.nextInt(); // 간선의 개수
        sc.nextLine();
        int K = sc.nextInt(); // 시작 정점의 번호 (1<=K<=V)
        Graph = new int[V][V];
        Dist = new int[V];

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            Graph[u - 1][v - 1] = w;
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (Graph[i][j] == 0 && i != j) {
                    // 방향그래프이므로 갈 수 없는 경우 -1 로 표시
                    Graph[i][j] = -1;
                }
            }
        }
        for (int v = 0; v < V; v++) {
            int dist = dijkstra(K, v + 1);
            if (dist == -1) {
                System.out.println("INF");
            } else {
                System.out.println(dist);
            }
        }
    }

    private static int dijkstra(int src, int dst) {
        if (src == dst) return 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            Dist[i] = Integer.MAX_VALUE;
        }
        Dist[src - 1] = 0; // 시작점이므로 0으로 설정
        pq.add(new int[]{0, src});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[1];
            if (u == dst) return curr[0];
            if (visited[u - 1]) continue;

            visited[u - 1] = true;
            for (int v = 0; v < V; ++v) {
                // 갈 수 없는 경우
                if (Graph[u - 1][v] == -1) {
                    continue;
                }
                if (Dist[v] > Dist[u - 1] + Graph[u - 1][v]) {
                    Dist[v] = Dist[u - 1] + Graph[u - 1][v];
                    pq.add(new int[]{Dist[v], v + 1});
                }
            }
        }
        return -1;
    }
}
