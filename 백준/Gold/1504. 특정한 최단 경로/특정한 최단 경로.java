import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node>{
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

    static List<List<Node>> graph = new ArrayList<>();
    static int N, INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] data = br.readLine().split(" ");
            N = Integer.parseInt(data[0]);
            int E = Integer.parseInt(data[1]);
            for (int i = 0; i < N + 1; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                String[] input = br.readLine().split(" ");
                int fromV = Integer.parseInt(input[0]);
                int toV = Integer.parseInt(input[1]);
                int weight = Integer.parseInt(input[2]);
                graph.get(fromV).add(new Node(toV, weight));
                graph.get(toV).add(new Node(fromV, weight));
            }

            String[] input = br.readLine().split(" ");
            int necessaryV1 = Integer.parseInt(input[0]);
            int necessaryV2 = Integer.parseInt(input[1]);

            int route1 = findSpecificShortestPath(necessaryV1, necessaryV2);
            int route2 = findSpecificShortestPath(necessaryV2, necessaryV1);
            int result = Math.min(route1, route2);
            System.out.println(result == INF ?  -1 : result);
        }
    }

    private static int findSpecificShortestPath(int necessaryV1, int necessaryV2) {
        int startVToNecessaryV = dijkstra(1, necessaryV1);
        int necessaryVToNecessaryV = dijkstra(necessaryV1, necessaryV2);
        int necessaryVToN = dijkstra(necessaryV2, N);

        if (startVToNecessaryV == INF || necessaryVToNecessaryV == INF || necessaryVToN == INF) {
            return INF;
        }
        return startVToNecessaryV + necessaryVToNecessaryV + necessaryVToN;
    }

    private static int dijkstra(int fromV, int toV) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(fromV, 0));

        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[fromV] = 0;

        while (!pq.isEmpty()) {
            Node getNode = pq.poll();
            int curV = getNode.vertex;
            int curW = getNode.weight;

            if (dist[curV] < curW) continue;

            for (Node nxt : graph.get(curV)) {
                int newDist = dist[curV] + nxt.weight;
                if (newDist < dist[nxt.vertex]) {
                    dist[nxt.vertex] = newDist;
                    pq.add(new Node(nxt.vertex, newDist));
                }
            }
        }
        return dist[toV];
    }

}
