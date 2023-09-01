/*
Question: Longest Substring Without Repeating Characters

https://leetcode.com/problems/longest-substring-without-repeating-characters/



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

        // we take  2pointers and Hashset approach over here 
        int p1=0;    // both at index 0 intially
        int p2=0; // both at index 0 intially
        int maxLen =0; // need to return max length of substring with distinct characters
        HashSet<Character> set = new HashSet<>();
        while(p1<=p2 && p2<n)    // iterate till p1 less or equals to p2 & p2<n
        {
              if(!set.contains(A.charAt(p2)))  // if set not contains character(where p2 pointer is add in set)
              {
                set.add(A.charAt(p2));
                p2++;
                maxLen = Math.max(maxLen,set.size()); // and calculate the length of distinct char
              }
              else
              {
                set.remove(A.charAt(p1));  // if we find similar character then will remove 
                                            // all char from set till p1 comes that character 
                                             
                p1++;  // and keep inc p1 pointers
              }
        }
        return maxLen;

    }
    
}
/*
 Tc: o(N)
 Sc: o(N) for hashset

Pseudocode for above code

-> we need to return max length of substring whose distinct charc in string

1)we will follow 2 pointers approach 
2)intialise p1 & p2=0 and bth would be on index 0
3) and declare maxlen to maintain length of distinct charc
4) Declare a character hashset to store distinct characters
5) we itr till end p1<=p2 && till end of string p2<n
6) if p2 (is on the char and is not present in set) add in the set
-> and increment p2++
7) if we find the duplicate character in the string remove from set 
-> and move P1++ till it crosses the duplicate character 
8) after that add duplicate character again in set
9) in the end continue till end of string and return max length

 
 */