import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
방향 그래프
 * 모든 간선의 가중치는 10 이하의 자연수.
 * V: 정점의개수, E: 간선의 개수  (1 ≤ V ≤ 20,000, 1 ≤ E ≤ 300,000)
 *  시작 정점의 번호 K(1 ≤ K ≤ V)
 *
 * */
public class BOJ1753 {
    static int V, E;
    static final int MAX_WEIGHT = 10; // 최대 가중치
    //    static int[][] Graph;
    // 메모리초과로 인해 2차원 배열에서 수정함
    static ArrayList<Node>[] graph;
    static int[] cost = new int[MAX_WEIGHT]; // K에서 V로 가는 최단경로 비용 저장

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        V = Integer.parseInt(st.nextToken()); // 정점의 개수
        E = Integer.parseInt(st.nextToken()); // 간선의 개수

        int startV = Integer.parseInt(br.readLine()); // 시작 정점의 번호 (1<=K<=V)
        cost = new int[V + 1];

        // graph 초기화
        graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<Node>();
        }
        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            // u 에서 v로 가는 가중치 w인 간선이 존재
            graph[u].add(new Node(w, v));
        }

        dijkstra(startV);
        // 경로가 없는 경우 INF를 출력한다
        for (int v = 1; v <= V; v++) {
            if (cost[v] == Integer.MAX_VALUE) {
                bw.write("INF\n");
            } else {
                bw.write(cost[v] + "\n");
            }

        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dijkstra(int start) {
//        if (src == dst) return 0;

        // weight가 가장 적은 것부터 꺼내기 위해 우선순위큐 사용
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        boolean[] visited = new boolean[V + 1];

        // 일단 최댓값으로 초기화
        for (int i = 1; i <= V; i++) {
            cost[i] = Integer.MAX_VALUE;
        }

        // 시작점이므로 비용 0으로 설정
        cost[start] = 0;
        pq.add(new Node(0, start));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int to = current.destination;
//            if (to == dst) return current.weight;
            if (visited[to]) continue; //이미 방문한 정점인 경우 패스

            // 시간초과 해결
            if(current.weight > cost[current.destination]) continue;

            // 다음 노드 방문
            visited[to] = true;
            for (int i = 0; i < graph[to].size(); i++) {
                Node next = graph[to].get(i);
                if (cost[next.destination] > cost[to] + next.weight) {
                    cost[next.destination] = cost[to] + next.weight;
                    pq.add(new Node(cost[next.destination], next.destination));
                }
            }
        }
    }

    private static class Node implements Comparable<Node> {
        int weight;
        int destination;

        public Node(int weight, int destination) {
            this.weight = weight;
            this.destination = destination;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
}

