import java.util.*;
class Solution {
    public int solution(int[] scovilles, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int scoville : scovilles) {
            pq.offer(scoville);
        }
         
        // 가장 낮은 스코빌 지수가 K 미만인 경우
        while (pq.peek() < K) {  
            int minVal = pq.poll();
            // 그 다음으로 낮은 스코빌 지수가 있는 경우
            if(!pq.isEmpty()) {
                pq.offer(minVal + (pq.poll() * 2));
                answer ++;
            } else {
                return -1;
            }            
        } 
        
        return answer;
    }
} 