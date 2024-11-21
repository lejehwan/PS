import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

class Main {

    static int[][] map;
    static int[][] tempMap;
    static int answer = 0;
    static List<int[]> emptySpaces = new ArrayList<>();
    static List<int[]> viruses = new ArrayList<>();

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
                    if (map[i][j] == 0) emptySpaces.add(new int[]{i, j});
                    else if (map[i][j] == 2) viruses.add(new int[]{i, j});
                }
            }
            canBuildWalls(0, 0, new int[3][2]);
            System.out.println(answer);
        }
    }

    private static void canBuildWalls(int start, int depth, int[][] selectedWalls) {
        if (depth == 3) {
            tempMap = Stream.of(map).map(int[]::clone).toArray(int[][]::new);
            for (int[] wall : selectedWalls) {
                tempMap[wall[0]][wall[1]] = 1;
            }
            findVirus();
            answer = Math.max(answer, findSafeArea());
            return;
        }

        for (int i = start; i < emptySpaces.size(); i++) {
            selectedWalls[depth] = emptySpaces.get(i);
            canBuildWalls(i + 1, depth + 1, selectedWalls);
        }
    }

    private static void findVirus() {
        Queue<int[]> queue = new LinkedList<>(viruses);
        spreadVirus(queue);
    }

    private static void spreadVirus(Queue<int[]> queue) {
        int[] addX = new int[] {1, -1, 0, 0};
        int[] addY = new int[] {0, 0, 1, -1};
        while (!queue.isEmpty()) {
            int[] getQueue = queue.poll();
            for (int i = 0; i < addX.length; i++) {
                int newX = getQueue[0] + addX[i];
                int newY = getQueue[1] + addY[i];
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
