import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static boolean[][] visited;
	static int[][] map;
	static int cnt = 0;
	static int[] addRow = { -1, 1, 0, 0 };
	static int[] addCol = { 0, 0, -1, 1 };
	static ArrayList<Integer> list = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < map.length; i++) {
			String[] temp = br.readLine().split("");
			for (int j = 0; j < map.length; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}
		visited = new boolean[n][n];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] == 1 && visited[i][j] == false) {
					cnt = 1;
					dfs(i,j);
					//bfs(ni,nj);
					list.add(cnt);
				}
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for (Integer answer : list) {
			System.out.println(answer);
		}
	}
	
	public static int dfs(int i, int j) {
		visited[i][j] = true;
		for (int k = 0; k < 4; k++) {
			int ni = i + addRow[k];
			int nj = j + addCol[k];
			if (ni >= 0 && ni < map.length && nj >= 0 && nj < map.length) {
				if (map[ni][nj] == 1 && visited[ni][nj] == false) {
					cnt++;
					dfs(ni,nj);
				}
			}
		}
		return cnt;
	}
	
	public static int bfs(int i, int j) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {i,j});
		visited[i][j] = true;
		while (!queue.isEmpty()) {
			int a = queue.poll()[0];
			int b = queue.poll()[1];
			for (int k = 0; k < 4; k++) {
				int ni = a + addRow[k];
				int nj = b + addCol[k];
				if (ni >= 0 && ni < map.length && nj >= 0 && nj < map.length) {
					if (map[ni][nj] == 1 && visited[ni][nj]) {
						queue.add(new int[] {i,j});
						visited[ni][nj] = true;
						cnt++;
					}
				}
			}
		}
		return cnt;
	}
}