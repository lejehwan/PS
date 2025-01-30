import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            parent = new int[n];
            for (int i = 0; i <n; i++) {
                parent[i] = i;
            }
            int answer = 0;
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                if (find(v1) == find(v2)) {
                    answer = i + 1;
                    break;
                }
                union(v1, v2);
            }
//            Arrays.stream(unf).forEach(System.out::print);
            System.out.println(answer);
        }
    }

    private static void union(int v1, int v2) {
        v1 = find(v1);
        v2 = find(v2);
        if(v1 > v2) parent[v1] = v2;
        else parent[v2] = v1;
    }

    private static int find(int v) {
        if (v == parent[v]) return v;
        return parent[v] = find(parent[v]);
    }

}
