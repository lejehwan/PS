import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Main {

    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        init();
        bfs(1);
//        dfs(1);
        System.out.println(answer);
    }

    private static void dfs(int startVertex) {
        visited[startVertex] = true;
        for (int i = 0; i < graph.get(startVertex).size(); i++) {
            int newVertex = graph.get(startVertex).get(i);
            if (!visited[newVertex]) {
                visited[newVertex] = true;
                answer ++;
                dfs(newVertex);
            }
        }
    }

    private static void bfs(int startVertex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);
        visited[startVertex] = true;

        while (!queue.isEmpty()) {
            int getVertex = queue.poll();
            for (int i = 0; i < graph.get(getVertex).size(); i++) {
                int newVertex = graph.get(getVertex).get(i);
                if (!visited[newVertex]) {
                    queue.add(newVertex);
                    visited[newVertex] = true;
                    answer ++;
                }
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computerCnt = Integer.parseInt(br.readLine());
        visited = new boolean[computerCnt + 1];
        for (int i = 0; i <computerCnt + 1; i++) {
            graph.add(new ArrayList<>());
        }
        int computerPairsCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < computerPairsCnt; i++) {
            String[] data = br.readLine().split(" ");
            int start = Integer.parseInt(data[0]);
            int end = Integer.parseInt(data[1]);
            graph.get(start).add(end);
            graph.get(end).add(start);
        }
        br.close();
    }


}