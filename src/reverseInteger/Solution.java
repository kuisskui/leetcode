package reverseInteger;

public class Solution {

    final private String url = "https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/880/";
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            if (result > Integer.MAX_VALUE / 10 || result < Integer.MIN_VALUE / 10) {
                return 0;
            }
            int t = x % 10;
            x /= 10;
            result = result * 10 + t;
        }
        return result ;
    }

    public int bestMemorySolution(int x) {
        int ulta = 0;
        while(x!=0){
            int last = x%10;
            x = x/10;
            if(ulta > Integer.MAX_VALUE/10 || (ulta == Integer.MAX_VALUE/10 && last > 7)){
                return 0;
            } if(ulta < Integer.MIN_VALUE/10 || (ulta == Integer.MIN_VALUE/10 && last<-8)){
                return 0;
            }
            ulta = ulta*10+last;
        }
        return ulta;

    }
}
