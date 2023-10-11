/*
    https://www.geeksforgeeks.org/minimum-number-of-squares-whose-sum-equals-to-given-number-n/
 */

import java.util.*;
public class Minnoofsquares {
    
    public static void main(String [] args)
    {
        // Input value for which we want to find the minimum number of squares
        int n = 6;
        
        // Call the function to calculate the minimum number of squares and print the result
        int result = minsquarescount(n);
        System.out.println(result);
    }

    // Recursive function to find the minimum number of squares to sum up to 'n'
    /*
       Time Complexity: O(2^n)
       Space Complexity: O(n) where n is the recursion stack space.
     */
    public static int minsquares(int n)
    {
        if (n <= 1) return n; // If 'n' is 0 or 1, it already consists of one square.
        
        int min = Integer.MAX_VALUE; // Initialize the 'min' variable with a large value.
        
        for (int i = 1; i * i <= n; i++) {
            int count = minsquares(n - i * i); // Recursively calculate the minimum squares for the remaining value.
            min = Math.min(count, min); // Update 'min' with the minimum count obtained so far.
        }
        
        return min + 1; // Add 1 to the minimum count for the current 'n'.
    }

    /*
       Time Complexity: O(n*sqrtn)
        Auxiliary Space: O(n)
     */
    // Dynamic Programming function using memoization to find the minimum squares   
    public static int minsqrt(int n, int dp[])
    {
        if (n <= 1) return 1; // If 'n' is 0 or 1, it already consists of one square.
        if (dp[n] != 1) return dp[n]; // If the result for 'n' is already computed, return it from the memoization table.
        
        int min = Integer.MAX_VALUE; // Initialize 'min' with a large value.
        
        for (int i = 1; i * i <= n; i++) {
            int count = minsqrt(n - i * i, dp); // Recursively calculate the minimum squares for the remaining value.
            min = Math.min(min, count); // Update 'min' with the minimum count obtained so far.
        }
        
        dp[n] = min + 1; // Store the result in the memoization table.
        return min + 1; // Add 1 to the minimum count for the current 'n'.
    }

    // Function to find the minimum number of squares using memoization
    public static int minsquarescount(int n)
    {
        int dp[] = new int[n + 1]; // Create a memoization table of size 'n + 1'.
        Arrays.fill(dp, 1); // Initialize the table with 1 (for the base case).
        minsqrt(n, dp); // Call the memoization function to compute the minimum squares for 'n'.
        return dp[n]; // Return the result.
    }
}
