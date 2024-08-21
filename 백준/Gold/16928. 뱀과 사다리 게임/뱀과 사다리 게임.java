import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static int[] map = new int[101];
    private static boolean[] visited = new boolean[101];

    public static void main(String[] args) throws IOException {
        init();
        bfs();
        printAnswer();
    }

    private static void printAnswer() {
        System.out.println(map[map.length - 1]);
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int getX = queue.poll();
            for (int i = 1; i <= 6; i++) {
                int newX = getX + i;
                if (isValidMapSize(newX)) {
                    if (map[newX] != 0) newX = map[newX];
                    if (!visited[newX]) {
                        queue.add(newX);
                        visited[newX] = true;
                        map[newX] = map[getX] + 1;
                    }
                }
            }
        }
    }

    private static boolean isValidMapSize(int x) {
        return x <= map.length - 1;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int ladder = Integer.parseInt(input[0]);
        int snake = Integer.parseInt(input[1]);
        for (int i = 0; i < ladder + snake; i++) {
            String[] data = br.readLine().split(" ");
            map[Integer.parseInt(data[0])] = Integer.parseInt(data[1]);
        }
    }
}