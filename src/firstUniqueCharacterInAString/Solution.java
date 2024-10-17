package firstUniqueCharacterInAString;

import java.util.HashMap;
import java.util.stream.IntStream;

public class Solution {
    final private String url = "https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/881/";

    private HashMap<Character, Integer> map = new HashMap<>();
    public int firstUniqChar(String s) {
        s.chars().forEach(value -> {
            Character char_ = Character.toChars(value)[0];
            if (map.containsKey(char_)) {
                map.put(char_, map.get(char_) + 1);
            }
            else{
                map.put(char_, 1);
            }
        });

        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    public int bestRuntimeSolution(String s) {
        int[] count = new int[26];
        char[] a = s.toCharArray();
        for (int i = 0; i < a.length; i++) {
            ++count[a[i] - 97];
        }
        for (int i = 0; i < a.length; i++) {
            if(count[a[i]-97] == 1){
                return i;
            }
        }
        return -1;
    }

    public int bestMemorySolution  (String s) {
        int[] freq = new int[26];

        for (char c : s.toCharArray())
            freq[(int) (c - 'a')]++;

        for (int i=0; i < s.length(); i++)
            if (freq[(int) (s.charAt(i) - 'a')] == 1)
                return i;

        return -1;
    }
}