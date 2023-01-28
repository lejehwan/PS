import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int mapSize;
    static int[][] graph;
    static boolean[][] visited;
    static int[] addRow = {-2, -1, 2, 1, 2, 1, -2, -1};
    static int[] addCol = {1, 2, 1, 2, -1, -2, -1, -2};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            mapSize = Integer.parseInt(br.readLine());
            graph = new int[mapSize][mapSize];
            visited = new boolean[mapSize][mapSize];
            st = new StringTokenizer(br.readLine());
            int inputX = Integer.parseInt(st.nextToken());
            int inputY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int resultX = Integer.parseInt(st.nextToken());
            int resultY = Integer.parseInt(st.nextToken());
            bfs(inputX, inputY);
            System.out.println(graph[resultX][resultY]);
        }
    }

    public static void bfs(int xVertex, int yVertex){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {xVertex, yVertex});
        visited[xVertex][yVertex] = true;
        while (!queue.isEmpty()){
            int getXVertex = queue.peek()[0];
            int getYVertex = queue.peek()[1];
            queue.poll();
            for (int i = 0; i < addRow.length; i++) {
                int newXVertex = getXVertex + addRow[i];
                int newYVertex = getYVertex + addCol[i];
                if (newXVertex >= 0 && newXVertex < mapSize && newYVertex >= 0 && newYVertex < mapSize){
                    if (!visited[newXVertex][newYVertex]){
                        queue.add(new int[] {newXVertex, newYVertex});
                        visited[newXVertex][newYVertex] = true;
                        graph[newXVertex][newYVertex] = graph[getXVertex][getYVertex] + 1;
                    }
                }
            }
        }
    }
}