class Solution {
    public static int[] addRow = {0, 1, -1, 0};
    public static int[] addCol = {1, 0, 0, -1};
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        for (int i = 0; i < addRow.length; i++) {
            int newXVertex = h + addRow[i];
            int newYVertex = w + addCol[i];
            if (checkRange(newXVertex, newYVertex, board.length) && board[h][w].equals(board[newXVertex][newYVertex])){
                answer ++;
            }
        }
        return answer;
    }

    public static boolean checkRange(int xVertex, int yVertex, int maxLength) {
        return 0 <= xVertex && xVertex < maxLength && 0 <= yVertex && yVertex < maxLength;
    }
}