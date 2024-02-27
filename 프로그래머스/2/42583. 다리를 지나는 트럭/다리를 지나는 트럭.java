import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        int nowWeights = 0;
        for (int tw : truck_weights) {
            while (true) {
                if (queue.isEmpty()) {// 다리를 지나는 트럭이 없는 경우
                    queue.offer(tw);
                    nowWeights += tw;
                    answer ++;
                    break;
                } else if (queue.size() == bridge_length) {// 다리를 지나는 트럭의 수가 최대인 경우
                    nowWeights -= queue.poll();
                } else {
                    if (nowWeights + tw <= weight) {// 다리를 지나는 트럭들의 무게와 다음 트럭의 무게 합이 여유가 있는 경우
                        queue.offer(tw);
                        nowWeights += tw;
                        answer ++;
                        break;
                    } else {// 트럭이 더 올라갈 수 없고, 지나가는 중인 경우
                        queue.add(0);
                        answer ++;
                    }
                }
            }
        }
        
        return answer + bridge_length;// 마지막 트럭은 다리 길이 만큼 추가
    }
}