package removeDuplicateFromSortedArray;

public class Solution {

    final private static String url = "https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/727/";

    public int removeDuplicatesFromSortedArray(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++){
            if (i == 0){
                k += 1;
                continue;
            }

            if (nums[i] != nums[i-1]){
                nums[k] = nums[i];
                k += 1;
            }
        }
        return k;
    }
}
