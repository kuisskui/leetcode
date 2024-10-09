package rotateImage;

public class Solution {

    final private String url = "https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/770/";

    public void rotate(int[][] matrix) {
        // Transpose
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse row
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0, k = matrix[i].length - 1; j <= k; j++, k--) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
            }
        }
    }
}
