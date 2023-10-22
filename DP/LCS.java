/*
  
https://leetcode.com/problems/longest-common-subsequence/  (leetcode 1143)

 */


public class LCS {
    
    public static void main(String[] args)

    {
           String s1 = "abbcdgf";
           String s2 = "achegf";

          // int res = lcs(s1, s2);
          int result = solve(s1,s2);
           System.out.print(result);
    }


    // Recursive way Tc: O(2^(n + m))
       //SC:   O(n + m)
    public static int lcs(String s1, String s2)
    {
         int n = s1.length();
         int m = s2.length();
         return lcs_Helper(s1, s2, n-1, m-1);
    }

    public static int lcs_Helper(String s1, String s2, int i, int j) {
      // Base Case: If either of the strings is empty, the LCS is 0.
      if (i < 0 || j < 0)
          return 0;
      int ans = 0;
      // If the current characters in both strings match, we can include them in the LCS.
      if (s1.charAt(i) == s2.charAt(j)) {
          ans = lcs_Helper(s1, s2, i - 1, j - 1) + 1;
      } else {
          // If the characters don't match, we have two options:
          // 1. Exclude the current character from the first string (s1) and continue with the second string (s2).
          // 2. Exclude the current character from the second string (s2) and continue with the first string (s1).
          // We choose the option that results in the maximum LCS.
          int l1 = lcs_Helper(s1, s2, i - 1, j);
          int l2 = lcs_Helper(s1, s2, i, j - 1);
          ans = Math.max(l1, l2);
      }
      return ans;
    }

    // dp memoization way
    // TC:o(n*m)
    //SC :o(n*m)
    public static int solve(String A, String B) {
      int n = A.length();
      int m = B.length();
      
      int dp[][] = new int[n][m];
      
      // Initialize the DP array with -1 to indicate that the values are not calculated yet.
      for (int i = 0; i < n; i++) {
          for (int j = 0; j < m; j++) {
              dp[i][j] = -1;
          }
      }
      
      // Call the helper function with the DP array.
      return helper(A, B, n - 1, m - 1, dp);
  }
  
  public static int helper(String s1, String s2, int i, int j, int dp[][]) {
      // Base Case: If either of the strings is empty, the LCS is 0.
      if (i < 0 || j < 0)
          return 0;
      
      // If the value is already calculated, return it from the DP array.
      if (dp[i][j] != -1)
          return dp[i][j];
      
      int ans = 0;
      
      if (s1.charAt(i) == s2.charAt(j)) {
          // If the characters at the current indices match, we can include them in the LCS.
          ans = helper(s1, s2, i - 1, j - 1, dp) + 1;
      } else {
          // If the characters don't match, we have two options:
          // 1. Exclude the current character from the first string (s1) and continue with the second string (s2).
          // 2. Exclude the current character from the second string (s2) and continue with the first string (s1).
          // We choose the option that results in the maximum LCS.
          int l1 = helper(s1, s2, i - 1, j, dp);
          int l2 = helper(s1, s2, i, j - 1, dp);
          ans = Math.max(l1, l2);
      }
      
      // Store the calculated value in the DP array to avoid redundant calculations.
      dp[i][j] = ans;
      
      return ans;
  }
}

/*

 Explanation of dp code: 

  1) This code uses dynamic programming to find the Longest Common Subsequence (LCS) of two input strings, A and B.
2)The solve function initializes a 2D DP array dp and then calls the helper function with the last indices of 
both strings along with the DP array.
3)The helper function is a recursive function that calculates the LCS.
 -> It first checks if the value for the current indices i and j is already calculated in the DP array.
  -> If it is, it returns that value to avoid redundant calculations.
4)The base case checks if either of the strings is empty (i.e., i or j is less than 0), in which case the LCS is 0.
5)If the characters at the current indices match, the LCS is increased by 1,
 and the function recursively checks the LCS for the remaining substrings.
6)If the characters don't match, the function calculates two possibilities: 
excluding the current character from either A or B. It chooses the option that results in the maximum LCS.
7)The calculated LCS value is stored in the DP array to avoid recalculating it.
 */
