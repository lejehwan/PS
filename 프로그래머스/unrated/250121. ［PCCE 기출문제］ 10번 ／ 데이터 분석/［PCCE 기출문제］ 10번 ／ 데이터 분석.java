import java.util.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        List<int[]> candidateSortList = categoryProcess(data, ext, val_ext);
        sorting(candidateSortList, sort_by);
        answer = convertListToArray(candidateSortList);
        return answer;
    }
    
    private static int[][] convertListToArray(List<int[]> candidateSortList) {
        int [][]array = new int[candidateSortList.size()][4];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = candidateSortList.get(i)[j];
            }
        }
        return array;
    }

    private static void sorting(List<int[]> idxList, String sort_by) {
        idxList.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return switch (sort_by) {
                    case "code" -> o1[0] - o2[0];
                    case "date" -> o1[1] - o2[1];
                    case "maximum" -> o1[2] - o2[2];
                    case "remain" -> o1[3] - o2[3];
                    default -> 0;
                };
            }
        });
    }

    private static List<int[]> categoryProcess(int[][] data, String ext, int val_ext) {
        int idx = -1;
        switch (ext) {
            case "code": idx = 0; break;
            case "date": idx = 1; break;
            case "maximum": idx = 2; break;
            case "remain": idx = 3; break;
            default: break;
        }

        List<int[]> candidateSortList = new ArrayList<>();
        for (int[] dataVal : data) {
            if (dataVal[idx] < val_ext) candidateSortList.add(dataVal);
        }
        return candidateSortList;
    }
}