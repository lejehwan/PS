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

            int answer = findSpecificShortestPath(necessaryV1, necessaryV2);
            System.out.println(answer);
        }
    }

    private static int findSpecificShortestPath(int necessaryV1, int necessaryV2) {
        int startV = 1;
        int startVToNecessaryV1 = dijkstra(startV, necessaryV1);
        int necessaryV1ToNecessaryV2 = dijkstra(necessaryV1, necessaryV2);
        int necessaryV2ToN = dijkstra(necessaryV2, N);
        int case1Result = (startVToNecessaryV1 == INF || necessaryV1ToNecessaryV2 == INF || necessaryV2ToN == INF) ?
                INF : startVToNecessaryV1 + necessaryV1ToNecessaryV2 + necessaryV2ToN;

        int startVToNecessaryV2 = dijkstra(startV, necessaryV2);
        int necessaryV2ToNecessaryV1 = dijkstra(necessaryV2, necessaryV1);
        int necessaryV1ToN = dijkstra(necessaryV1, N);
        int case2Result = (startVToNecessaryV2 == INF || necessaryV2ToNecessaryV1 == INF || necessaryV1ToN == INF)
                ? INF : startVToNecessaryV2 + necessaryV2ToNecessaryV1 + necessaryV1ToN;

        int answer = Math.min(case1Result, case2Result);
        return answer == INF ?  -1 : answer;
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
