import java.util.*;

class Solution {
    static int[] addRow = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] addCol = {0, 0, -1, 1, -1, 1, 1, -1};
    static int[][] graph;
    static int row, col = 0;
    static Queue<int[]> queue = new LinkedList<>();
    
    public int solution(int[][] board) {
        initializeGraph(board);
        bfs();
        return countSafeLocate();
    }
    
    private void initializeGraph(int[][] board) {
        graph = board;
        row = graph.length;
        col = graph[0].length;
        findInitialOnes();
    }
    
    private void findInitialOnes() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (graph[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }
    }
    
    private void bfs() {
        while (!queue.isEmpty()) {
            int[] vertex = queue.poll();
            int getVertexX = vertex[0];
            int getVertexY = vertex[1];
            
            for (int i = 0; i < addRow.length; i++) {
                int newVertexX = getVertexX + addRow[i];
                int newVertexY = getVertexY + addCol[i];
                
                if (isValidPosition(newVertexX, newVertexY) && graph[newVertexX][newVertexY] == 0) {
                    graph[newVertexX][newVertexY] = 1;
                }
            }
        }
    }
    
    private boolean isValidPosition(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }
    
    private int countSafeLocate() {
        return (int) Arrays.stream(graph)
                .flatMapToInt(Arrays::stream)
                .filter(value -> value == 0)
                .count();
    }
}