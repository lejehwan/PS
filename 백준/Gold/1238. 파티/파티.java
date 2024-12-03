import javax.swing.*;
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

    static int N, INF = Integer.MAX_VALUE;
    static List<List<Node>> graph = new ArrayList<>();
    static List<List<Node>> reverseGraph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] data = br.readLine().split(" ");
            N = Integer.parseInt(data[0]);
            int M = Integer.parseInt(data[1]);
            int X = Integer.parseInt(data[2]);
            for (int i = 0; i < N + 1; i++) {
                graph.add(new ArrayList<>());
                reverseGraph.add(new ArrayList<>());
            }
            for (int i = 0; i < M; i++) {
                String[] input = br.readLine().split(" ");
                int fromV = Integer.parseInt(input[0]);
                int toV = Integer.parseInt(input[1]);
                int weight = Integer.parseInt(input[2]);
                graph.get(fromV).add(new Node(toV, weight));
                reverseGraph.get(toV).add(new Node(fromV, weight));
            }

            int[] fromX = dijkstra(graph, X);
            int[] toX = dijkstra(reverseGraph, X);

            int answer = findMostTimeConsuming(fromX, toX);
            System.out.println(answer);
        }
    }

    private static int findMostTimeConsuming(int[] fromX, int[] toX) {
        int mostTime = 0;
        for (int i = 1; i < N + 1; i++) {
            if (fromX[i] != INF && toX[i] != INF) mostTime = Math.max(mostTime, fromX[i] + toX[i]);
        }
        return mostTime;
    }

    private static int[] dijkstra(List<List<Node>> graph, int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int crtV = node.vertex;
            int crtW = node.weight;

            if (crtW > dist[crtV]) continue;

            for (Node nxt: graph.get(crtV)) {
                int newDist = dist[crtV] + nxt.weight;
                if (newDist < dist[nxt.vertex]) {
                    dist[nxt.vertex] = newDist;
                    pq.add(new Node(nxt.vertex, newDist));
                }
            }
        }

        return dist;
    }

}
