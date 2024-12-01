import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, answer;
    static int[] board;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());
            board = new int[N];
            nQueen(0);
            System.out.println(answer);
        }
    }

    private static void nQueen(int row) {
        if (row == N) {
            answer ++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isSafe(row, i)) {
                board[row] = i;
                nQueen(row + 1);
            }
        }
    }

    private static boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col || Math.abs(i - row) == Math.abs(board[i] - col)) return false;
        }
        return true;
    }


}
