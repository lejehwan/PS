import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {

    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        init();
        int answer = exhaustSearch();
        System.out.println(answer);
    }

    private static int exhaustSearch() {
        int cnt = 0;
        for (int i = 1; i < list.size(); i++) {
            if (!visited[i]) {
                dfs(i);
//                bfs(i);
                cnt ++;
            }
        }
        return cnt;
    }

    private static void dfs(int vertex) {
        visited[vertex] = true;
        for (Integer newV : list.get(vertex)) {
            if (!visited[newV]) {
                dfs(newV);
            }
        }
    }

    private static void bfs(int vertex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(vertex);
        visited[vertex] = true;

        while (!queue.isEmpty()) {
            int getV = queue.poll();
            for (Integer newV : list.get(getV)) {
                if (!visited[newV]) {
                    queue.add(newV);
                    visited[newV] = true;
                }
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        visited = new boolean[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            String[] data = br.readLine().split(" ");
            int startV = Integer.parseInt(data[0]);
            int endV = Integer.parseInt(data[1]);
            list.get(startV).add(endV);
            list.get(endV).add(startV);
        }
        br.close();
    }


}