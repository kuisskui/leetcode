package implementStrStr;

public class Solution {
    final private String url = "https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/885/";

    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }

        char[] haystackChars = haystack.toCharArray();
        char[] needleChars = needle.toCharArray();
        boolean chat = false;

        for (int i = 0; i < haystackChars.length; i++){
            for (int j = 0; j < needleChars.length; j++){
                chat = true;
                if (i+j >= haystackChars.length){
                    chat = false;
                    break;
                }
                if (haystackChars[i+j] != needleChars[j]){
                    chat = false;
                    break;
                }
            }
            if (chat){
                return i;
            }
        }
        return -1;
    }

    public int bestMemorySolution(String haystack, String needle) {
        if(needle.isEmpty()) return 0;
        if(needle.length()>haystack.length()) return -1;
        for(int i=0;i<=haystack.length()-needle.length();i++)
        {
            if(haystack.substring(i,i+needle.length()).equals(needle))
            {
                return i;
            }
        }
        return -1;
    }
}