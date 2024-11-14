import java.util.Scanner;

//   A C A Y K P
// C 0 1 1 1 1 1
// A 1 1 2 2 2 2 
// P 1 1 2 2 2 3
// C 1 2 2 2 2 3
// A 1 2 3 3 3 3
// K 1 2 3 3 4 4
// 0,1 에서는 C 와 A,C 의 공통 부분이 1이고
// 1,2 에서는 C,A 와 A,C,A 의 공통 부분이 2이다
// 4,2 에서는 C,A,P,C,A 와 A,C,A 의 공통 부분이 3이다
// 정리하면 
// x의 값과 y의 값이 같다면 =>
// LCS(x,y) = LCS(x-1,y-1) + 1
// x의 값과 y의 값디 다르다면 =>
// LCS(x,y) = max( LCS(x-1,y), LCS(x,y-1) )

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] input1 = sc.next().split("");
		String[] input2 = sc.next().split("");
		int[][] dp = new int[input1.length + 1][input2.length + 1];
		for (int i = 1; i <= input1.length; i++) {
			for (int j = 1; j <= input2.length; j++) {
				if (input1[i - 1].equals(input2[j - 1])) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		System.out.println(dp[input1.length][input2.length]);
		sc.close();
	}
}
