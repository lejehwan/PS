import java.io.*;
import java.util.*;

public class Main {

    static int[][] dist;
    static int V, INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] data = br.readLine().split(" ");
            V = Integer.parseInt(data[0]);
            int E = Integer.parseInt(data[1]);
            dist = new int[V + 1][V + 1];
            for (int i = 1; i < V + 1; i++) {
                for (int j = 1; j < V + 1; j++) {
                    if (i == j) dist[i][j] = 0;
                    else dist[i][j] = INF;
                }
            }
            for (int i = 0; i < E; i++) {
                String[] input = br.readLine().split(" ");
                int fromV = Integer.parseInt(input[0]);
                int toV = Integer.parseInt(input[1]);
                int weight = Integer.parseInt(input[2]);
                dist[fromV][toV] = Math.min(dist[fromV][toV], weight);
            }

            floydWarshall();
            int answer = findShortestCycle();
            System.out.println(answer != INF ? answer : -1);
        }
    }

    private static int findShortestCycle() {
        int answer = INF;
        for (int i = 1; i < V + 1; i++) {
            for (int j = 1; j < V + 1; j++) {
                if (dist[i][j] != INF && dist[i][j] != 0 && dist[j][i] != INF && dist[j][i] != 0) {
                    answer = Math.min(answer, dist[i][j] + dist[j][i]);
                }
            }
        }
        return answer;
    }

    private static void floydWarshall() {
        for (int via = 1; via < V + 1; via++) {
            for (int from = 1; from < V + 1; from++) {
                for (int to = 1; to < V + 1; to++) {
                    if (dist[from][via] != INF && dist[via][to] != INF) {
                        dist[from][to] = Math.min(dist[from][to], dist[from][via] + dist[via][to]);
                    }
                }
            }
        }
    }

}
