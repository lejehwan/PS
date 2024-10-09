import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Main {

    static int N, M;
    static int[] answer;
    static int[] values;
    static boolean[] visited = new boolean[10001];
    static StringBuilder sb = new StringBuilder();
    

    public static void main(String[] args) throws IOException {
        init();
        backTracking(0);
        System.out.println(sb);
    }

    private static void backTracking(int depth) {
        if (depth == M) {
            answerPrint();
            return;
        }

        for (int value : values) {
            if (!visited[value]) {
                answer[depth] = value;
                visited[value] = true;
                backTracking(depth + 1);
                visited[value] = false;
            }
        }
    }

    private static void answerPrint() {
        sb.append(
                IntStream.of(answer)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" "))
        ).append("\n");

    }

    private static void init() throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] data = br.readLine().split(" ");
            N = Integer.parseInt(data[0]);
            M = Integer.parseInt(data[1]);
            answer = new int[M];
            values = new int[N];
            String[] input = br.readLine().split(" ");
            for (int i = 0; i < values.length; i++) {
                values[i] = Integer.parseInt(input[i]);
            }
            Arrays.sort(values);
        }
    }

}