import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] graph;
    static int[] move = new int[2];
    static boolean[] visited;
    static int height, start, dest = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        dest = Integer.parseInt(st.nextToken());
        move[0] = Integer.parseInt(st.nextToken());
        int inputValue = Integer.parseInt(st.nextToken());
        move[1] = inputValue - inputValue * 2;
        graph = new int[height + 1];
        visited = new boolean[height + 1];

        bfs(start);
        outPut();
    }

    private static void outPut(){
        if (start == dest) System.out.println(0);
        else if (graph[dest] == 0) System.out.println("use the stairs");
        else System.out.println(graph[dest]);
    }

    private static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()){
            int getVertex = queue.poll();
            for (int i = 0; i < move.length; i++) {
                int newVertex = getVertex + move[i];
                if (newVertex > 0 && newVertex <= height && !visited[newVertex]){
                    queue.add(newVertex);
                    visited[newVertex] = true;
                    graph[newVertex] = graph[getVertex] + 1;
                }
            }
        }
    }
}
