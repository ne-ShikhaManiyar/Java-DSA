/* 

https://leetcode.com/problems/fibonacci-number/  (leetcode 590)

 */

import java.util.*;

public class Fibonacci
{
    public static void main(String[] args)
    {

        // int n=4;
        int n=6;
        // int result = fib(n);
        int res = fibonacci(n);
         System.out.println(res);
    }

     // Recursive approach to calculate Fibonacci numbers
    public static int fib(int n) {
        // Base case: If n is 0 or 1, return n
        if (n <= 1)
            return n;

        // Recursive call to calculate the Fibonacci number
        // as the sum of the two previous Fibonacci numbers
        return fib(n - 1) + fib(n - 2);
    }

    // DP approach to calculate Fibonacci numbers
    public static int fibonacci(int n) {
        // Create an array to store the calculated Fibonacci values
        int dp[] = new int[n + 1];

        // Initialize the array with -1 to mark that values are not yet calculated
        Arrays.fill(dp, -1);

        // Call the helper function to compute Fibonacci and use DP
        return fibo(n, dp);
    }

    // Helper function for DP approach to calculate Fibonacci numbers(top-down approach)
    public static int fibo(int n, int dp[]) {
        // Base case: If n is 0 or 1, return n
        if (n <= 1)
            return n;

        // If the Fibonacci value for 'n' is already calculated, return it
        if (dp[n] != -1) {
            return dp[n];
        }

        // Calculate the Fibonacci value for 'n' using the values of 'n-1' and 'n-2'
        dp[n] = fibo(n - 1, dp) + fibo(n - 2, dp);

        // Return the calculated value for 'n'
        return dp[n];
    }

    //DP Tabulation approach(bottom-up approach) starting from base cases

    public static int fiboTb(int n)
    {
        int dp[] = new int[n+1];
        dp[0] =0;
        dp[1] =1;
        for(int i=2;i<dp.length;i++)
        {
            dp[i]= dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
        
}