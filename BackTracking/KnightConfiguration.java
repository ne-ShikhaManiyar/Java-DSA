/*
  Question : check-knight-tour-configuration


  // read this before solving question      https://www.javatpoint.com/data-structure-2d-array

  https://leetcode.com/problems/check-knight-tour-configuration/
 */



import java.util.*;

public class KnightConfiguration {
    

    public static void main(String[] args)
    {

    }

    
    public boolean helper(int[][] grid, int row, int col, int num) {
        int n = grid.length;  // Get the size of the grid (assuming it's a square grid).
    
        // Base case: If the current cell contains the last number in the sequence,
        // return true to indicate a valid path has been found.
        if (grid[row][col] == n * n - 1) {
            return true;
        }
    
        int i, j;  // Variables to represent movement directions.
    
        // Check for a move: 2 steps up, 1 step right
        i = row - 2;
        j = col + 1;
        if (i >= 0 && j < n && grid[i][j] == num + 1) 
            return helper(grid, i, j, num + 1); // Recursively explore this move.
    
        // Check for a move: 2 steps up, 1 step left
        i = row - 2;
        j = col - 1;
        if (i >= 0 && j >= 0 && grid[i][j] == num + 1) 
            return helper(grid, i, j, num + 1); // Recursively explore this move.
        
    
        // Check for a move: 2 steps down, 1 step right
        i = row + 2;
        j = col + 1;
        if (i < n && j < n && grid[i][j] == num + 1) 
            return helper(grid, i, j, num + 1); // Recursively explore this move.
        
    
        // Check for a move: 2 steps down, 1 step left
        i = row + 2;
        j = col - 1;
        if (i < n && j >= 0 && grid[i][j] == num + 1) 
            return helper(grid, i, j, num + 1); // Recursively explore this move.
        
    
        // Check for a move: 2 steps right, 1 step up
        i = row - 1;
        j = col + 2;
        if (i >= 0 && j < n && grid[i][j] == num + 1) 
            return helper(grid, i, j, num + 1); // Recursively explore this move.
        
    
        // Check for a move: 2 steps right, 1 step down
        i = row + 1;
        j = col + 2;
        if (i < n && j < n && grid[i][j] == num + 1) 
            return helper(grid, i, j, num + 1); // Recursively explore this move.
        
    
        // Check for a move: 2 steps left, 1 step up
        i = row - 1;
        j = col - 2;
        if (i >= 0 && j >= 0 && grid[i][j] == num + 1) 
            return helper(grid, i, j, num + 1); // Recursively explore this move.
        
    
        // Check for a move: 2 steps left, 1 step down
        i = row + 1;
        j = col - 2;
        if (i < n && j >= 0 && grid[i][j] == num + 1) 
            return helper(grid, i, j, num + 1); // Recursively explore this move.
        
    
        // If none of the above conditions are met, return false, indicating no valid path.
        return false;
    }
    
        public boolean checkValidGrid(int[][] grid) {
             // Check if the starting position is valid
            if(grid[0][0]!=0) return false;
              // Call the helper function starting from the top-left corner
            return helper(grid,0,0,0); // it includes row no, colno and no. to track if we have visited or not
    
        }
    }

/*
 
Pseudocode


1) Question says does knight covers all the cell by moving 2.5 moves if yes return true else false
2) in the main function we check whether it starts from 0,0 cell (top-left corner) if not return false
3)and we using helper function to check whether it covers all 8 directions in which it can move and 
covers all numbers
4)in the helper function we pass the grid,row,col and nums (which we want to check is available or not)
5) we check   it moves to next number or not (if present) in grid(2dmatrix)
 by checking in for all 8 directions( with help of i,j to save the rows and cols config)
and call the helper function recursively and in helper function move ahead with nums+1
6)If none of the movement directions results in a valid path, the method returns false.
7)base case of helper function is if we reach the last cell(n*n-1) and traverse all the no's correctly
in the grid (in order ) will return true 


 */