/*
   https://leetcode.com/problems/is-subsequence/description/
 */


public class issubsequence {
    
    public static void main(String [] args)

    {
        String s1 = "abc";
        String s2 = "ahbgdc";
      //  String s1="axc";
        // String s2="ahbgdc";
        boolean res = solve(s1, s2);
        System.out.print(res);
 
    }

    public static boolean solve(String s, String t)
    {

        int n = s.length();
        int m = t.length();
         int i=0;
         int j=0;

         while(i<n && j<m)
         {
            if(s.charAt(i)==t.charAt(j))
            {
                i++;
                j++;
            }
            else
            {
                j++;
            }
         }

         
         if (i==n)
         {
            return true;
         }
         return false;
    }
}


/*
   Brute force 
   -> we can generate all subsequence of string 2 and check is it a subsequence of string 1
   ->but it will take lot of time as the string length can be lot and for checking 1 by 1 will take lot of time

   tc:o(n*m) 

   //optimal solution -> 2 pointers

   1) we  take 2 pointers i and j starting from 0 index of both strings
   2) we move both pointers towards the length of the string 
   3) we check if characters at both string same we move both the pointers else we move only j pointer
  4) in the end by this way it will complete both string and characters if its subsequence
  5) if i pointer == n (length of first string) it means it traverse whole string and string s, t 
  are subsequence, so it is true
  6) else return false

  TC :o(n)
  sc:o(1)

 */