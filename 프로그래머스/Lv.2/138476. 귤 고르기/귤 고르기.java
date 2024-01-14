import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        // 귤의 크기에 따른 빈도수 카운팅
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : tangerine) {
            map.merge(val, 1, Integer::sum);
        }

        // 내림차순 정렬
        List<Integer> list = new ArrayList<>(map.values());
        list.sort(Collections.reverseOrder());

        // k 크기에 따른 분기처리
        for (Integer val : list) {
            if (k <= 0) return answer;
            k -= val;
            answer ++;
        }
        return answer;
    }
}