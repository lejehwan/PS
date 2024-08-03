import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int PAPER_SIZE = 10;
    private static final int SQUARE_SIZE = 100;

    private static List<int[]> square = new ArrayList<>();
    private static boolean[][] visited = new boolean[SQUARE_SIZE][SQUARE_SIZE];

    public static void main(String[] args) throws IOException {
        init();
        getSquareArea();
        printResult();
    }

    private static void printResult() {
        int cnt = 0;
        for (int i = 0; i < SQUARE_SIZE; i++) {
            for (int j = 0; j < SQUARE_SIZE; j++) {
                if (visited[i][j]) cnt ++;
            }
        }
        System.out.println(cnt);
    }

    private static void getSquareArea() {
        for (int[] point : square) {
            int getX = point[0];
            int getY = point[1];
            for (int i = getX; i < getX + PAPER_SIZE; i++) {
                for (int j = getY; j < getY + PAPER_SIZE; j++) {
                    visited[i][j] = true;
                }
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int paperSize = Integer.parseInt(br.readLine());
        for (int i = 0; i < paperSize; i++) {
            String[] line = br.readLine().split(" ");
            square.add(new int[] {Integer.parseInt(line[0]), Integer.parseInt(line[1])});
        }
    }
}