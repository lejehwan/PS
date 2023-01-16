import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	static int[] visited;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int seq;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
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
		for (int i = 0; i < graph.size(); i++) {
			Collections.sort(graph.get(i));
		}
//		for (int i = 1; i < graph.size(); i++) {
//			for (int j = 0; j < graph.get(i).size(); j++) {
//				System.out.print(graph.get(i).get(j) + " ");
//			}
//			System.out.println();
//	}
		seq = 1;
		visited = new int[vertex + 1];
		dfs(startVertex);
		for (int i = 1; i < visited.length; i++) {
			sb.append(visited[i] + "\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void dfs(int vertex) {
		visited[vertex] = seq;
		for (int i = 0; i < graph.get(vertex).size(); i++) {
			int newVertex = graph.get(vertex).get(i);
			if (visited[newVertex] == 0) {
				seq ++;
				dfs(newVertex);
			}
		}
	}
	
}

