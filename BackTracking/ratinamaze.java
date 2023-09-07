/*
   Question : Rat in a maze 

   https://www.codingninjas.com/studio/problems/rat-in-a-maze-_8842357?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTab=0

 */

import java.util.*;


public class ratinamaze {
 
    public static void main(String[] args)
    {

    }


    // Function to find all possible paths from (sr, sc) to (er, ec) in the matrix.
    public static void solve(int sr, int sc, int er, int ec, String path, int matrix[][], List<String> ans) {
        // Base cases:
        // 1. If the current position is out of bounds, return.
        if (sr < 0 || sc < 0 || sr >= er || sc >= ec) return;
        // 2. If the current cell is blocked (matrix[sr][sc] == 0), return.
        if (matrix[sr][sc] == 0) return;
        // 3. If the current position is the destination, add the path to the answer and return.
        if (sr == er - 1 && sc == ec - 1) {
            ans.add(path);
            return;
        }

        // Mark the current cell as visited by setting it to 0.
        matrix[sr][sc] = 0;

        // Explore in all four directions (up, down, left, right).
        solve(sr - 1, sc, er, ec, path + "U", matrix, ans); // Up
        solve(sr + 1, sc, er, ec, path + "D", matrix, ans); // Down
        solve(sr, sc - 1, er, ec, path + "L", matrix, ans); // Left
        solve(sr, sc + 1, er, ec, path + "R", matrix, ans); // Right

        // After exploring in all directions, revert the cell back to 1 for backtracking.
        matrix[sr][sc] = 1;
    }

    
    // Main function to find all paths in the rat maze.
    public static List<String> ratMaze(int[][] mat) {
        String path = "";
        int n = mat.length;    // Number of rows in the matrix.
        int m = mat[0].length; // Number of columns in the matrix.
        List<String> ans = new ArrayList<>(); // List to store the paths.
        solve(0, 0, n, m, path, mat, ans); // Start from the top-left corner.
        return ans; // Return the list of paths.
    }

}

/*
  
Pseudcode : 

1)The solve function is a recursive function that explores all possible 
paths from a given position (sr, sc) to the destination (er, ec).

2) Base cases are used to determine when to stop the recursion:

If the current position is out of bounds, the function returns.
If the current cell is blocked (contains 0), the function returns.
If the current position is the destination, 
the path is added to the answer list, and the function returns.

3)The current cell is marked as visited by setting matrix[sr][sc] to 0.

4) The function explores in all four directions (up, down, left, right)
 by making recursive calls with updated positions and paths.

5)After exploring in all directions, the cell is reverted back to 1 to allow backtracking.

6)The ratMaze function initializes the path, 
determines the matrix dimensions, creates an empty 
list to store paths, and calls the solve function to start 
the search from the top-left corner (0, 0).

7)Finally, it returns the list of all paths found.
 */