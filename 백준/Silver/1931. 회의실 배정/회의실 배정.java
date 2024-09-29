import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {

    static int[][] meetings;

    public static void main(String[] args) throws IOException {
        init();
        sortMeetings();
        int answer = greedy();
        System.out.println(answer);
    }

    private static int greedy() {
        int cnt = 1;
        int lastMeetingIdx = 0;
        for (int i = 1; i < meetings.length; i++) {
            if (meetings[lastMeetingIdx][1] <= meetings[i][0]) {
                cnt ++;
                lastMeetingIdx = i;
            }
        }
        return cnt;
    }

    private static void sortMeetings() {
        Arrays.sort(meetings, (start, end) ->
                start[1] == end[1] ? Integer.compare(start[0], end[0]) : Integer.compare(start[1], end[1]));
    }

    private static void init() throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            meetings = new int[N][2];
            for (int i = 0; i < N; i++) {
                String[] data = br.readLine().split(" ");
                meetings[i][0] = Integer.parseInt(data[0]);
                meetings[i][1] = Integer.parseInt(data[1]);
            }
        }
    }

}