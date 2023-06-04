/* Ques : Hidden pattern 

Problem Description

Given two strings - a text A and a pattern B, having lower-case alphabetic characters. 
You have to determine the number of occurrences
 of pattern B in text A as its substring. i.e. 
 the number of times B occurs as a substring in A.
  
 Problem Constraints

1 <= |B| <= |A| <= 105

Input Format

First argument is a string A
Second argument is a string B

Input 1:
 A = "abababa"
 B = "aba" 
o/p : 3

Input 2:
 A = "mississipi"
 B = "ss"
 o/p:2 

Input 3:
 A = "hello" 
 B = "hi" 
o/p:0

Hint : use KMP algorithm for finding the pattern in the given Text
need to return the count of the pattern in given string 

 */

public class HiddenPattern
{
    public static void main(String [] args)
    {
        String A ="mississipi";
        String B = "ss";

        int res = solve(A,B);
        System.out.print(res);

    }

    public static int solve(String A, String B)
    {
        int count = 0; // Initialize a count variable to keep track of the occurrences
        String D = B + "$" + A; // Concatenate B, a special character "$", and A to form a new string D
        int lps[] = LPS(D); // Compute the Longest Proper Prefix that is also a Suffix (LPS) array for string D
        for (int i = 0; i < D.length(); i++)
        {
            if (lps[i] == B.length())
            {
                count++; // If the value at index i in LPS array is equal to the length of B, increment the count
            }
        }
        return count; // Return the final count of occurrences
    }

    public static int[] LPS(String C)
    {
        // Get the length of the input string
        int n = C.length();
        
        // Create an array to store the longest proper prefix which is also a suffix
        int Lps[] = new int[n];
        
        // Initialize the first element of the Lps array as 0
        Lps[0] = 0;
        
        // Iterate through the input string starting from the second character
        for (int i = 1; i < n; i++)
        {
            // Initialize a variable 'x' with the value of the previous Lps element
            int x = Lps[i - 1];
            
            // Compare the current character with the character at position 'x'
            while (C.charAt(i) != C.charAt(x))
            {
                // If 'x' reaches the first character (position 0), set it to -1 and break the loop
                if (x == 0)
                {
                    x = -1;
                    break;
                }
                
                // Update 'x' with the value of the previous Lps element
                x = Lps[x - 1];
            }
            
            // Assign the value of 'x' plus 1 to the current Lps element
            Lps[i] = x + 1;
        }
        
        // Return the Lps array
        return Lps;
    }
    
}