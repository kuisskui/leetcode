package stringToInteger;

public class Solution {

    final private String url = "https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/884/";

    public int myAtoi(String s) {
        int i = 0, sign = 1, result = 0;
        int n = s.length();

        // Step 1: Ignore leading whitespace
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Step 2: Check for the sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // Step 3: Convert the number
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // Step 4: Handle overflow and underflow
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        // Apply the sign and return the result
        return result * sign;
    }
}