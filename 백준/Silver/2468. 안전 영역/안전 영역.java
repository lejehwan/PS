import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int[][] graph;
	static boolean[][] visited;
	static int size, safeCnt = 0;
	static int[] addRow = { 1, -1, 0, 0 };
	static int[] addCol = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		size = Integer.parseInt(br.readLine());
		graph = new int[size][size];
		int max = 0;
		for (int i = 0; i < size; i++) {
			String[] inputLine = br.readLine().split(" ");
			for (int j = 0; j < size; j++) {
				graph[i][j] = Integer.parseInt(inputLine[j]);
				max = Math.max(max, graph[i][j]);
			}
		}
		for (int i = 0; i < max; i++) {
			visited = new boolean[size][size];
			int cnt = 0;
			for (int j = 0; j < size; j++) {
				for (int k = 0; k < size; k++) {
					if (graph[j][k] > i && !visited[j][k]) {
						bfs(j, k, i);
						cnt++;
					}
				}
			}
			safeCnt = Math.max(safeCnt, cnt);
		}
		answer();
		
	}
	
	private static void answer() {
		 System.out.println(safeCnt);
	}
	
	private static void bfs(int x, int y, int limit) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {x,y});
		visited[x][y] = true;
		while (!queue.isEmpty()) {
			int getX = queue.peek()[0];
			int getY = queue.peek()[1];
			queue.poll();
			for (int i = 0; i < addCol.length; i++) {
				int newX = getX + addRow[i];
				int newY = getY + addCol[i];
				if (newX >= 0 && newX < size && newY >= 0 && newY < size) {
					if (!visited[newX][newY] && graph[newX][newY] > limit) {
						queue.add(new int[] {newX, newY});
						visited[newX][newY] = true;
					}
				}
			}
		}
	}

}
