import java.util.Scanner;

// i(몇번줄 탐색 )
// ↓
//   0 1 2 3 4 5  6  7 => dp(수용 가능한 무게)
// 1 0 0 0 0 0 0  13 13         
// 2 0 0 0 0 8 8  13 13        
// 3 0 0 0 6 8 8  13 14         
// 4 0 0 0 6 8 12 13 14
// W의 i번째 > K	=> f(i-1,k)
// 0 < i and W의 i번째 < K		=> max( f(i-1,K-W의 i번째) + V의 i번째 , f(i-1,K) )
// (앞전에 구한 가치)와 (최대 무게에서 자신의 무게를 뺏을 경우 남은 무게로 담을수 있는 가치)와 더해 더 큰 값을 저장

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] w = new int[n + 1];
		int[] v = new int[n + 1];
		for (int i = 1; i < v.length; i++) {
			w[i] = sc.nextInt();
			v[i] = sc.nextInt();
		}
		int[] dp = new int[k + 1];
		for (int i = 1; i < v.length; i++) {
			// k 부터 탐색하여 담을 수 있는 무게 한계치가 넘지 않을 때 까지 반복
			for (int j = k; j - w[i] >= 0; j--) {
				dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
			}
		}
		System.out.println(dp[k]);
		sc.close();
	}
}
