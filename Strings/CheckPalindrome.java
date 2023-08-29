/*

Question: Check Palindrome - II

 Given a string A consisting of lowercase characters.
Check if characters of the given string can be rearranged to form a palindrome.
Return 1 if it is possible to rearrange the characters of the string A
 such that it becomes a palindrome else return 0.

Problem Constraints
1 <= |A| <= 105

A consists only of lower-case characters.
Input Format
First argument is an string A.


Output Format
Return 1 if it is possible to rearrange the characters of 
the string A such that it becomes a palindrome else return 0.


Example Input
 A = "abcde"
 A = "abbaee"

Output 1:
 0
Output 2:
 1

Example Explanation
Explanation 1:
 No possible rearrangement to make the string palindrome.
Explanation 2:
 Given string "abbaee" can be rearranged to "aebbea" to form a palindrome.


 */


import java.util.*;
public class CheckPalindrome {
 
    public static void main(String [] args)

    {
        String A = " abcde";
         //String A = " abbaee";
        int res = solve(A);
        System.out.print(res);
    }

    

public static int solve(String A) {
    int n = A.length(); // Length of the input string
    HashMap<Character, Integer> hm = new HashMap<>(); // HashMap to store character frequencies
    
    // Count the frequency of each character in the input string
    for (int i = 0; i < n; i++) {
        /* 
        char ch = A.charAt(i); // Get the current character
        if (hm.containsKey(ch)) {
            int f = hm.get(ch); // Get the current frequency
            hm.put(ch, f + 1); // Increment the frequency
        } else {
            hm.put(ch, 1); // Initialize the frequency as 1
        }*/

        hm.put(A.charAt(i),hm.getOrDefault(A.charAt(i), 0)+1);
    }

    // If the length of the string is even
    if (n % 2 == 0) {
        for (int i = 0; i < n; i++) {
            char ch = A.charAt(i);
            if (hm.get(ch) % 2 != 0) { // If character frequency is not even, can't form palindromic permutation
                return 0;
            }
        }
        return 1; // Can form a palindromic permutation
    } else { // If the length of the string is odd
        int count = 0; // To keep track of characters with odd frequencies
        for (int i = 0; i < n; i++) {
            char ch = A.charAt(i);
            if (hm.containsKey(ch) && hm.get(ch) % 2 == 1) {
                count++;
                hm.remove(ch); // Remove the character with odd frequency
            }
            if (count > 1) { // If more than one character has an odd frequency, can't form a palindrome
                return 0;
            }
        }
        return 1; // Can form a palindromic permutation
    }
}


}

/*

TC: o(n)
SC:o(k) k is the number of distinct characters in the input string

Pseudocode

1)We create hashmap to store frequency of all characters in map
2) we check for 2 cases (a palindromic string) can either be even or odd
3)for even case  
-> length of string should be even + all charcters frequency should be 2 
then it can be rerrange to palindromic string else if we encounter with odd length frequency 
& length of string is even then return false;

4) for odd case 
-> length of string should be odd + all charcters frequency should be 2 only 1 character should have odd 
frequencythen it can be rerrange to palindromic string else if we encounter a character  with odd length
frequency more than 1 character & length of string is odd then return false;


 */ 