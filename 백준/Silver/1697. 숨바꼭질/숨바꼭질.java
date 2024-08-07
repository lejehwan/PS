import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static int[] map;
    private static boolean[] visited;
    private static int N = 0, K = 0 ;

    public static void main(String[] args) throws IOException {
        init();
        bfs(N);
        printAnswer();
    }

    private static void printAnswer() {
        System.out.println(map[K]);
    }

    private static void bfs(int point) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(point);
        visited[point] = true;

        while (!queue.isEmpty()) {
            int getPoint = queue.poll();
            for (int newPoint: getNextPoint(getPoint)) {
                if (isValidMapSize(newPoint) && !visited[newPoint]) {
                    queue.add(newPoint);
                    visited[newPoint] = true;
                    map[newPoint] = map[getPoint] + 1;
                }
            }
        }
    }

    private static boolean isValidMapSize(int point) {
        return point >= 0 && point < map.length;
    }

    private static int[] getNextPoint(int point) {
        return new int[] {point + 1, point -1, point * 2};
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        map = new int[100001];
        visited = new boolean[map.length];
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        br.close();
    }
}