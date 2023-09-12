/*
 Question : valid sudoku 

 https://leetcode.com/problems/valid-sudoku/description/    (leetcode)
 */

public class ValidSudoku {
    
    public static void main(String[] args)
    {

    }

    public boolean isValid(char[][] board, int rows, int cols, char nums) {
        int n = board.length;
    
        // Check row
        for (int j = 0; j < n; j++) {
            if (board[rows][j] == nums) return false;
        }
    
        // Check column
        for (int i = 0; i < n; i++) {
            if (board[i][cols] == nums) return false;
        }
    
        // Check for 3*3 small grid
        // Step 1: Divide row and colno by 3
        int srow = rows / 3 * 3;
        int scol = cols / 3 * 3;
    
        // Step 2: Multiply row and colno by 3
        for (int i = srow; i < srow + 3; i++) {
            for (int j = scol; j < scol + 3; j++) {
                if (board[i][j] == nums) return false;
            }
        }
    
        return true;
    }
    
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
    
        // Iterate through the entire board
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') continue; // Skip empty cells
    
                char num = board[i][j];  // Store the current number
                board[i][j] = '.'; // Backtrack and make the cell empty
    
                // Check if the current placement is valid
                if (!isValid(board, i, j, num)) return false;
    
                // If it's valid, set the cell back to the original number
                board[i][j] = num;
            }
        }
    
        return true;
    }
}


/*

TC : 
-> The isValid function runs in O(n) time, where n is the size of the board, 
because it checks each row, column, and 3x3 subgrid once.
-> The isValidSudoku function iterates through each cell of the board,
 and for each cell, it calls the isValid function, which takes O(n) time. 
 Therefore, the overall time complexity of isValidSudoku is O(n^2).

 SC: The space complexity is O(1) because we are not using any 
 additional data structures that grow with the input size. 
 we are only using a constant amount of extra space for variables.

 Pseudocode:

 1)The isValid method checks if a given number can be placed at a specific position
  (given by rows and cols) on the Sudoku board without violating the rules.
   It does this by checking three conditions:

-> It checks if the number nums is already present in the same row as the specified position.
-> It checks if the number nums is already present in the same column as the specified position.
-> It checks if the number nums is already present in the 3x3 subgrid to which the specified 
position belongs.
-> To do this, it first determines the starting position of the subgrid by
 dividing rows and cols by 3 and then multiplying them by 3.
 -> It then iterates through the subgrid to check for the presence of nums.


2) The isValidSudoku method is the main function that checks the validity 
of the entire Sudoku board. It iterates through each cell of the board and does the following:

-> If the cell is empty (denoted by a '.'), it continues to the next cell.
-> If the cell is not empty, it temporarily removes the current number
 from the cell (backtracking) and stores it in the num variable.
-> It then calls the isValid method to check if placing num at the current position 
is valid. If it's not valid, it returns false, indicating that the Sudoku board is invalid.
-> If the placement is valid, it restores the original number to the cell 
and proceeds to the next cell.

3)If the isValidSudoku method completes its iteration through the 
entire board without finding any invalid placements, it returns true, 
indicating that the Sudoku board is valid according to the rules of Sudoku.

*/ 


/*
   Approach if we have given boolean return type and given integer board

   public class Solution {

 

    public static boolean isItSudoku(int matrix[][]) {

 

        // Write your code here.

        return helper(matrix, 0, 0);

 

    }

 

    public static boolean helper(int[][] board, int row, int col){

 

        if(row == 9) return true;

 

        int nextRow = row;

        int nextCol = col+1;

        if(nextCol == 9){

            nextRow = row + 1;

            nextCol = 0;

        }

 

        if(board[row][col] != 0){

            return helper(board, nextRow, nextCol);

        }

 

        for(int digit=1; digit<=9; digit++){

            if(isSafe(board, row, col, digit)){

 

                board[row][col] = digit;

                

                if(helper(board, nextRow, nextCol)) return true;

 

                board[row][col] = 0;

            }

        }

 

        return false;

    }

 

    public static boolean isSafe(int[][] board, int row, int col, int num){

        for(int i=0; i<9; i++){

            if(board[row][i] == num || board[i][col] == num) return false;

        }

 

        int r = (row/3)*3;

        int c = (col/3)*3;

        for(int i=r; i<r+3; i++){

            for(int j=c; j<c+3; j++){

                if(board[i][j] == num) return false;

            }

        }

 

        return true;

    }

}
 */