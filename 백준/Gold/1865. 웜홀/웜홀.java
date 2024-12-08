import java.io.*;
import java.util.*;

public class Main {

    static int[][] dist;
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
                dist = new int[N + 1][N + 1];
                for (int j = 0; j < N + 1; j++) {
                    for (int k = 0; k < N + 1; k++) {
                        if (j == k) dist[j][k] = 0;
                        else dist[j][k] = INF;
                    }
                }
                for (int j = 0; j < M; j++) {
                    String[] input = br.readLine().split(" ");
                    int S = Integer.parseInt(input[0]);
                    int E = Integer.parseInt(input[1]);
                    int T = Integer.parseInt(input[2]);
                    dist[S][E] = Math.min(dist[S][E], T);
                    dist[E][S] = Math.min(dist[E][S], T);
                }
                for (int j = 0; j < W; j++) {
                    String[] input = br.readLine().split(" ");
                    int S = Integer.parseInt(input[0]);
                    int E = Integer.parseInt(input[1]);
                    int T = Integer.parseInt(input[2]);
                    dist[S][E] = Math.min(dist[S][E], -T);
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
        for (int via = 1; via < N + 1; via++) {
            for (int from = 1; from < N + 1; from++) {
                for (int to = 1; to < N + 1; to++) {
                    if (dist[from][via] != INF && dist[via][to] != INF) {
                        dist[from][to] = Math.min(dist[from][to], dist[from][via] + dist[via][to]);
                    }
                }
            }
        }

        for (int i = 1; i < N + 1; i++) {
            if (dist[i][i] < 0) {
                return true;
            }
        }
        return false;
    }

}
