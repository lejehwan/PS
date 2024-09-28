import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main {

    static int[] line = new int[100001];
    static boolean[] visited = new boolean[line.length];
    static int origin, destination;

    public static void main(String[] args) throws IOException {
        init();
        bfs(origin);
        System.out.println(line[destination]);
    }

    private static void bfs(int vertex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(vertex);
        visited[vertex] = true;

        while (!queue.isEmpty()) {
            int getVertex = queue.poll();
            for (int newVertex: getSize(getVertex)) {
                if (isValidLineSize(newVertex) && !visited[newVertex]) {
                    queue.add(newVertex);
                    visited[newVertex] = true;
                    line[newVertex] = line[getVertex] + 1;
                }
            }
        }
    }

    private static boolean isValidLineSize(int newVertex) {
        return newVertex >= 0 && newVertex < line.length;
    }

    private static int[] getSize(int getVertex) {
        return new int[] {getVertex - 1, getVertex + 1, getVertex * 2};
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");
        origin = Integer.parseInt(data[0]);
        destination = Integer.parseInt(data[1]);
        br.close();
    }


}