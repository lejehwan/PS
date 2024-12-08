import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int fromV;
        int toV;
        int weight;
        public Node(int fromV, int toV, int weight) {
            this.fromV = fromV;
            this.toV = toV;
            this.weight = weight;
        }
    }

    static List<Node> graph;
    static int N, INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();
            int TC = Integer.parseInt(br.readLine());
            for (int i = 0; i < TC; i++) {
                String[] data = br.readLine().split(" ");
                N = Integer.parseInt(data[0]);
                int M = Integer.parseInt(data[1]);
                int W = Integer.parseInt(data[2]);
                graph = new ArrayList<>();
                for (int j = 0; j < M; j++) {
                    String[] input = br.readLine().split(" ");
                    int S = Integer.parseInt(input[0]);
                    int E = Integer.parseInt(input[1]);
                    int T = Integer.parseInt(input[2]);
                    graph.add(new Node(S, E, T));
                    graph.add(new Node(E, S, T));
                }
                for (int j = 0; j < W; j++) {
                    String[] input = br.readLine().split(" ");
                    int S = Integer.parseInt(input[0]);
                    int E = Integer.parseInt(input[1]);
                    int T = Integer.parseInt(input[2]);
                    graph.add(new Node(S, E, -T));
                }
                if (findNegativeCycle()){
                    sb.append("YES").append("\n");
                }else {
                    sb.append("NO").append("\n");
                }
            }
            System.out.println(sb);
        }
    }

    private static boolean findNegativeCycle() {
        long[] dist = new long[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        for (int i = 1; i <= N; i++) {
            for (Node node : graph) {
                if (dist[node.toV] > dist[node.fromV] + node.weight) {
                    dist[node.toV] = dist[node.fromV] + node.weight;
                    if (i == N) return true;
                }
            }
        }
        return false;
    }

}
