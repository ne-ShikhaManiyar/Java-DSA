/*
 
  https://leetcode.com/problems/climbing-stairs/description/ (leetcode -70)
*/

import java.util.Arrays;

public class Climbstairs {

    public static void main(String args[]) {
       // int n = 2;

       int n=3;
        
        // Using the recursive approach
        int resultRecursive = climb(n);
        //System.out.println("Recursive approach: " + resultRecursive);

        // Using the top-down DP approach
        int resultTopDown = climbstair(n);
       // System.out.println("Top-down DP approach: " + resultTopDown);

        // Using the bottom-up DP approach (tabulation)
        int resultBottomUp = solve2(n);
        System.out.println("Bottom-up DP approach: " + resultBottomUp);
    }

    // Recursive approach to solve the problem
    // Explanation: This is a naive recursive approach where each step can be reached by either
    // taking 1 step from the previous step or 2 steps from the step before that.
    // Time Complexity: O(2^n)
    public static int climb(int n) {
        if (n <= 1)
            return 1;
        return climb(n - 1) + climb(n - 2);
    }

    // DP approach using top-down (memoization)
    // Explanation: This approach uses an array 'dp' to store intermediate results
    // to avoid redundant calculations.
    // Time Complexity: O(n)
    public static int climbstair(int n) {
        int dp[] = new int[n + 1];
        return solve(n, dp);
    }

    // Helper function for top-down DP approach
    public static int solve(int n, int dp[]) {
        if (n <= 1)
            return 1;
        if (dp[n] != 0)
            return dp[n];

        dp[n] = solve(n - 1, dp) + solve(n - 2, dp);
        return dp[n];
    }

    // DP approach using bottom-up (tabulation)
    // Explanation: This approach builds the result from the ground up, starting
    // from the base cases and moving towards the desired 'n'.
    // Time Complexity: O(n)
    public static int solve2(int n) {
   
        int dp[] = new int[n + 1];
       Arrays.fill(dp,-1);
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <=n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}