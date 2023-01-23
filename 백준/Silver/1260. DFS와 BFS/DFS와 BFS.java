import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        //setUp
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertex = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int startVertex = Integer.parseInt(st.nextToken());
        for (int i = 0; i < vertex + 1; i++) {
            graph.add(new ArrayList());
        }
        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int toVertex = Integer.parseInt(st.nextToken());
            int fromVertex = Integer.parseInt(st.nextToken());
            graph.get(toVertex).add(fromVertex);
            graph.get(fromVertex).add(toVertex);
        }

        arraySort();

        visited = new boolean[vertex + 1];
        sb.append(startVertex).append(" ");
        dfs(startVertex);

        visited = new boolean[vertex + 1];
        sb.append("\n").append(startVertex).append(" ");
        bfs(startVertex);

        outPut();
    }
    private static void outPut(){
        System.out.println(sb.toString());
    }

    private static void bfs(int vertex) {
        visited[vertex] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(vertex);
        while (!queue.isEmpty()){
            int getVertex = queue.poll();
            for (int i = 0; i < graph.get(getVertex).size(); i++) {
                int nextVertex = graph.get(getVertex).get(i);
                if (!visited[nextVertex]){
                    visited[nextVertex] = true;
                    queue.add(nextVertex);
                    sb.append(nextVertex).append(" ");
                }
            }
        }
    }

    private static void dfs(int vertex){
        visited[vertex] = true;
        for (int i = 0; i < graph.get(vertex).size(); i++) {
            int getVertex = graph.get(vertex).get(i);
            if (!visited[getVertex]){
                visited[getVertex] = true;
                sb.append(getVertex).append(" ");
                dfs(getVertex);
            }
        }
    }

    private static void arraySort(){
        for (int i = 1; i < graph.size(); i++) {
            Collections.sort(graph.get(i));
        }
    }
}