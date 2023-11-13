/*

   Remove All Adjacent Duplicates In String

    https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/(leetcode 1047)
 */

import java.util.*;
public class removeduplicatecharactersfromstring {
    
    public static void main(String[] args)
    {
        String str1 ="abbaca";
        System.out.print(solve(str1)); 
    }

    public static String solve(String s)
    {
        int n = s.length();
        if(n==1) return s;
        Stack<Character> stk = new Stack<>();
        int i=0;
        while(i<n)
        {
             if(stk.isEmpty() || s.charAt(i)!=stk.peek())
             {
                stk.push(s.charAt(i));
                i++;
             }
             else
             {
                stk.pop();
                i++;
             }
        }

        String ans="";
        while(!stk.isEmpty())
        {
            ans = stk.peek()+ans;
            stk.pop();
        }
        return ans;
    }
}

/*
  Explanation of the code :

  1)check if string length is 1 char return it (base case)
  2)Declare an character stack , an iterate till length of th string
  3)check if stk is empty or curr string char is not equal to top ele of stack (if yes) then add it in 
  stack and move ahead
  -> else pop the ele from stack and move ahead
  4)now declare an empty ans string 
  5)iterate till stack is empty and in the ans append the top ele of stack + ans
  6) pop the ele from stack  and return the ans; 

  TC : o(N)
  SC : o(N)
 */

