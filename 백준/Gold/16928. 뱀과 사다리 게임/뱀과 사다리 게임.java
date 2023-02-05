import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] visited = new int[101];
    static int[] graph = new int[101];
    static int[] nextStep = {1,2,3,4,5,6};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ladder = Integer.parseInt(st.nextToken());
        int snake = Integer.parseInt(st.nextToken());
        for (int i = 1; i < graph.length; i++) {
            graph[i] = i;
        }
        for (int i = 0; i < ladder + snake; i++) {
            st = new StringTokenizer(br.readLine());
            graph[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        bfs(1);
        print();
    }

    private static void print(){
        System.out.println(visited[100]);
    }

    private static void bfs(int startVertex){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);
        visited[startVertex] = 0;
        while (!queue.isEmpty()){
            int getVertex = queue.poll();
            for (int i = 0; i < 6; i++) {
                int newVertex = getVertex + nextStep[i];
                if (newVertex > 1 && newVertex <= 100){
                    if (visited[graph[newVertex]] == 0){
                        queue.add(graph[newVertex]);
                        visited[graph[newVertex]] = visited[getVertex] + 1;
                    }
                    if (graph[newVertex] == 100) return;
                }
            }
        }
    }

}
