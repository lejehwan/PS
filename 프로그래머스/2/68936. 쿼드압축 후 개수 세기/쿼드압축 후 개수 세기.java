class Solution {
    
    static int zeroCnt, oneCnt;
    
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        divide(arr, 0, 0, arr.length);
        answer[0] = zeroCnt;
        answer[1] = oneCnt;
        return answer;
    }
    
    public void divide(int[][] arr, int x, int y, int size) {
        if (canCompress(arr, x, y, size)) {
            if (arr[x][y] == 0) zeroCnt++;
            if (arr[x][y] == 1) oneCnt++;
            return;
        }
        divide(arr, x, y, size / 2);
        divide(arr, x, y + size / 2, size / 2);
        divide(arr, x + size / 2, y, size / 2);
        divide(arr, x + size / 2, y + size / 2, size / 2);
    }

    public boolean canCompress(int[][] arr, int x, int y, int size) {
        int firstVal = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (firstVal != arr[i][j]) return false;
            }
        }
        return true;
    }
}