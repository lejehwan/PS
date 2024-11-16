import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int[] vertical = new int[100001];
    static boolean[] visited = new boolean[100001];

    public static class Node implements Comparable<Node> {
        int position;
        int time;
        public Node(int position, int time) {
            this.position = position;
            this.time = time;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.time, o.time);
        }
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int K = Integer.parseInt(input[1]);

            System.out.println(dequeBfs(N, K));
//            System.out.println(priorityQueueBfs(N, K));
        }
    }

    private static int dequeBfs(int N, int K) {
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
        return -1;
    }

    private static int priorityQueueBfs(int N, int K) {
        Arrays.fill(vertical, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(N, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.position;
            if (now == K) return node.time;
            for (int[] move : movesWithWeight(now)) {
                int next = move[0];
                int weight = move[1];
                if (isValid(next)) {
                    int newCost = node.time + weight;
                    if (newCost < vertical[next]) {
                        vertical[next] = newCost;
                        pq.add(new Node(next, newCost));
                    }
                }
            }
        }
        return -1;
    }

    private static boolean isValid(int x) {
        return x >= 0 && x < vertical.length;
    }

    private static int[] moves(int x) {
        return new int[] {x - 1, x + 1, x * 2};
    }

    private static int[][] movesWithWeight(int x) {
        return new int[][] {
                {x - 1, 1},
                {x + 1, 1},
                {x * 2, 0}
        };
    }

}
