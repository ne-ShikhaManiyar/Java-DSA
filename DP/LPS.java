/*
   https://leetcode.com/problems/longest-palindromic-subsequence/  (leetcode 516)
      
 */

public class LPS {
    
    public static void main(String [] args)
    {

    }
    public int LCS(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n][m];
        
        // Initialize the DP array with -1 to indicate that the values are not calculated yet.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }
        
        return helper(s1, s2, n - 1, m - 1, dp);
    }
    
    public int helper(String s1, String s2, int i, int j, int dp[][]) {
        if (i < 0 || j < 0)
            return 0;
        
        // If the value is already calculated, return it from the DP array.
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
    
        int ans = 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            ans = helper(s1, s2, i - 1, j - 1, dp) + 1;
        } else {
            int l1 = helper(s1, s2, i - 1, j, dp);
            int l2 = helper(s1, s2, i, j - 1, dp);
            ans = Math.max(l1, l2);
        }
        
        dp[i][j] = ans;
        return ans;
    }
    
    public int longestPalindromeSubseq(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        return LCS(s, reversed);
    }
}


/*
   1)This code finds the Longest Palindromic Subsequence (LPS) of a given string s by finding
    the LCS between the original string and its reverse.

2) The LCS method initializes a DP array and calls the helper method to compute the LCS between two strings, 
s1 and s2, which are the original string and its reverse.

3)The helper method is the same as the one used in the previous code to find the LCS between two strings.

4) The longestPalindromeSubseq method takes a string s, reverses it, and then calculates the LCS 
between the original and reversed strings using the LCS method, effectively finding 
the LPS of the original string.

Time Complexity:
The time complexity of this code is O(n^2), where n is the length of the input string. 
This is because the code uses dynamic programming to calculate and store the LCS values 
for all pairs of indices in the input strings. Reversing the string can be done in O(n) time.

Space Complexity:
The space complexity is O(n^2) due to the DP array, which stores intermediate results for all pairs of indices in
 the input strings.
 */