package containsDuplicate;

import java.util.Arrays;
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

    public boolean bestRuntimeSolution(int[] nums) {
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1])
                return true;
            else if(nums[i]<nums[i-1]){
                int tempVal = nums[i];
                for(int j=i-2;j>=0;j--)
                {
                    if(nums[j]==tempVal)
                        return true;
                }
                nums[i]=nums[i-1];
                nums[i-1]=tempVal;

            }
        }
        return false;
    }

    public boolean bestMemorySolution(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1])
                return true;
        }
        return false;
    }
}
