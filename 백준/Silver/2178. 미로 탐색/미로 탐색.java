import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] graph;
    static int row, col = 0;
    static int[] addRow = {1, -1, 0, 0};
    static int[] addCol = {0, 0, 1, -1};
    static int[][] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        graph = new int[row][col];
        for (int i = 0; i < row; i++) {
            String[] inputLine = br.readLine().split("");
            for (int j = 0; j < col; j++) {
                graph[i][j] = Integer.parseInt(inputLine[j]);
            }
        }
        cost = new int[row][col];
        bfs(0, 0);
        outPut();
    }

    private static void outPut() {
        System.out.println(graph[row - 1][col - 1]);
    }

    private static void bfs(int xVertex, int yVertex) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{xVertex, yVertex});
        cost[xVertex][yVertex] = 1;
        while (!queue.isEmpty()) {
            int getXVertex = queue.peek()[0];
            int getYVertex = queue.peek()[1];
            queue.poll();
            for (int i = 0; i < 4; i++) {
                int newXVertex = getXVertex + addRow[i];
                int newYVertex = getYVertex + addCol[i];
                if (newXVertex >= 0 && newXVertex < row && newYVertex >= 0 && newYVertex < col) {
                    if (graph[newXVertex][newYVertex] == 1) {
                        queue.add(new int[]{newXVertex, newYVertex});
                        graph[newXVertex][newYVertex] = graph[getXVertex][getYVertex] + 1;
                    }
                }
            }
        }
    }

}