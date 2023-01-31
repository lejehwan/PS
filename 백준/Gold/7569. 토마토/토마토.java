import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int x, y, z, answer = 0;
	static int[][][] graph;
	static Queue<int[]> queue = new LinkedList<int[]>();
	static int[] addZ = {-1, 1, 0, 0, 0, 0};
	static int[] addX = {0, 0, -1, 1, 0, 0};
	static int[] addY = {0, 0, 0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		z = Integer.parseInt(st.nextToken());
		graph = new int[z][y][x];
		int temp = 0;
		for (int i = 0; i < y * z; i++) {
			if(i != 0 && i % y == 0) temp ++;
			String[] inputLine = br.readLine().split(" ");
			for (int j = 0; j < x; j++) {
				graph[temp][i % y][j] = Integer.parseInt(inputLine[j]);
				if(graph[temp][i % y][j] == 1) queue.add(new int[] {temp, i % y, j});
			}
		}
//		print();
		bfs();
		boolean check = checkTomato();
		answer(check);
	}
	
	private static void answer(boolean check) {
		if (!check) System.out.println(-1);
		else if (answer == 0) System.out.println(0);
		else System.out.println(answer - 1);
	}
	
	private static boolean checkTomato() {
		int temp = 0;
		for (int i = 0; i < y * z; i++) {
			if(i != 0 && i % y == 0) temp ++;
			for (int j = 0; j < x; j++) {
				if(graph[temp][i % y][j] == 0) return false;
			}
		}
		return true;
	}
	
	private static void bfs() {
		while (!queue.isEmpty()) {
			int getZVertex = queue.peek()[0];
			int getXVertex = queue.peek()[1];
			int getYVertex = queue.peek()[2];
			queue.poll();
			for (int i = 0; i < addZ.length; i++) {
				int newZVertex = getZVertex + addZ[i];
				int newXVertex = getXVertex + addX[i];
				int newYVertex = getYVertex + addY[i];
				if (newZVertex >= 0 && newZVertex < z && newXVertex >= 0 && newXVertex < y && newYVertex >= 0 && newYVertex < x) {
					if (graph[newZVertex][newXVertex][newYVertex] == 0) {
						queue.add(new int[] {newZVertex, newXVertex, newYVertex});
						graph[newZVertex][newXVertex][newYVertex] = graph[getZVertex][getXVertex][getYVertex] + 1;
						answer = Math.max(answer, graph[newZVertex][newXVertex][newYVertex]);
					}
				}
			}
		}
	}
	
	private static void print() {
		for (int i = 0; i < z; i++) {
			for (int j = 0; j < y; j++) {
				for (int k = 0; k < x; k++) {
					System.out.print(graph[i][j][k] + " ");
				}
				System.out.println();
			}
		}
	}

}
