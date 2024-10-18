package validAnagram;

import java.util.concurrent.atomic.AtomicInteger;

public class Solution {
    final private String url = "https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/882/";

    public boolean isAnagram(String s, String t) {
        int[] countsS = new int[26];
        int[] countsT = new int[26];
        for (int i = 0; i < s.length(); i++) {
            countsS[s.charAt(i) - 97]++;
            countsT[t.charAt(i) - 97]++;
        }

        if (countsT == countsS && s.length() == t.length()) {
            return true;
        }
        return false;
    }

    public boolean bestRuntimeSolution(String s, String t) {
        int[] count = new int[26];

        for (char x : s.toCharArray()) {
            count[x - 'a']++;
        }

        for (char x : t.toCharArray()) {
            count[x - 'a']--;
        }

        for (int val : count) {
            if (val != 0) {
                return false;
            }
        }

        return true;
    }

    public boolean bestMemorySolution(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] char_count= new int[26];
        for(int i=0;i<s.length();i++){
            char_count[s.charAt(i)-'a']++;
            char_count[t.charAt(i)-'a']--;
        }
        for(int count:char_count){
            if(count!=0){
                return false;
            }
        }
        return true;
    }
}
