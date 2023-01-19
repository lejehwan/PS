import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	static int[] visited;
	static int seq = 1;
	
	public static void main(String[] args) throws IOException {
		//setUp
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int vertex = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());
		int startVertex = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < vertex + 1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());
			int toVertex = Integer.parseInt(st.nextToken());
			int fromVertex = Integer.parseInt(st.nextToken());
			graph.get(toVertex).add(fromVertex);
			graph.get(fromVertex).add(toVertex);
		}
		sortArray();
		visited = new int[vertex + 1];
		bfs(startVertex);
		outPut();
	}
	
	private static void sortArray() {
		for (int i = 0; i < graph.size(); i++) {
			Collections.sort(graph.get(i));
			Collections.reverse(graph.get(i));
		}
	}
	
	private static void bfs(int vertex) {
		visited[vertex] = seq++;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(vertex);
		while (!queue.isEmpty()) {
			int getVertex = queue.poll();
			for (int i = 0; i < graph.get(getVertex).size(); i++) {
				int newVertex = graph.get(getVertex).get(i);
				if (visited[newVertex] == 0) {
					visited[newVertex] = seq++;
					queue.add(newVertex);
				}
			}
		}
	}
	
	private static void outPut() {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < visited.length; i++) {
			sb.append(visited[i] + "\n");
		}
		System.out.println(sb.toString());
	}
	
}