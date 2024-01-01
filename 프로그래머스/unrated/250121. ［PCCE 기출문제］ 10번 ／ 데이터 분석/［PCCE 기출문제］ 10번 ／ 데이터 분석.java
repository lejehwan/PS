import java.util.*;
// Ref #2
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        String[] arr = {"code", "date", "maximum", "remain"};
        List<String> columnList = Arrays.asList(arr);
        int extIdx = columnList.indexOf(ext);
        int sortIdx = columnList.indexOf(sort_by);

        return Arrays.stream(data)
                .filter(eachData -> eachData[extIdx] < val_ext)
                .sorted((o1, o2) -> o1[sortIdx] - o2[sortIdx])
                .toArray(int[][]::new);
    }

}