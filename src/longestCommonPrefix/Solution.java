package longestCommonPrefix;

import java.util.Optional;

public class Solution {
    final private String url = "https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/887/";

    public String longestCommonPrefix(String[] strs) {
        char[] base = strs[0].toCharArray();

        if (base.length == 0) {
            return "";
        }

        char[] result = new char[base.length];
        boolean flag = false;

        int i = 0;
        while (i < base.length){
            char current = base[i];

            for (String str: strs){
                if (str.length() == i){
                    flag = true;
                    break;
                }
                if (current != str.charAt(i)){
                    flag = true;
                    break;
                }
            }

            if (flag){
                break;
            }
            result[i] = current;
            i++;
        }

        if (i == 0){
            return "";
        }

        return String.valueOf(result, 0, i);
    }
}
