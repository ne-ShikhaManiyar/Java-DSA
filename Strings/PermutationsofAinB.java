/*
 
Question : Permutations of A in B

Problem Description:

You are given two strings, A and B, of size N and M, respectively.
You have to find the count of all permutations of A present in B as a substring. 
You can assume a string will have only lowercase letters.

Problem Constraints
1 <= N < M <= 105


Example Input

Input 1:
 A = "abc"
 B = "abcbacabc"

Input 2:
 A = "aca"
 B = "acaa"

 Output 1:
 5
Output 2:
 2

Explanation 1:
 Permutations of A that are present in B as substring are:
    1. abc
    2. cba
    3. bac
    4. cab
    5. abc
    So ans is 5.

Explanation 2:
 Permutations of A that are present in B as substring are:
    1. aca
    2. caa 



 */


import java.util.*;

public class PermutationsofAinB {
    

    public static void main(String [] args)

    {
         String A = "aca";
        String B = "acaa";
        int result = solve(A, B);
        System.out.print(result);
    }

   
    public static  int solve(String A, String B) 
    {
        // Create a frequency map for characters in string A
        HashMap<Character, Integer> aMap = new HashMap<>();
        // Create a frequency map to track characters in the sliding window of string B
        HashMap<Character, Integer> bMap = new HashMap<>();
        
        int aLen = A.length(); // Length of string A
        int bLen = B.length(); // Length of string B
        
        // Populate the frequency map aMap for string A
        for (int i = 0; i < aLen; i++) {
            aMap.put(A.charAt(i), aMap.getOrDefault(A.charAt(i), 0) + 1);
        }
       
        int window_start = 0; // Start of the sliding window
        int count = 0; // Count of valid permutations
        
        // Iterate through the characters of string B using the sliding window technique
        for (int window_end = 0; window_end < bLen; window_end++) {
            // Add the current character to the bMap frequency map for the current window
            bMap.put(B.charAt(window_end), bMap.getOrDefault(B.charAt(window_end), 0) + 1);
            
            // Check if the window size is equal to the length of string A
            if (window_end - window_start + 1 == aLen) {
                // Compare the frequency maps aMap and bMap for the current window
                if (aMap.equals(bMap)) {
                    count++; // Increment count if they are equal (valid permutation)
                }
                
                // Handle the character at the start of the window (window_start)
                char key = B.charAt(window_start);
                // Decrease the frequency of the character in bMap
                bMap.put(key, bMap.get(key) - 1);
                // Remove the character from bMap if its frequency becomes zero
                if (bMap.get(key) == 0) {
                    bMap.remove(key);
                }
                
                // Move the sliding window to the right
                window_start++;
            }
        }
        
        // Return the count of valid permutations found in string B
        return count;
    }
}

/* 
 
Pseudocode for above approach

Question: need to check combinations of String A in String B if present then return its count

-> we use sliding window approach with hashmap

1)we take out length of both strings A & B
2)we declare 2 maps of(char vs integer) to store the char count of both strings individually
3) in Amap we store char count of string A and if char not present we store its default value 0 
or add it in the count by inc value by 1
4)we declare windowstart pointer (to keep track of window size and move window ahead) 
and count to keep track of combinations of A string in B
5) by window_end pointer our window will move ahead towards right
6) in Bmap we store char count of string A and if char not present we store its default value 0 
or add it in the count by inc value by 1
7)and calculate window_end - window_start+1 is equals to alen &
if amap== bmap then we inc count it means their in window their is combination of a string in b string
8)as we move our window in next iteration so we decrease the frequency of char 
ahead & we check if char we removed while sliding window has count ==0  
-> then we remove it from bmap 
9) and we move the pointer window start ahead to check for other combinations
10) and in the end return the count


In summary:

Time Complexity: O(aLen + bLen)
Space Complexity: O(aLen)

 */


 /*
  Let's step through the example:

window_end = 0, window = "a"

bMap: {'a': 1}
The window size is less than aLen, so nothing special happens.
window_end = 1, window = "ab"

bMap: {'a': 1, 'b': 1}
Window size is still less than aLen.
window_end = 2, window = "abc"

bMap: {'a': 1, 'b': 1, 'c': 1}
Now, the window size is equal to aLen.
We compare aMap and bMap and find that they are equal. 
This means the permutation "abc" (from string A) is present in the window of string B.
The count is incremented by 1.
window_end = 3, window = "bcb"

bMap: {'a': 1, 'b': 2, 'c': 1}
The window size is still equal to aLen.
Even though the characters are different, the frequencies 
are the same as before, so the permutation "cba" is present in this window as well.
The count remains 1.
window_end = 4, window = "cbca"

bMap: {'a': 1, 'b': 2, 'c': 2}
The window size is still equal to aLen.
The permutation "bac" is present in this window.
The count remains 1.
window_end = 5, window = "bcac"

bMap: {'a': 2, 'b': 1, 'c': 2}
The window size is still equal to aLen.
The permutation "cab" is present in this window.
The count remains 1.
window_end = 6, window = "caca"

bMap: {'a': 2, 'b': 1, 'c': 2}
The window size is still equal to aLen.
The permutation "aca" is not a valid permutation of A, so it's not counted.
window_end = 7, window = "acab"

bMap: {'a': 2, 'b': 1, 'c': 2}
The window size is still equal to aLen.
The permutation "cab" is present again in this window 
(notice that the order of characters matters in permutations).
The count remains 1.
window_end = 8, window = "cab"

bMap: {'a': 2, 'b': 1, 'c': 1}
The window size is now less than aLen.
At the end of the iterations, the count is 5, 
which indicates that there are five permutations of 
string A ("abc", "cba", "bac", "cab", and "abc") present as substrings in string B.
  */