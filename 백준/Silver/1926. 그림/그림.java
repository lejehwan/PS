import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int[][] graph;
    static boolean[][] visited;
    static int[] addRow = {1, -1, 0, 0};
    static int[] addCol = {0, 0, 1, -1};
    static int cntByPic, row, col = 0;
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        graph = new int[row][col];
        visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        findCount();
        answer();
    }

    private static void answer() {
        int maxCnt = 0;
        for (Integer value : list) {
            maxCnt = Math.max(maxCnt, value);
        }
        System.out.println(list.size());
        System.out.println(maxCnt);
    }

    private static void findCount(){
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    dfs(i,j);
                    list.add(cntByPic);
                    cntByPic = 0;
                }
            }
        }
    }

    private static void dfs(int x, int y) {
        cntByPic++;
        visited[x][y] = true;
        for (int i = 0; i < addRow.length; i++) {
            int newX = x + addRow[i];
            int newY = y + addCol[i];
            if (newX >= 0 && newX < row && newY >= 0 && newY < col && !visited[newX][newY] && graph[newX][newY] == 1){
                dfs(newX, newY);
            }
        }
    }

}