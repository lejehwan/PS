import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static List<ArrayList<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        init();
        bfs();
        printAnswer();
    }

    private static void printAnswer() {
        for (int i = 2; i < parent.length; i++) {
            System.out.println(parent[i]);
        }
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        while(!queue.isEmpty()) {
            int getVertex = queue.poll();
            for (int i = 0; i < list.get(getVertex).size(); i++) {
                int newVertex = list.get(getVertex).get(i);
                if (!visited[newVertex]) {
                    visited[newVertex] = true;
                    queue.add(newVertex);
                    parent[newVertex] = getVertex;
                }
            }
        }
    }

    private static void init() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N + 1; i++) {
                list.add(new ArrayList<>());
            }
            visited = new boolean[N + 1];
            parent = new int[N + 1];
            for (int i = 0; i < N - 1; i++) {
                String[] input = br.readLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                list.get(start).add(end);
                list.get(end).add(start);
            }
        }
    }

}
