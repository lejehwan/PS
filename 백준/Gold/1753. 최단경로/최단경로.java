import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    public static class Node implements Comparable<Node>{
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static List<ArrayList<Node>> graph = new ArrayList<>();
    static int[] dist;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] input = br.readLine().split(" ");
            int V = Integer.parseInt(input[0]);
            int E = Integer.parseInt(input[1]);
            int start = Integer.parseInt(br.readLine());
            dist = new int[V + 1];
            for (int i = 0; i <= V; i++) {
                graph.add(new ArrayList<>());
                dist[i] = INF;
            }
            for (int i = 0; i < E; i++) {
                String[] data = br.readLine().split(" ");
                int startV = Integer.parseInt(data[0]);
                int endV = Integer.parseInt(data[1]);
                int weight = Integer.parseInt(data[2]);
                graph.get(startV).add(new Node(endV, weight));
            }

            dijkstra(start, 0);
            System.out.println(printAnswer());
        }
    }

    private static StringBuilder printAnswer() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == INF) sb.append("INF");
            else sb.append(dist[i]);
            sb.append("\n");
        }
        return sb;
    }

    private static void dijkstra(int vertex, int weight) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[vertex] = 0;
        pq.add(new Node(vertex, weight));

        while (!pq.isEmpty()) {
            Node getNode = pq.poll();
            int getVertex = getNode.vertex;
            int getWeight = getNode.weight;

            if (getWeight > dist[getVertex]) continue;

            for (Node node : graph.get(getVertex)) {
                int newDist = dist[getVertex] + node.weight;
                if (dist[node.vertex] > newDist) {
                    dist[node.vertex] = newDist;
                    pq.add(new Node(node.vertex, newDist));
                }
            }
        }
    }
}
