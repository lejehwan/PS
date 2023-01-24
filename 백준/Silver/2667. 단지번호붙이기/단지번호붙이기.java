
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[][] visited;
    static int[] addRow = {0, 1, -1, 0};
    static int[] addCol = {1, 0, 0, -1};
    static int mapSize, cnt = 0;
    static ArrayList<Integer> store = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        //setUp
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        mapSize = Integer.parseInt(br.readLine());
        for (int i = 0; i < mapSize; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < mapSize; i++) {
            String[] inputLine = br.readLine().split("");
            for (int j = 0; j < mapSize; j++) {
                graph.get(i).add(Integer.parseInt(inputLine[j]));
            }
        }
        visited = new boolean[mapSize][mapSize];
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if (graph.get(i).get(j) == 1 && !visited[i][j]){
                    bfs(i, j);
                    store.add(cnt);
                    cnt = 0;
                }
            }
        }
        outPut();
    }

    private static void outPut(){
        System.out.println(store.size());
        Collections.sort(store);
        for (Integer answer : store) {
            System.out.println(answer);
        }
    }

    private static void bfs(int xVertex, int yVertex){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {xVertex, yVertex});
        visited[xVertex][yVertex] = true;
        cnt++;
        while (!queue.isEmpty()){
            int getXVertex = queue.peek()[0];
            int getYVertex = queue.peek()[1];
            queue.poll();
            for (int i = 0; i < 4; i++) {
                int newXVertex = getXVertex + addRow[i];
                int newYVertex = getYVertex + addCol[i];
                if (newXVertex >= 0 && newXVertex < mapSize && newYVertex >= 0 && newYVertex < mapSize){
                    if (graph.get(newXVertex).get(newYVertex) == 1 && !visited[newXVertex][newYVertex]){
                        queue.add(new int[]{newXVertex, newYVertex});
                        visited[newXVertex][newYVertex] = true;
                        cnt++;
                    }
                }
            }
        }
    }

}