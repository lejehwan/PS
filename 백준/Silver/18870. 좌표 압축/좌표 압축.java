import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


class Main {

    static int[] originData;
    static int[] revisedData;
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        init();
        String answer = solve();
        System.out.println(answer);
    }

    private static String solve() {
        Arrays.sort(revisedData);

        for (int data : revisedData) {
            map.computeIfAbsent(data, k -> map.size());
        }

        return Arrays.stream(originData)
                .mapToObj(data -> String.valueOf(map.get(data)))
                .collect(Collectors.joining(" "));
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        originData = new int[N];
        revisedData = new int[N];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            int data = Integer.parseInt(input[i]);
            originData[i] = revisedData[i] = data;
        }
        br.close();
    }


}