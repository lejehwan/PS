import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static class Node {
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "vertex=" + vertex +
                    ", weight=" + weight +
                    '}';
        }
    }

    static List<ArrayList<Node>> graph = new ArrayList<>();
    static boolean[] visited;
    static Node maxNode;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n + 1; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < n - 1; i++) {
                String[] input = br.readLine().split(" ");
                int startV = Integer.parseInt(input[0]);
                int endV = Integer.parseInt(input[1]);
                int weight = Integer.parseInt(input[2]);
                graph.get(startV).add(new Node(endV, weight));
                graph.get(endV).add(new Node(startV, weight));
            }

            visited = new boolean[n + 1];
            bfs(1, 0);
//            System.out.println(maxNode);

            visited = new boolean[n + 1];
            bfs(maxNode.vertex, 0);
//            System.out.println(maxNode);

            System.out.println(maxNode.weight);
        }
    }

    private static void bfs(int vertex, int weight) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(vertex, weight));
        visited[vertex] = true;
        maxNode = new Node(vertex, weight);

        while (!queue.isEmpty()) {
            Node getNode = queue.poll();
            int getVertex = getNode.vertex;
            int getWeight = getNode.weight;

            if (getWeight > maxNode.weight) maxNode = getNode;

            for (Node node : graph.get(getVertex)) {
                if (!visited[node.vertex]) {
                    visited[node.vertex] = true;
                    queue.add(new Node(node.vertex, getWeight + node.weight));
                }
            }
        }
    }

}
