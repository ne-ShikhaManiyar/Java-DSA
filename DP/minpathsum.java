/*
   https://leetcode.com/problems/minimum-path-sum/description/  (leetcode 64)
 */

import java.util.*;
public class minpathsum {
    public static void main(String[] args)
    {
       /*  int[][] A = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };*/

      int A[][]= { 
                   {1, 3, 2},
                   {4, 3, 1},
                   {5, 6, 1} 
    };

       // System.out.println("Min sum path: " + solve(A));
         System.out.println("Min sum path: " + solve2(A));
    }

      // Recursive approach
    public static int solve(int A[][]) {
        // Get the number of rows and columns in the input matrix A.
        int n = A.length; // Number of rows
        int m = A[0].length; // Number of columns
        
        // Call the helper function to find the minimum path sum from the top-left to the bottom-right corner.
        return helper(n - 1, m - 1, A);
    }
    
    public static int helper(int i, int j, int A[][]) {
        // Base case: If we are out of bounds (i or j is negative), return Integer.MAX_VALUE.
        if (i < 0 || j < 0)
            return Integer.MAX_VALUE;
    
        // If we have reached the top-left corner (i = 0 and j = 0), return the value at that cell (A[i][j]).
        if (i == 0 && j == 0)
            return A[i][j];
    
        // Recursive calls to solve subproblems:
        // - Move one step up (i-1) and calculate the minimum path sum from there (a).
        // - Move one step left (j-1) and calculate the minimum path sum from there (b).
        int a = helper(i - 1, j, A);
        int b = helper(i, j - 1, A);
    
        // Calculate the minimum path sum to reach the current cell:
        // It is the minimum of (a, b) plus the value at the current cell (A[i][j]).
        int min = Math.min(a, b) + A[i][j];
        
        // Return the minimum path sum for the current cell.
        return min;
    }

    /*

 Explanation of recursive code :
1)solve is the main function that initiates the process. It sets up the problem's 
parameters (number of rows and columns) and calls the helper function to compute the minimum path sum.

2) helper is a recursive function that calculates the minimum path sum to reach the bottom-right corner 
of the grid from the top-left corner while moving only down and right.

3)The base case checks if we are out of bounds (i < 0 or j < 0) and returns Integer.MAX_VALUE because there's 
no valid path outside the grid.

4)If we've reached the top-left corner (i = 0 and j = 0), we return the value at that cell (A[i][j]) as
 there's only one path to the starting point.

5)We make two recursive calls:

a calculates the minimum path sum by moving one step up (i - 1).
b calculates the minimum path sum by moving one step left (j - 1).
We calculate the minimum path sum to reach the current cell as the minimum of a and b,
 plus the value at the current cell (A[i][j]).

6) Finally, we return the calculated minimum path sum for the current cell. However, note 
that this approach lacks memoization (storing previously computed results), which could lead to 
redundant calculations and inefficient time complexity.

TC: o(2^(n+m))
SC:  O(n + m)

*/
    // DP approach

    public static int solve2(int A[][]) {
        int n = A.length; // Number of rows in the input matrix A
        int m = A[0].length; // Number of columns in the input matrix A
    
        int dp[][] = new int[n][m]; // Create a 2D array to store minimum path sums
    
        // Initialize dp array with Integer.MAX_VALUE to indicate that paths are not calculated yet.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
    
        // Call the helper function to compute the minimum path sum from the top-left to the bottom-right corner.
        return helper2(n - 1, m - 1, A, dp);
    }
    
    public static int helper2(int i, int j, int A[][], int dp[][]) {
        // Base case: If we are out of bounds (i or j is negative), return Integer.MAX_VALUE.
        if (i < 0 || j < 0)
            return Integer.MAX_VALUE;
    
        // If we have reached the top-left corner (i = 0 and j = 0), return the value at that cell (A[i][j]).
        if (i == 0 && j == 0)
            return dp[i][j] = A[i][j];
    
        // If the result for the current subproblem is already computed, return it.
        if (dp[i][j] != Integer.MAX_VALUE)
            return dp[i][j];
    
        // Recursive calls to solve subproblems:
        // - Move one step up (i-1) and calculate the minimum path sum from there (a).
        // - Move one step left (j-1) and calculate the minimum path sum from there (b).
        int a = helper2(i - 1, j, A, dp);
        int b = helper2(i, j - 1, A, dp);
    
        // Calculate the minimum path sum to reach the current cell:
        // It is the minimum of (a, b) plus the value at the current cell (A[i][j]).
        return dp[i][j] = Math.min(a, b) + A[i][j];
    }
}

/*
  Exlanation of DP approach

  1)solve2 is the main function that initiates the process. 
  It sets up the problem's parameters (number of rows and columns), creates a 2D array dp for memoization, 
  and calls the helper2 function to compute the minimum path sum.

2)helper2 is a recursive function that calculates the minimum path sum to reach the bottom-right
 corner of the grid from the top-left corner while moving only down and right.

3)The base case checks if we are out of bounds (i < 0 or j < 0) and returns Integer.MAX_VALUE because 
there's no valid path outside the grid.

4)If we've reached the top-left corner (i = 0 and j = 0), we return the value at that cell (A[i][j]) as
 there's only one path to the starting point.

5)If the result for the current subproblem is already computed (dp[i][j] is not Integer.MAX_VALUE), 
we return it to avoid redundant calculations.

6)We make two recursive calls:

-> a calculates the minimum path sum by moving one step up (i - 1).
-> b calculates the minimum path sum by moving one step left (j - 1).
7) We calculate the minimum path sum to reach the current cell as the minimum of a and b, plus the value 
at the current cell (A[i][j]).

TC: o(n*m)
SC:o(n*m)
 */
