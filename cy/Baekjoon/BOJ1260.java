package Baekjoon;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.*;

class BOJ1260{
    public static final Scanner sc = new Scanner(System.in);
    public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));


    public static ArrayList<Integer> getDFSroot(int graph, boolean[][] adj, int start){
        ArrayList<Integer> visitedNodes = new ArrayList<>();

        Stack<State> dfsStack = new Stack<>();
        State initialState = new State(start, 1);
        dfsStack.add(initialState);

        boolean visited[] = new boolean[graph+1];

        while(!dfsStack.isEmpty()){
            State currentState = dfsStack.pop();

            if(visited[currentState.nodeIndex] == true){
                continue;
            }

            visited[currentState.nodeIndex] = true;
            visitedNodes.add(currentState.nodeIndex);

            for(int next=graph; next >= 1; next--){
                if(adj[currentState.nodeIndex][next] == true && visited[next] == false){
                    State nextState = new State(next, currentState.depth+1);
                    dfsStack.push(nextState);
                }
            }
        }
        return visitedNodes;
    }
    public static final ArrayList<Integer> getBFSroot(int graph, boolean[][] adj, int start){

        ArrayList<Integer> bfsNodes = new ArrayList<>();
        Queue<State> bfsQueue = new LinkedList<>();

        State initialState = new State(start,1);
        bfsQueue.add(initialState);

        boolean[] visitedNodes = new boolean[graph+1];

        while(bfsQueue.isEmpty() == false){
            State currentState = bfsQueue.poll();

            if(visitedNodes[currentState.nodeIndex] == true){
                continue;
            }

            visitedNodes[currentState.nodeIndex] = true;
            bfsNodes.add(currentState.nodeIndex);

            for(int i=1; i <= graph; i++){
                if(adj[currentState.nodeIndex][i] == true && visitedNodes[i] == false){
                    State nextState = new State(i, currentState.depth+1);
                    bfsQueue.add(nextState);
                }
            }
        }
        return bfsNodes;
    }
    public static void main(String args[]) throws Exception{
        int graph = sc.nextInt();
        int edge = sc.nextInt();
        int start = sc.nextInt();

        boolean adj[][] = new boolean[graph+1][graph+1];

        for(int i=0; i < edge; i++){
            int point_one = sc.nextInt();
            int point_two = sc.nextInt();

            adj[point_one][point_two] = true;
            // 양방향
            adj[point_two][point_one] = true;
        }

        ArrayList<Integer> dfsList = getDFSroot(graph, adj, start);
        ArrayList<Integer> bfsList = getBFSroot(graph, adj, start);

        for(int i=0; i < dfsList.size(); i++){
            if(i > 0){
                writer.write(" ");
            }
            writer.write(String.valueOf(dfsList.get(i)));
        }

        writer.write("\n");

        for(int i=0; i < bfsList.size(); i++){
            if(i > 0){
                writer.write(" ");
            }
            writer.write(String.valueOf(bfsList.get(i)));
        }

        writer.flush();
        writer.close();
    }
}
class State{
    public final int nodeIndex; // 현재 정점의 수
    public final int depth; // 탐색의 깊이

    public State(int nodeIndex, int depth){
        this.nodeIndex = nodeIndex;
        this.depth = depth;
    }
}