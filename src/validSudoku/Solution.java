package validSudoku;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    final private String url = "https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/769/";

    public boolean isValidSudoku(char[][] board) {
        // check row
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                if (board[i][j] != '.'){
                    for (int k = j+1; k < 9; k++){
                        if (board[i][j] == board[i][k]){
                            return false;
                        }
                    }
                }
            }
        }

        // check column
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                if (board[j][i] != '.'){
                    for (int k = j+1; k < 9; k++){
                        if (board[j][i] == board[k][i]){
                            return false;
                        }
                    }
                }
            }
        }

        // check sub boxes
        for (int i = 0; i < 9; i+=3) {
            for (int j = 0; j < 9; j+=3) {
                for (int k = i; k < i + 3; k++){
                    for (int l = j; l < j + 3; l++){
                        if (board[k][l] != '.'){
                            for (int m = i; m < i + 3; m++){
                                for (int n = j; n < j + 3; n++){
                                    if (board[m][n] == board[k][l] && k != m & l != n){
                                        return false;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
    class BestRuntimeSolution {
        public boolean isValidSudoku(char[][] board) {
            for(int i = 0; i < 9; i++)
            {
                for(int j = 0; j < 9; j++)
                {
                    char num = board[i][j];
                    if(board[i][j] != '.')
                    {
                        board[i][j] = '.';
                        if(!isValid(num, board, i, j)) return false;
                        board[i][j] = num;
                    }
                }
            }
            return true;
        }

        public boolean isValid(char ch, char board[][], int row, int col)
        {
            for(int i = 0; i < 9; i++)
            {
                if(board[i][col] == ch) return false;
                if(board[row][i] == ch) return false;
                if(board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == ch) return false;
            }
            return true;
        }
    }

    public boolean BestMemorySolution(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] grids = new HashSet[9];

        for(int i = 0; i < 9; i++)
        {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            grids[i] = new HashSet<>();
        }

        for(int r = 0; r < 9; r++)
        {
            for(int c = 0; c < 9; c++)
            {
                if(board[r][c] == '.')
                    continue;

                int g = (r/3) * 3 + (c/3);

                if(rows[r].contains(board[r][c]) || cols[c].contains(board[r][c]) || grids[g].contains(board[r][c]))
                    return false;

                rows[r].add(board[r][c]);
                cols[c].add(board[r][c]);
                grids[g].add(board[r][c]);
            }
        }

        return true;
    }
}
