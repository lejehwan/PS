class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = 2; i <= n; i++){
            answer += i % 2 == 0 ? i : 0;
        }
        return answer;
    }
}