import java.io.*;
import java.util.*;

public class Main {

    private static int[][] graph;
    private static boolean[] visited;
    private static int vertex, answer = 0;

    public static void main(String[] args) throws IOException {
        init();
        dfs(1);
        answer();
    }

    private static void dfs(int vertex) {
        Stack<Integer> stack = new Stack<>();
        visited[vertex] = true;
        stack.push(vertex);
        
        while(!stack.isEmpty()) {
            for (int i = 1; i < graph.length; i++) {
                if (graph[vertex][i] != 0 && !visited[i]) {
                    answer ++;
                    dfs(i);
                }
            }
            stack.pop();
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        vertex = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());
        graph = new int[vertex + 1][vertex + 1];
        visited = new boolean[vertex + 1];
        for (int i = 0; i < edge; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int toVertex = Integer.parseInt(st.nextToken());
            int fromVertex = Integer.parseInt(st.nextToken());
            graph[toVertex][fromVertex] = 1;
            graph[fromVertex][toVertex] = 1;
        }
    }

    private static void answer() {
        System.out.println(answer);
    }
}
