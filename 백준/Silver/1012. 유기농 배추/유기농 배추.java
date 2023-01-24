
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] graph;
    static boolean[][] visited;
    static int[] addRow = {0, 1, -1, 0};
    static int[] addCol = {1, 0, 0, -1};
    static int row, col = 0;
    public static void main(String[] args) throws IOException {
        //setUp
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            int cabbage = Integer.parseInt(st.nextToken());
            graph = new int[col][row];
            for (int j = 0; j < cabbage; j++) {
                String[] inputLine = br.readLine().split(" ");
                graph[Integer.parseInt(inputLine[1])][Integer.parseInt(inputLine[0])] = 1;
            }
            int cnt = 0;
            visited = new boolean[col][row];
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < row; k++) {
                    if (graph[j][k] == 1 && !visited[j][k]){
                        bfs(j,k);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }

    }

    private static void bfs(int xVertex, int yVertex){
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
                if (newXVertex >= 0 && newXVertex < col && newYVertex >=0 && newYVertex < row){
                    if (graph[newXVertex][newYVertex] == 1 && !visited[newXVertex][newYVertex]){
                        queue.add(new int[] {newXVertex, newYVertex});
                        visited[newXVertex][newYVertex] = true;
                    }
                }
            }
        }
    }

}