import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

class Main {

    static int[] vertical = new int[100001];
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int K = Integer.parseInt(input[1]);

            System.out.println(bfs(N, K));
        }
    }

    private static int bfs(int N, int K) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(N);
        while(!deque.isEmpty()) {
            int now = deque.poll();
            if (now == K) return vertical[now];
            for (int move : moves(now)) {
                if (isValid(move) && !visited[move]) {
                    visited[move] = true;
                    if (move == now * 2) {
                        deque.addFirst(move);
                        vertical[move] = vertical[now];
                    } else {
                        deque.addLast(move);
                        vertical[move] = vertical[now] + 1;
                    }
                }
            }
        }
        return vertical[K];
    }

    private static boolean isValid(int x) {
        return x >= 0 && x < vertical.length;
    }

    private static int[] moves(int x) {
        return new int[] {x - 1, x + 1, x * 2};
    }

}
