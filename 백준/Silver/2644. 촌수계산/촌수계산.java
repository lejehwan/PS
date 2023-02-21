import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] visited;
    static int peopleA, peopleB, seq = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int peoples = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        peopleA = Integer.parseInt(st.nextToken());
        peopleB = Integer.parseInt(st.nextToken());
        int total = Integer.parseInt(br.readLine());

        for (int i = 0; i < peoples + 1; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new int[peoples + 1];
        for (int i = 0; i < total; i++) {
            st = new StringTokenizer(br.readLine());
            int toVertex = Integer.parseInt(st.nextToken());
            int fromVertex = Integer.parseInt(st.nextToken());
            graph.get(toVertex).add(fromVertex);
            graph.get(fromVertex).add(toVertex);
        }
        bfs(peopleA);
//        printGraph();
//        printVisited();
        output();
    }

    private static void printVisited(){
        for (int visit : visited) {
            System.out.println(visit);
        }
    }

    private static void printGraph(){
        for (ArrayList<Integer> getVertex : graph) {
            for (Integer vertex : getVertex) {
                System.out.print(vertex + " ");
            }
            System.out.println();
        }
    }

    private static void output(){
        if (visited[peopleB] == 0) System.out.println(-1);
        else System.out.println(visited[peopleB]);
    }

    private static void bfs(int startVertex){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);
        visited[startVertex] = seq++;
        while (!queue.isEmpty()){
            int getVertex = queue.poll();
            for (int i = 0; i < graph.get(getVertex).size(); i++) {
                int newVertex = graph.get(getVertex).get(i);
                if (visited[newVertex] == 0){
                    queue.add(newVertex);
                    visited[newVertex] = visited[getVertex] + 1;
                }
            }
        }
    }
}