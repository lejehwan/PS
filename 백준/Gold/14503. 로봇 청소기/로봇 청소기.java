import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int[][] map;
    static int answer;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            map = new int[N][M];
            String[] input2 = br.readLine().split(" ");
            int r = Integer.parseInt(input2[0]);
            int c = Integer.parseInt(input2[1]);
            int d = Integer.parseInt(input2[2]);
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[] {r, c , d});
            for (int i = 0; i < N; i++) {
                String[] data = br.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(data[j]);
                }
            }

            cleaning(queue);
            System.out.println(answer);
        }
    }

    private static void cleaning(Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] getQue = queue.poll();
            int getX = getQue[0];
            int getY = getQue[1];
            int getD = getQue[2];
            CleaningCheck(getX, getY);
            boolean isAllClean = true;
            for (int i = 0; i < 4; i++) {
                getD = (getD + 3) % 4;
                int[] next = moveForward(getX, getY, getD);
                int newX = next[0];
                int newY = next[1];
                if (isValidMapSize(newX, newY) && map[newX][newY] == 0) {
                    isAllClean = false;
                    queue.add(new int[]{newX, newY, getD});
                    break;
                }
            }

            if (isAllClean) {
                int[] back = moveReverse(getX, getY, getD);
                int newX = back[0];
                int newY = back[1];
                if (isValidMapSize(newX, newY) && map[newX][newY] != 1) {
                    queue.add(new int[]{newX, newY, getD});
                } else {
                    break;
                }
            }
        }
    }

    private static void CleaningCheck(int x, int y) {
        if (map[x][y] == 0) {
            map[x][y] = 2;
            answer++;
        }
    }

    private static int[] moveForward(int x, int y, int direction) {
        switch (direction) {
            case 0: return new int[] {x - 1, y};
            case 1: return new int[] {x, y + 1};
            case 2: return new int[] {x + 1, y};
            case 3: return new int[] {x, y - 1};
            default: return new int[] {x, y};
        }
    }

    private static int[] moveReverse(int x, int y, int direction) {
        switch (direction) {
            case 0: return new int[] {x + 1, y};
            case 1: return new int[] {x, y - 1};
            case 2: return new int[] {x - 1, y};
            case 3: return new int[] {x, y + 1};
            default: return new int[] {x, y};
        }
    }

    private static boolean isValidMapSize(int x, int y) {
        return x >= 0 && x < map.length && y >= 0 && y < map[0].length;
    }

}
