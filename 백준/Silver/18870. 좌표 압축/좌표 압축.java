import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// 리스트 2개로도 할 수는 있지만 비효율적 
// 키와 값을 가지는 map 을 사용하므로써 효율적으로 풀이

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] plane = new int[n];
		int[] temp = new int[n];
		for (int i = 0; i < plane.length; i++) {
			plane[i] = sc.nextInt();
		}
		temp = plane.clone();// 깊은 복사
		Arrays.sort(temp);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();// 좌표값, 인덱스
		int index = 0;
		for (int i : temp) {
			if (!map.containsKey(i)) {// 이미 존재하는 값이 아니라면
				map.put(i, index++);// 해당 키의 값(인덱스)을 증가
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i : plane) {
			sb.append(map.get(i)).append(" ");// 좌표값을 통한 인덱스 가져오기	
		}
		System.out.println(sb.toString());
		sc.close();
	}
}
