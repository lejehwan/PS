import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main {

    static final String SPACE = " ";
    static final String ENTER = "\n";
    static int[][] map;
    static boolean[] visited;
    static int v;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        init();
        printDFS(v);
        printBFS(v);
        printAnswer();
    }

    private static void printAnswer() {
        System.out.println(sb.toString());
    }

    private static void printBFS(int v) {
        visited = new boolean[map.length];
        sb.append(ENTER);
        sb.append(v).append(SPACE);
        bfs(v);
    }

    private static void printDFS(int v) {
        visited = new boolean[map.length];
        sb.append(v).append(SPACE);
        dfs(v);
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;
        while (!queue.isEmpty()) {
            int getV = queue.poll();
            for (int i = 1; i < map.length; i++) {
                if (map[getV][i] != 0 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    sb.append(i).append(SPACE);
                }
            }
        }

    }

    private static void dfs(int v) {
        visited[v] = true;
        for (int i = 1; i < map.length; i++) {
            if (map[v][i] != 0 && !visited[i]) {
                sb.append(i).append(SPACE);
                dfs(i);
            }
        }
    }


    private static void init() throws IOException {
        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        map = new int[Integer.parseInt(input[0]) + 1][Integer.parseInt(input[0]) + 1];
        v = Integer.parseInt(input[2]);
        for (int i = 0; i < Integer.parseInt(input[1]); i++) {
            String[] data = br.readLine().split(" ");
            int startV = Integer.parseInt(data[0]);
            int endV = Integer.parseInt(data[1]);
            map[startV][endV] = 1;
            map[endV][startV] = 1;
        }
        br.close();
    }


}
