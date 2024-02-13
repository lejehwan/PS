import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int val : nums) { 
            set.add(val);
        }
        return set.size() > (nums.length / 2) ? nums.length / 2 : set.size();
    }
}