import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Main {

    static final String ENTER = "\n";

    public static void main(String[] args) throws IOException {
        String answer = minHeap();
        printAnswer(answer);
    }

    private static void printAnswer(String answer) {
        System.out.println(answer);
    }

    private static String minHeap() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int data = Integer.parseInt(br.readLine());
            if (data == 0) {
                if (pq.isEmpty()) sb.append(0).append(ENTER);
                else sb.append(pq.poll()).append(ENTER);
            } else {
                pq.add(data); 
            }
        }
        return sb.toString();
    }

}