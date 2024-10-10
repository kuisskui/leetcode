package reverseString;

public class Solution {
    final private String url = "https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/879/";

    public void reverseString(char[] s) {
        int h = 0;
        int t = s.length - 1 ;
        while (h <= t){
            char temp = s[h];
            s[h] = s[t];
            s[t] = temp;
            h++;
            t--;
        }
    }

    public void bestMemorySolution(char[] s) {
        char tmp;
        int length = s.length;
        for (int i = 0; i < length / 2; i++) {
            int rightIndex = (length - i) - 1;
            tmp = s[i];
            s[i] = s[rightIndex];
            s[rightIndex] = tmp;
        }
    }
}
