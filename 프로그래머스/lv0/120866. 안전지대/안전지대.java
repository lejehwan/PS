import java.util.*;

class Solution {
    static int[] addRow = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] addCol = {0, 0, -1, 1, -1, 1, 1, -1};
    static int[][] graph;
    static int row, col = 0;
    static Queue<int[]> queue = new LinkedList<>();
    
    public int solution(int[][] board) {
        graph = board;
        row = graph.length;
        col = graph[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (graph[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        bfs();
        return getSafeLocate();
    }
    
    public static void bfs() {
        while (!queue.isEmpty()) {
            int getVertexX = queue.peek()[0];
            int getVertexY = queue.peek()[1];
            queue.poll();
            for (int i = 0; i < addRow.length; i++) {
                int newVertexX = getVertexX + addRow[i];
                int newVertexY = getVertexY + addCol[i];
                if (newVertexX >= 0 && newVertexX < row && newVertexY >= 0 && newVertexY < col
                        && graph[newVertexX][newVertexY] == 0) {
                    graph[newVertexX][newVertexY] = 1;
                }
            }
        }
    }
    
    public static int getSafeLocate() {
        int cnt = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (graph[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }
}