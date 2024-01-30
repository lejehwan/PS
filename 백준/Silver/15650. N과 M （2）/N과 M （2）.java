import java.util.Scanner;

public class Main {
	static int n,m, k;
	static int[] arr;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[m];
		visited = new boolean[n];
		dfs(0);
		sc.close();
	}
	
	public static void dfs(int v) {
		if (v == m) {	
			for (int answer : arr) {
				System.out.print(answer + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < n; i++) {
			if (k <= i) {
				if (!visited[i]) {
					visited[i] = true;
					arr[v] = i+1;
					k = i+1;
					dfs(v+1);
					visited[i] = false;
					k = 0;
				}
			}
			
		}
	}
}