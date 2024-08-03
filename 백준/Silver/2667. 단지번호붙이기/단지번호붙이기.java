import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    private static final int[] ADD_X = new int[] {1, -1, 0, 0};
    private static final int[] ADD_Y = new int[] {0, 0, 1, -1};
    private static final int FILLED = 1;

    private static int[][] map;
    private static boolean[][] visited;
    private static int cnt = 0;
    private static List<Integer> answerList;

    public static void main(String[] args) throws IOException {
        init();
        exhaustiveSearch();
        answer();
    }

    private static void answer() {
        System.out.println(answerList.size());
        answerList.stream().sorted().forEach(System.out::println);
    }

    private static void exhaustiveSearch() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == FILLED && !visited[i][j]) {
                    bfs(i, j);
                    answerList.add(cnt);
                }
            }
        }
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;
        cnt = 1;

        while (!queue.isEmpty()) {
            int getX = queue.peek()[0];
            int getY = queue.peek()[1];
            queue.poll();
            for (int i = 0; i < ADD_X.length; i++) {
                int newX = getX + ADD_X[i];
                int newY = getY + ADD_Y[i];
                if (isValidMapSize(newX, newY)
                        && map[newX][newY] == FILLED && !visited[newX][newY]) {
                    cnt ++;
                    visited[newX][newY] = true;
                    queue.add(new int[] {newX, newY});
                }
            }
        }
    }

    private static boolean isValidMapSize(int newX, int newY) {
        return newX >= 0 && newX < map.length && newY >= 0 && newY < map.length;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        map = new int[size][size];
        visited = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            String line = br.readLine();
            for (int j = 0; j < size; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        answerList = new ArrayList<>();
    }
}