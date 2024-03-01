import java.util.*;
import java.util.stream.*;
class Solution {
    public String solution(int[] numbers) {
        ArrayList<String> list = new ArrayList<>();
        // list에 삽입
        for(int num : numbers) {
            list.add(String.valueOf(num));
        }
        // 정렬
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return ((o2+o1).compareTo(o1+o2));
            }
        });
        if (list.get(0).equals("0")) return "0";
        // 후 처리(문자열 더해주기)
        return list.stream().collect(Collectors.joining());
    }
}