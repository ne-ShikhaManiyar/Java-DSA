/*
 
   https://leetcode.com/problems/unique-paths-ii/ (leetcode 63)

   https://www.interviewbit.com/problems/unique-paths-in-a-grid/
 */

import java.util.*;


public class Uniquepathsingrid {    
    public static void main(String [] args)
    {
        int[][] A = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };

       // System.out.println("Number of unique paths: " + solve(A));
          System.out.println("Number of unique paths: " + solve2(A));
         
    }

      // recursive solution
      public static int solve(int A[][]) {
        int n = A.length;   // Get the number of rows in the grid
        int m = A[0].length; // Get the number of columns in the grid
    
        // Start the computation from the bottom-right corner and return the result
        return helper(A, n - 1, m - 1);
    }
    
    public static int helper(int A[][], int i, int j) {
        // Base case 1: If we're outside the grid boundaries, return 0
        if (i < 0 || j < 0) {
            return 0;
        }
        // Base case 2: If we reach the top-left corner, there's one unique path
        if (i == 0 && j == 0) {
            return 1;
        }
        // Base case 3: If we encounter an obstacle, return 0
        if (A[i][j] == 1) {
            return 0;
        }
    
        // Recursively calculate the number of unique paths by moving up (a) and left (b)
        int a = helper(A, i - 1, j); // Move up
        int b = helper(A, i, j - 1); // Move left
    
        // Return the sum of unique paths by summing up the results from the up and left directions
        return a + b;
    }

    // DP way of approach

   public static int solve2(int A[][]) {
    // Get the number of rows and columns in the input matrix A.
    int n = A.length; // Number of rows
    int m = A[0].length; // Number of columns

    // Create a 2D array dp to store the results of subproblems.
    int dp[][] = new int[n][m];

    // Initialize dp array with -1 to indicate that subproblems are not solved yet.
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            dp[i][j] = -1;
        }
    }

    // Call the helper function to solve the problem.
    return helper2(n - 1, m - 1, A, dp);
}

public static int helper2(int i, int j, int A[][], int dp[][]) {
    // Base case: If we are out of bounds, return 0.
    if (i < 0 || j < 0)
        return 0;

    // If we have reached the top-left corner, return 1 as there is one way to reach it.
    if (i == 0 && j == 0)
        return dp[i][j] = 1;

    // If the current cell in matrix A is blocked (contains 1), return 0 as there is no way to pass through it.
    if (A[i][j] == 1)
        return 0;

    // If the result for the current subproblem is already computed, return it.
    if (dp[i][j] != -1)
        return dp[i][j];

    // Recursive calls to solve subproblems:
    // - Move one step up (i-1) and calculate the number of ways from there (a).
    // - Move one step left (j-1) and calculate the number of ways from there (b).
    // The total number of ways to reach the current cell is a + b.
    int a = helper2(i - 1, j, A, dp);
    int b = helper2(i, j - 1, A, dp);

    // Store the result in the dp array for future use and return it.
    return dp[i][j] = a + b;
   }
}
/*
   Explanation of DP code

1)solve2 is the main function that initiates the process. It sets up the dp array to store the 
results of subproblems and calls the helper2 function to solve the problem.

2)helper2 is a recursive function that calculates the number of ways to reach the bottom-right corner 
of the grid while avoiding blocked cells (cells with a value of 1). It uses dynamic programming to 
store and reuse results of subproblems.

3)The base case checks if we are out of bounds (i < 0 or j < 0) and returns 0 because 
there's no way to reach outside the grid.

4)If we've reached the top-left corner (i = 0 and j = 0), there's only one 
way to reach it, so we return 1.

5)If the current cell contains a 1 (blocked), we return 0 because there's no way to pass through it.

6)If the result for the current subproblem is already computed (dp[i][j] != -1), 
we return it to avoid redundant calculations.

7)We make two recursive calls:
-> a calculates the number of ways to reach the current cell by moving one step up (i - 1).
-> b calculates the number of ways by moving one step left (j - 1).
-> The total number of ways to reach the current cell is a + b.

8)Finally, we store the result in the dp array for future use and return it. 
This dynamic programming approach optimizes the solution by avoiding redundant calculations and 
significantly reducing the time complexity.
 */