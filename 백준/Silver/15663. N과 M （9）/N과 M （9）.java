import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

class Main {

    static int N, M;
    static int[] temp;
    static Set<String> answer = new LinkedHashSet<>();
    static int[] values;
    static boolean[] visited = new boolean[10001];

    public static void main(String[] args) throws IOException {
        init();
        backTracking(0);
        answer.forEach(System.out::println);
    }

    private static void backTracking(int depth) {
        if (depth == M) {
            answerPrint();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                temp[depth] = values[i];
                visited[i] = true;
                backTracking(depth + 1);
                visited[i] = false;
            }
        }
    }

    private static void answerPrint() {
        answer.add(
                Arrays.stream(temp)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" "))
        );
    }

    private static void init() throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] data = br.readLine().split(" ");
            N = Integer.parseInt(data[0]);
            M = Integer.parseInt(data[1]);
            temp = new int[M];
            values = new int[N];
            String[] input = br.readLine().split(" ");
            for (int i = 0; i < values.length; i++) {
                values[i] = Integer.parseInt(input[i]);
            }
            Arrays.sort(values);
        }
    }

}