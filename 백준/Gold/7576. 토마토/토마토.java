import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int row, col, answer = 0;
    static int[][] graph;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] addRow = {-1, 1, 0 ,0};
    static int[] addCol = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        graph = new int[col][row];
        for (int i = 0; i < graph.length; i++) {
            String[] inputLine = br.readLine().split(" ");
            for (int j = 0; j < graph[i].length; j++) {
                graph[i][j] = Integer.parseInt(inputLine[j]);
                if (graph[i][j] == 1) {
                    queue.add(new int[] {i, j});
                }
            }
        }
        bfs();
        checkTomato();
//        print();
    }

    public static void checkTomato(){
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                answer = Math.max(answer, graph[i][j]);
            }
        }
        System.out.println(answer - 1);
    }

    public static void bfs(){
        while (!queue.isEmpty()){
            int getXVertex = queue.peek()[0];
            int getYVertex = queue.peek()[1];
            queue.poll();
            for (int i = 0; i < addRow.length; i++) {
                int newXVertex = getXVertex + addRow[i];
                int newYVertex = getYVertex + addCol[i];
                if (newXVertex >= 0 && newXVertex < col && newYVertex >= 0 && newYVertex < row){
                    if (graph[newXVertex][newYVertex] == 0){
                        queue.add(new int[] {newXVertex, newYVertex});
                        graph[newXVertex][newYVertex] = graph[getXVertex][getYVertex] + 1;
                    }
                }
            }
        }
    }

    public static void print(){
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}