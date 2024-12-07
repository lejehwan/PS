import java.io.*;
import java.util.*;

public class Main {

    static int[][] dist;
    static int n, INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());
            dist = new int[n + 1][n + 1];
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (i == j) dist[i][j] = 0;
                    else dist[i][j] = INF;
                }
            }
            for (int i = 0; i < m; i++) {
                String[] data = br.readLine().split(" ");
                int fromV = Integer.parseInt(data[0]);
                int toV = Integer.parseInt(data[1]);
                int weight = Integer.parseInt(data[2]);
                dist[fromV][toV] = Math.min(dist[fromV][toV], weight);
            }
            floydWarshall();
            System.out.println(printAnswer());
        }
    }

    private static StringBuilder printAnswer() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (dist[i][j] == INF) sb.append("0").append(" ");
                else sb.append(dist[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb;
    }

    private static void floydWarshall() {
        for (int via = 1; via < n + 1; via++) {
            for (int from = 1; from < n + 1; from++) {
                for (int to = 1; to < n + 1; to++) {
                    if (dist[from][via] != INF && dist[via][to] != INF) {
                        dist[from][to] = Math.min(dist[from][to], dist[from][via] + dist[via][to]);
                    }
                }
            }
        }
    }

}
