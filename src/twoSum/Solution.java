package twoSum;

import java.util.HashMap;

public class Solution {
    final private String url = "https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/546/";

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    public int[] bestRuntimeSolution(int[] nums, int target) {
        int[] res = new int[2];
        for(int i=1, n=nums.length;i<n;i++) {
            for(int j=i;j<n;j++) {
                if(nums[j]+nums[j-i]==target) {
                    res[0]=j-i;
                    res[1]=j;
                    return res;
                }
            }
        }
        return res;
    }
}
