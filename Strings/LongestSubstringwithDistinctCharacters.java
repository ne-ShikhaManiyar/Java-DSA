/*
Question: Longest Substring Without Repeating Characters

Ques Desc: Given a string A, find the length of the longest substring without repeating characters.

Note: Users are expected to solve in O(N) time complexity.

Problem Constraints
1 <= size(A) <= 106

String consists of lowerCase,upperCase characters and digits are also present in the string A.

Example Input
Input 1: A = "abcabcbb"
Input 2 :A = "AaaA"

Example Output
Output 1: 3  //Substring "abc" is the longest substring without repeating characters in string A.
Output 2: 2 //Substring "Aa" or "aA" is the longest substring without repeating characters in string A.

Hint : Use Sliding window approach along with 2 pointers and HashSet 
Add the p2 elements if not present and remove the p1 elements and inrecement both 
and mainatain maxLen of substring need to return;

//Approach 2 we can use sliding window along with Hashmap too


*/


import java.util.HashSet;

public class LongestSubstringwithDistinctCharacters {

    public static void main(String[] args)
    {
        //String A= "pwwkew";
        String A= "abfghbadbfg";
        int n = A.length();
        int result = solve(A);
        System.out.print(result);
    }

    public static int solve(String A)
    {
        int n = A.length();
        int p1=0;       // we take  2pointers and Hashset approach over here 
        int p2=0;
        int maxLen =0; // need to return max length of substring with distinct characters
        HashSet<Character> set = new HashSet<>();
        while(p1<=p2 && p2<n)
        {
              if(!set.contains(A.charAt(p2)))
              {
                set.add(A.charAt(p2));
                p2++;
                maxLen = Math.max(maxLen,set.size());
              }
              else
              {
                set.remove(A.charAt(p1));
                p1++;
              }
        }
        return maxLen;

    }
    
}
