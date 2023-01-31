import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static int[][][] map;
	private static int[] addRow = { 1, -1, 0, 0, 0, 0 };
	private static int[] addCol = { 0, 0, 1, -1, 0, 0 };
	private static int[] addFac = { 0, 0, 0, 0, 1, -1 };
	private static int n, m, h;
	private static int max = 0;

	private static Queue<int[]> queue = new LinkedList<int[]>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		m = Integer.parseInt(stz.nextToken());
		n = Integer.parseInt(stz.nextToken());
		h = Integer.parseInt(stz.nextToken());
		map = new int[h][n][m];
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				stz = new StringTokenizer(br.readLine());
				for (int j2 = 0; j2 < m; j2++) {
					int a = Integer.parseInt(stz.nextToken());
					map[i][j][j2] = a;
					if (a == 1) {
						queue.add(new int[] { i, j, j2 });
					}
				}
			}
		}

		bfs(queue);

		if (!check()) {
			System.out.println(-1);
		} else if (max == 0) {
			System.out.println(0);
		} else {
			System.out.println(max - 1);
		}
	}

	public static void bfs(Queue<int[]> queue) {

		while (!queue.isEmpty()) {
			int c = queue.peek()[0];
			int a = queue.peek()[1];
			int b = queue.peek()[2];
			queue.poll();
			for (int i = 0; i < 6; i++) {
				int nz = c + addFac[i];
				int nx = a + addRow[i];
				int ny = b + addCol[i];

				if (nx >= 0 && ny >= 0 && nz >= 0 && nx < n && ny < m && nz < h) {
					if (map[nz][nx][ny] == 0) {
						map[nz][nx][ny] = map[c][a][b] + 1;
						queue.add(new int[] { nz, nx, ny });
						if (map[nz][nx][ny] > max) {
							max = map[nz][nx][ny];
						}
					}
				}
			}

		}
	}

	public static boolean check() {
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int j2 = 0; j2 < m; j2++) {
					if (map[i][j][j2] == 0) {
						return false;
					}
				}
			}
		}
		return true;
	}
}