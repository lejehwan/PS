import java.util.ArrayList;
class Solution {
    public int solution(String t, String p) {
         int answer = 0;
        String[] str = t.split("");
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < str.length - p.length() + 1; i++) {
            String input = "";
            for (int j = i; j < i + p.length(); j++) {
                input += str[j];
            }
            list.add(input);
        }

        for (String s : list) {
            if (Long.parseLong(s) <= Long.parseLong(p)) answer ++;
        }
        return answer;
    }
}