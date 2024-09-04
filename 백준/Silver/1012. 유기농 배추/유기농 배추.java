import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main {

    static final int[] ADD_X = {1, -1, 0, 0};
    static final int[] ADD_Y = {0, 0, 1, -1};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        int testCaseCnt = readTestCaseCnt();
        for (int i = 0; i < testCaseCnt; i++) {
            init();
            int answer = exhaustiveSearch();
            System.out.println(answer);
        }
        closeStream();
    }

    private static int exhaustiveSearch() {
        int answer = 0;
        for (int j = 0; j < map.length; j++) {
            for (int k = 0; k < map[0].length; k++) {
                if (map[j][k] == 1 && !visited[j][k]) {
                    bfs(j, k);
                    answer ++;
                }
            }
        }
        return answer;
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
                if (isValidMapSize(newX, newY) && map[newX][newY] == 1 && !visited[newX][newY]) {
                    queue.add(new int[] {newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }
    }

    private static boolean isValidMapSize(int x, int y) {
        return x >= 0 && x < map.length && y >= 0 && y < map[0].length;
    }

    private static void init() throws Exception {
        String[] input = br.readLine().split(" ");
        map = new int[Integer.parseInt(input[0])][Integer.parseInt(input[1])];
        visited = new boolean[map.length][map[0].length];
        for (int i = 0; i < Integer.parseInt(input[2]); i++) {
            String[] data = br.readLine().split(" ");
            map[Integer.parseInt(data[0])][Integer.parseInt(data[1])] = 1;
        }
    }

    private static int readTestCaseCnt() throws Exception {
        return Integer.parseInt(br.readLine());
    }

    private static void closeStream() throws Exception {
        br.close();
    }

}
