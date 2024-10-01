package plusOne;

public class Solution {

    final private String url = "https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/559/";
    public int[] plusOne(int[] digits) {
        int index = digits.length - 1;
        while (index >= 0){
            if (digits[index] == 9){
                digits[index] = 0;
            }
            else {
                digits[index] = digits[index] + 1;
                break;
            }
            index -= 1;
        }
        if (digits[0] == 0){
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                newDigits[i+1] = digits[i];
            }
            return newDigits;
        }
        return digits;
    }

    public int[] bestSolution(int[] digits) {
        int n = digits.length;
        for (int i = n-1; i>=0; i--){
            if(digits[i]==9){
                digits[i] = 0;
            }
            else{
                digits[i]++;
                return digits;
            }

        }
        digits = new int[n+1];

        digits[0] = 1;
        return digits;
    }

}
