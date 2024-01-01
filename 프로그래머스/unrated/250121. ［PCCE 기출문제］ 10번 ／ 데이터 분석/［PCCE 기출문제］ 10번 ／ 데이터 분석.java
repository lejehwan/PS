import java.util.*;
// Ref #1
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        String[] arr = {"code", "date", "maximum", "remain"};
        List<String> columnList = Arrays.asList(arr);
        int extIdx = columnList.indexOf(ext);
        int sortIdx = columnList.indexOf(sort_by);

        List<int[]> candidateSortList = categoryProcess(data, val_ext, extIdx);
        sorting(candidateSortList, sort_by, sortIdx);
        return candidateSortList.toArray(int[][]::new);
    }

    private static void sorting(List<int[]> idxList, String sort_by, int sortIdx) {
        idxList.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[sortIdx] - o2[sortIdx];
            }
        });
    }

    private static List<int[]> categoryProcess(int[][] data, int val_ext, int extIdx) {
        List<int[]> candidateSortList = new ArrayList<>();
        for (int[] dataVal : data) {
            if (dataVal[extIdx] < val_ext) candidateSortList.add(dataVal);
        }
        return candidateSortList;
    }
}