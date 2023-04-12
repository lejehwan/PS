class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while (n >= a) {
            int temp = 0;
            temp = ((n / a) * b);
            answer += temp;
            if (n % a == 0) n = temp;
            else if (n % a != 0) n = (temp + (n % a));
        }
        return answer;
    }
}