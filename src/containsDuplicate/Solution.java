package containsDuplicate;

import java.util.HashSet;

public class Solution {

    final private String url = "https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/578/";

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            if (seen.contains(nums[i])){
                return true;
            }
            seen.add(nums[i]);
        }
        return false;
    }
}
