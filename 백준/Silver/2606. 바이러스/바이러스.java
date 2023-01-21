import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    static boolean[] visited;
    static int cnt = 0;
    static int startVertex = 6;
    public static void main(String[] args) throws IOException {
        //setUp
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vertex = Integer.parseInt(br.readLine());
        for (int i = 0; i < vertex + 1; i++) {
            graph.add(new ArrayList<Integer>());
        }
        visited = new boolean[vertex + 1];
        int edge = Integer.parseInt(br.readLine());
        for (int i = 0; i < edge; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int toVertex = Integer.parseInt(st.nextToken());
            int fromVertex = Integer.parseInt(st.nextToken());
            graph.get(toVertex).add(fromVertex);
            graph.get(fromVertex).add(toVertex);
        }
        bfs(startVertex);
        outPut();
    }
    private static void outPut(){
        System.out.println(cnt);
    }

    private static void bfs(int vertex) {
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[vertex] = true;
        queue.add(vertex);
        while (!queue.isEmpty()) {
            int getVertex = queue.poll();
            for (int i = 0; i < graph.get(getVertex).size(); i++) {
                int nextVertex = graph.get(getVertex).get(i);
                if (!visited[nextVertex]) {
                    cnt++;
                    visited[nextVertex] = true;
                    queue.add(nextVertex);
                }
            }
        }
    }

}