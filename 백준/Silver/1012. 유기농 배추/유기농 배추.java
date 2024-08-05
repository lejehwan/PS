import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    private static final int[] ADD_X = {1, -1, 0, 0};
    private static final int[] ADD_Y = {0, 0, 1, -1};

    private static int[][] maps;
    private static boolean[][] visited;
    private static int cnt = 0;
    private static List<Integer> answerList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        solution();
        printAnswer();
    }

    private static void printAnswer() {
        answerList.forEach(System.out::println);
    }

    private static void exhaustiveSearch() {
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length; j++) {
                if (maps[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                    cnt++;
                }
            }
        }
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int getX = queue.peek()[0];
            int getY = queue.peek()[1];
            queue.poll();
            for (int i = 0; i < ADD_X.length; i++) {
                int newX = getX + ADD_X[i];
                int newY = getY + ADD_Y[i];
                if (isValidMapSize(newX, newY) && maps[newX][newY] == 1 && !visited[newX][newY]) {
                    queue.add(new int[] {newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }
    }

    private static boolean isValidMapSize(int newX, int newY) {
        return newX >= 0 && newX < maps.length && newY >= 0 && newY < maps[0].length;
    }

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String[] line = br.readLine().split(" ");
            maps = new int[Integer.parseInt(line[0])][Integer.parseInt(line[1])];
            visited = new boolean[maps.length][maps[0].length];
            for (int j = 0; j < Integer.parseInt(line[2]); j++) {
                String[] input = br.readLine().split(" ");
                maps[Integer.parseInt(input[0])][Integer.parseInt(input[1])] = 1;
            }

            exhaustiveSearch();
            answerList.add(cnt);
            cnt = 0;
        }
    }
}