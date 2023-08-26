/*
  Question :Longest Common Prefix


  https://leetcode.com/problems/longest-common-prefix/

  https://studyalgorithms.com/string/leetcode-longest-common-prefix/
 */

import java.util.*;

public class LongestCommonPrefix {
    
    public static void main(String[] args)
    {

    }

    public static String solve(String[] s)
    {

        StringBuilder sb = new StringBuilder();// to store longest common prefix
        Arrays.sort(s); // we sort the array so we can make the grp of words in sorted order
                                         

        char first[] = s[0].toCharArray();  // now we tke out first word
        char last[] = s[s.length-1].toCharArray(); //now we take ut last word

        for(int i=0;i<first.length;i++)   // itr till length of first word
        {
            if(first[i]!=last[i])
            {
                break;            // we will compare char by char if not same break 
            }
            sb.append(first[i]); // we will compare char by char if same append in stringbuilder
        }
        return sb.toString(); // and return the string
    }
}
/*
  Pseudocode for the code

  BF code : we can compare word by word for each characters so it would take o(N*M) TC
 N -> length of smallest string and M -> no. of words in given string 

 // for optimal solution 

 1) Create stringbuidler to store the answer of LCS
 2) Then sort the array so all the words will be arranged in sorted order
 3) then take first string and then take last string
 4) iterate on first string if first string char & laststring char not same break
 -> else if they are same then add it in stringbuilder

 5)then return the stringbuilder

 TC: o(logn) as we have sorted the array
 SC:o(1)
 */