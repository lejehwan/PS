import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static List<List<Integer>> list = new ArrayList<>();
    static int[] indegree;
    static int n;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            for (int i = 0; i < n + 1; i++) {
                list.add(new ArrayList<>());
            }
            indegree = new int[n + 1];
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int startV = Integer.parseInt(st.nextToken());
                int endV = Integer.parseInt(st.nextToken());
                list.get(startV).add(endV);
                indegree[endV] ++;
            }
            String answer = topLogicalSort().stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(" "));
            System.out.println(answer);
        }
    }

    private static List<Integer> topLogicalSort() {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0) queue.add(i);
        }

        while(!queue.isEmpty()) {
            int getV = queue.poll();
            answer.add(getV);
            
            for (Integer nxtV : list.get(getV)) {
                indegree[nxtV] --;
                if (indegree[nxtV] == 0) queue.add(nxtV);
            }
        }

        return answer;
    }

}
