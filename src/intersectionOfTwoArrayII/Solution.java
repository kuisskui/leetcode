package intersectionOfTwoArrayII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    final private String url = "https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/674/";
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> resultList = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++){
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }

        for (int i = 0; i < nums2.length; i++){
            if (map.getOrDefault(nums2[i], 0) != 0){
                resultList.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }

        int[] intersection = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++){
            intersection[i] = resultList.get(i);
        }

        return intersection;
    }

    public int[] bestRuntimeSolution(int[] nums1, int[] nums2) {
        int [] map=new int[1001];
        for(int e:nums1){
            map[e]++;
        }
        int []result=new int[1001];
        int count=0;
        for(int e:nums2){
            if(map[e]>0){
                result[count++]=e;
                map[e]--;
            }
        }
        return Arrays.copyOfRange(result,0,count);

    }

    public int[] bestMemorySolution(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int i = 0, j = 0;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        ArrayList<Integer> integers = new ArrayList<>();
        while (i < length1 && j < length2) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                integers.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] result = new int[integers.size()];
        for (int k = 0; k < integers.size(); k++) {
            result[k] = integers.get(k);
        }
        return result;
    }
}
