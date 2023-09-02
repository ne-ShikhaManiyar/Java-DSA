/*
 Question : Isomporphic strings

 https://leetcode.com/problems/isomorphic-strings/description/

 */

import java.util.*;
public class IsomorphicStrings
{
    public static void main(String [] args)
    {
      // String s1 = "foo" ;
       // String s2 = "bar" ;
        String s1 = "paper";
        String s2 ="title";
        boolean res = Isomorphic(s1, s2);
        System.out.print(res);

    }

    public static boolean Isomorphic(String s, String t)
    {
        int s1 = s.length();
        int s2= t.length();

        if(s1!=s2)
        {
            return false;
        }

        // 2maps too store mappings of strings s and t
        HashMap<Character, Character> h1 = new HashMap<>();
        HashMap<Character,Character> h2 = new HashMap<>();

        for(int i=0;i<s1;i++)
        {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if(h1.containsKey(ch1))  // it checks if hashmap has already mapping for ch1 if yes 
            {
                if(h1.get((ch1))!=ch2) // then it  chechks mapping for ch2 if they are not same it returns false
                {
                    return false;
                }
            }

            if(h2.containsKey((ch2))) // it checks if hashmap has already mapping for ch2 if yes 
            {
                if(h2.get(ch2)!=ch1)// then it  chechks mapping for ch2 if they are not same it returns false
                {
                    return false;
                }
            }

            // we keep adding the mappings  over here down
            h1.put(ch1,ch2);   // if we add above the code will fail for non-isomrphic strings
            h2.put(ch2,ch1);  // as we are already developing mapping before  considering whether they are valid or unique.

        }
        return true;
    }
}

/*
 Pseudocode 

1) edge case check length of i/p strings if not same return false
2) take 2 hashmaps to store the mappings of string 1 and string 2
3) check if map1 has already mappings for string 1 if true
-> then check in map1 string1 and string2 are mapped or not if not return false
4) check if map2 has already mappings for string 2 if true
-> then check in map2 string2 and string1 are mapped or not if not return false
5)and in the end add mapping for string 1 & 2 in the  maps
-> if we add mappings before checking then it will encounter issues for non -isomorphic
as we already created mappings before validating its unique or not

Time & space complexity

In summary, the provided code has a time complexity of O(n) 
and a space complexity of O(n), where n is the length of the input strings s and t.
 It is an efficient solution for determining if two strings are isomorphic.

 */