
/*

Question : Valid Anagram

https://leetcode.com/problems/valid-anagram/description/


 
 */
import java.util.*;

public class ValidAnagrams {
    
    public static void main(String [] args)
    {

    }

    // Approach 1: 

    public int solve(String A, String B) {
        // Convert input strings to character arrays
        char[] A1 = A.toCharArray();
        char[] B1 = B.toCharArray();
        
        // Sort the character arrays in ascending order
        Arrays.sort(A1);
        Arrays.sort(B1);
        
        // Compare the sorted character arrays element by element
        for (int i = 0; i < A1.length; i++) {
            // If corresponding characters are not equal, the strings are not anagrams
            if (A1[i] != B1[i]) {
                return 0;
            }
        }
        // If all characters are equal, the strings are anagrams
        return 1;
    }

    /*
     TC: time complexity is dominated by the sorting step: O(n * log n).
     Overall space complexity is O(n)

     */

     //Approach 2: 

     class Solution {
        public boolean isAnagram(String s, String t) {
            // Get the lengths of the input strings
            int sLen = s.length();
            int tLen = t.length();
            
            // If lengths are different, strings can't be anagrams
            if (sLen != tLen) {
                return false;
            }
    
            // Create hash maps to store character frequencies
            HashMap<Character, Integer> Amap = new HashMap<>();
            HashMap<Character, Integer> Bmap = new HashMap<>();
    
            // Count character frequencies in string 's' and 't'
            for (int i = 0; i < sLen; i++) {
                char c = s.charAt(i);
                char d = t.charAt(i);
    
                Amap.put(c, Amap.getOrDefault(c, 0) + 1);
                Bmap.put(d, Bmap.getOrDefault(d, 0) + 1);
            }
    
            // Compare character frequencies in the hash maps
            if (Amap.size() == Bmap.size()) {
                for (char k : Amap.keySet()) {
                    if (!Bmap.containsKey(k) || !Amap.get(k).equals(Bmap.get(k))) {
                        return false; // Frequencies don't match, not anagrams
                    }
                }
                return true; // Frequencies match, strings are anagrams
            } else {
                return false; // Different number of distinct characters
            }
        }
    }
    
    /*
     Time Complexity:

Converting strings to character arrays and comparing lengths takes O(n) time, 
where n is the length of the input strings.
Iterating through the characters of the strings, updating hash maps, 
and comparing hash maps take O(n) time in total.
Overall time complexity is O(n).


Space Complexity:

The space complexity is determined by the hash maps Amap and Bmap,
 which can have at most k distinct characters, where k is the 
 size of the character set (e.g., 26 for lowercase English letters).
In the worst case, both hash maps could store all k characters, leading to O(k) space complexity.
Since k is a constant (for example, 26 for lowercase English letters), 
the space complexity can be considered O(1).
     */
        
}
/*
 
Pseudocode 1:  

1) we can convert both string in to char array
2) and then we can sort both charaaray
3)and iterate on  string A
4) and comapre character by character if same then return true else false


Pseudocode 2:

1) check if the length of string a !=b then return false
2) create 2 maps to store the char frequency of both strings by iterating on String s
3)after storing in map
then check if check size of the map same 
4)then use foreach loop to  check for frequencies of characters in both maps if same then return true
else false


 */