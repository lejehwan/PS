class Solution {
    public long solution(int n) {
        long[] val = new long[n + 1];
        val[1] = 1;
        if (n != 1) val[2] = 2;
        for (int i = 3; i < val.length; i++) {
            val[i] = (val[i - 1] + val[i - 2]) % 1234567;
        }
        return val[n] % 1234567;
    }
    
}