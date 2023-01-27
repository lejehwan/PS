import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] visited = new int[100001];
	static int start, dest = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		dest = Integer.parseInt(st.nextToken());
		if(start == dest) System.out.println(0);
		else bfs(start);
	}
	
	private static void bfs(int vertex) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(vertex);
		visited[vertex] = 1;
		while (!queue.isEmpty()) {
			int getVertex = queue.poll();
			for (int i = 0; i < 3; i++) {
				int step = 0;
				if(i == 0) step = getVertex - 1;
				else if(i == 1) step = getVertex + 1;
				else step = getVertex * 2;
				
				if (step >= 0 && step < visited.length && visited[step] == 0) {
					queue.add(step);
					visited[step] = visited[getVertex] + 1;
				}
				if (step == dest) {
					System.out.println(visited[getVertex]);
					return;
				}
			}
		}
	}

}
