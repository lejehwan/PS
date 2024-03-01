import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        // 정렬
        Arrays.sort(citations);
        // 인용횟수 >= 논문의 수 인 값 찾기
        for (int i = 0; i < citations.length; i ++) {
            int h = citations.length - i;
            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }
        return answer;
    }
}