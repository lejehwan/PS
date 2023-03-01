import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] graph;
    static int[] addRow = {1, -1, 0, 0};
    static int[] addCol = {0, 0, 1, -1};
    static int row, col, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        graph = new int[row][col];
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0;
        while ( (cnt = separateNum()) < 2){
            if (cnt == 0){// 빙하가 다 녹음
                answer = 0;
                break;
            }
            bfs();
            answer ++;
        }

        outPut();
    }

    private static void outPut() {
        System.out.println(answer);
    }

    // 분리된 빙하의 개수 구하기
    private static int separateNum() {
        boolean[][] visited = new boolean[row][col];
        int cnt = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (graph[i][j] != 0 && !visited[i][j]){
                    dfs(i, j, visited);
                    cnt++;
                    // cnt가 2 이상일 경우 = 분리된 빙하가 2개 이상 이므로
                    // 빠져나오는 로직 필요
                }
            }
        }
        return cnt;
    }

    private static void dfs(int x, int y, boolean[][] visited) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + addRow[i];
            int newY = y + addCol[i];
            if (graph[newX][newY] != 0 && !visited[newX][newY]){
                dfs(newX, newY, visited);
            }
        }
    }

    // 녹는 빙하
    private static void bfs(){
        boolean[][] visited = new boolean[row][col];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (graph[i][j] != 0){
                    queue.add(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }
        while (!queue.isEmpty()){
            int getX = queue.peek()[0];
            int getY = queue.peek()[1];
            queue.poll();
            int cnt = 0;
            for (int i = 0; i < 4; i++) {
                int newX = getX + addRow[i];
                int newY = getY + addCol[i];
                if(graph[newX][newY] == 0 && !visited[newX][newY]){
                    cnt++;
                }
            }
            if (graph[getX][getY] - cnt < 0){
                graph[getX][getY] = 0;
            }else graph[getX][getY] -= cnt;
        }
    }

}