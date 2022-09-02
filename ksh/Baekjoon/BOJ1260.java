import java.util.*;


class Node {
    int number; //정점 번호는 1번부터 N번까지
    LinkedList<Node> adjacent;
    boolean visited;

    public Node(int number) {
        this.number = number;
        this.visited = false;
        this.adjacent = new LinkedList<Node>();
    }

}

class Graph {
    Node[] nodes;

    public Graph(int nodeCount) {
        this.nodes = new Node[nodeCount];
        for (int i = 0; i < nodeCount; i++) {
            this.nodes[i] = new Node(i + 1);
        }
    }

    public void addEdge(int a, int b) {
        Node aNode = this.nodes[a - 1];
        Node bNode = this.nodes[b - 1];

        if (!aNode.adjacent.contains(bNode)) {
            aNode.adjacent.add(bNode);
            // 여러개일 경우 작은 정점 먼저 방문하도록 정렬
            Collections.sort(aNode.adjacent, new Comparator<Node>() {
                @Override
                public int compare(Node a, Node b) {
                    return a.number > b.number ? 1 : -1;
                }
            });

        }

        if (!bNode.adjacent.contains(aNode)) {
            bNode.adjacent.add(aNode);
            // 여러개일 경우 작은 정점 먼저 방문하도록 정렬
            Collections.sort(bNode.adjacent, new Comparator<Node>() {
                @Override
                public int compare(Node a, Node b) {
                    return a.number > b.number ? 1 : -1;
                }
            });
        }


    }

    public void dfs(int v) {
        Node vNode = this.nodes[v - 1];
        System.out.print(vNode.number + " ");
        vNode.visited = true;

        for (Node node : vNode.adjacent) {
            if (node.visited == false) {
                dfs(node.number);
            }
        }
    }

    public void bfs(int v) {
        Queue<Node> q = new LinkedList<Node>();
        Node vNode = this.nodes[v - 1];
        q.add(vNode);
        vNode.visited = true;

        while (!q.isEmpty()) {
            Node toVisit = q.peek();
            q.poll();
            System.out.print(toVisit.number + " ");

            if (!toVisit.adjacent.isEmpty()) {
                for (Node node : toVisit.adjacent) {
                    if (!node.visited) {
                        q.add(node);
                        node.visited = true;
                    }
                }
            }
        }
    }

    //방문기록 초기화
    public void clearVisited() {
        for (Node node : this.nodes) {
            node.visited = false;
        }
    }


}


public class BOJ1260 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nodeCount = sc.nextInt();
        int edgeCount = sc.nextInt();
        int v = sc.nextInt(); //startNode

        Graph g = new Graph(nodeCount);

        for (int i = 0; i < edgeCount; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            g.addEdge(a, b);
        }

        g.dfs(v);
        g.clearVisited();
        System.out.println();
        g.bfs(v);

    }
}