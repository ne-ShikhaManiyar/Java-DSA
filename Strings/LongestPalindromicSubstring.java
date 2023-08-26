/*
    Question : Longest Palindromic Substring


    https://leetcode.com/problems/longest-palindromic-substring/description/
    
    //Shreesh lecture explanation
 */



public class LongestPalindromicSubstring {

    public static void main(String[] args)
    {
         String A= "aaaabaaa";
         String res = longestPalindrome(A);
         System.out.print(res);
    }
        public static int[] Expand(String str, int p1, int p2)
        {
            int n = str.length();
            
            // This while loop expands the substring by checking characters at positions p1 and p2.
            // It continues expanding as long as the characters at p1 and p2 are the same.
            while(p1 >= 0 && p2 < n)
            {
                if(str.charAt(p1) != str.charAt(p2))
                {
                    break; // Break the loop if characters don't match.
                }
                p1--; // Move left pointer to the left.
                p2++; // Move right pointer to the right.
            }
    
            // Return the expanded substring indices as an array.
            return new int[]{p1 + 1, p2 - 1};
        }
        
        public static  String longestPalindrome(String A) {
            int n = A.length();
            int omax = 1; // Initialize the maximum length of palindrome substring to 1.
            int os = 0; // Initialize the starting index of the longest palindrome substring.
            int oe = 0; // Initialize the ending index of the longest palindrome substring.
    
            // Check for palindromes with odd length.
            for(int i = 1; i < n - 1; i++)
            {
                //str = cba ch abd
                int ans[] = Expand(A, i - 1, i + 1); // Expand the substring from positions i-1 and i+1.
                int len = ans[1] - ans[0] + 1; // Calculate the length of the expanded substring.
                if(len > omax)
                {
                    omax = len; // Update the maximum length if a longer palindrome is found.
                    os = ans[0]; // Update the starting index of the longest palindrome substring.
                    oe = ans[1]; // Update the ending index of the longest palindrome substring.
                }
            }
    
            // Check for palindromes with even length.
            for(int i = 0; i < n - 1; i++)
            {
                //str = dcba ch ch abce
                int ans[] = Expand(A, i, i + 1); // Expand the substring from positions i and i+1.
                int len = ans[1] - ans[0] + 1; // Calculate the length of the expanded substring.
                if(len > omax)
                {
                    omax = len; // Update the maximum length if a longer palindrome is found.
                    os = ans[0]; // Update the starting index of the longest palindrome substring.
                    oe = ans[1]; // Update the ending index of the longest palindrome substring.
                }
            }
    
            // Construct the longest palindrome substring using the starting and ending indices.
            StringBuilder sb = new StringBuilder();
            for(int i = os; i <= oe; i++)
            {
                sb.append(A.charAt(i)); // Append each character from the substring to the StringBuilder.
            }
    
            return sb.toString(); // Convert the StringBuilder to a string and return the result.
        }
    }
    

/*
  Pseudocode

Expnd function
1) We create a helper function Expand with p1& p2 pointers to check for substring
2)if p1!=p2 we break else move p1-- & p2++ 
3) and retrn the string p1+1, p2+1;

palindrome

4) we iterate for odd length substring
-> we always iterate till i=1 and till i=n-1 bcoz we re considering i=0 (1 char)already substring
-> we move pointer p1=p1-- & p2++ 
-> take out the length 
-> and update omax and os(starting) oe(ending) point 
-> and always check for max length

5) we iterate for even length substring
-> we always iterate till i=0 and till i=n-1 bcoz we re considering i=0 (1 char)already substring
-> we move pointer p1=i & p2+1 
-> take out the length 
-> and update omax and os(starting) oe(ending) point 
-> and always check for max length

6) and with help of stringbuilder we iterate on overall palindromic string 
-> and append in stringbuilder
-> and return palindromic string

TC &SC analysis

In summary, the space complexity is O(omax), and the time complexity is O(n + omax),\
 where n is the length of the input string and omax is the length of the longest palindrome found.


 */