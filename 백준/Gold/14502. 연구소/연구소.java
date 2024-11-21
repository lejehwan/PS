import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

class Main {

    static int[][] map;
    static int[][] tempMap;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            map = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] data = br.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(data[j]);
                }
            }
            canBuildWalls(0, 0);
            System.out.println(answer);
        }
    }

    private static void canBuildWalls(int start, int depth) {
        if (depth == 3) {
            findVirus();
            answer = Math.max(answer, findSafeArea());
            return;
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    canBuildWalls(start + 1, depth + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void findVirus() {
        tempMap = Stream.of(map).map(int[]::clone).toArray(int[][]::new);
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < tempMap.length; i++) {
            for (int j = 0; j < tempMap[0].length; j++) {
                if (tempMap[i][j] == 2) queue.add(new int[] {i, j});
            }
        }
        spreadVirus(queue);
    }

    private static void spreadVirus(Queue<int[]> queue) {
        int[] addX = new int[] {1, -1, 0, 0};
        int[] addY = new int[] {0, 0, 1, -1};
        while (!queue.isEmpty()) {
            int[] getQueue = queue.poll();
            int getX = getQueue[0];
            int getY = getQueue[1];
            for (int i = 0; i < addX.length; i++) {
                int newX = getX + addX[i];
                int newY = getY + addY[i];
                if (isValidMapSize(newX, newY) && tempMap[newX][newY] == 0) {
                    tempMap[newX][newY] = 2;
                    queue.add(new int[] {newX, newY});
                }
            }
        }
    }

    private static boolean isValidMapSize(int x, int y) {
        return x >= 0 && x < tempMap.length && y >= 0 && y < tempMap[0].length;
    }


    private static int findSafeArea() {
        return (int) Arrays.stream(tempMap)
                .flatMapToInt(Arrays::stream)
                .filter(value -> value == 0)
                .count();
    }

}
