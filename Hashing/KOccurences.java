/*

Question :KOccurences

Groot has N trees lined up in front of him where the height of the i'th tree is denoted by H[i].

He wants to select some trees to replace his broken branches.

But he wants uniformity in his selection of trees.

So he picks only those trees whose heights have frequency B.

He then sums up the heights that occur B times. 
(He adds the height only once to the sum and not B times).

But the sum he ended up getting was huge so he prints it modulo 10^9+7.

In case no such cluster exists, Groot becomes sad and prints -1.

Constraints:

1.   1<=N<=100000
2.   1<=B<=N
3.   0<=H[i]<=10^9
Input: Integers N and B and an array C of size N

Output: Sum of all numbers in the array that occur exactly B times.

Example:

Input:

N=5 ,B=2 ,C=[1 2 2 3 3]
Output:

5
Explanation:

There are 3 distinct numbers in the array which are 1,2,3.
Out of these, only 2 and 3 occur twice. Therefore the answer is sum of 2 and 3 which is 5.



 */

import java.util.*;
public class KOccurences {
    

    public static void main(String [] args)
    {
        int A[] = {1 ,2, 2, 3, 3};
        int N=5;
        int B=2;
     String str = Arrays.toString(A);
     int res = solve(N,B,A);
     System.out.print(res);
    }

    public static int solve(int A, int B, int C[])
    {
          // Create a HashMap to store the frequency of elements in array C
          HashMap<Integer,Integer> hm = new HashMap<>();

          // Count the frequency of each element in array C
          for(int i=0;i<A;i++)
          {
              if(hm.containsKey(C[i]))
              {
                  // If the element is already present in the HashMap, increment its frequency
                  int f = hm.get(C[i]);
                  hm.put(C[i], f + 1);
              }
              else
              {
                  // If the element is not present in the HashMap, add it with frequency 1
                  hm.put(C[i], 1);
              }
          }
  
          // Initialize variables for sum, flag, and mod
          int sum = 0;
          int flag = 0;
          int mod = 1000000007;
  
          // Iterate over the keys in the HashMap
          for(int key : hm.keySet())
          {
              // Check if the frequency of the key is equal to B
              if(hm.get(key) == B)
              {
                  // If the frequency matches B, add the key to the sum
                  sum = sum + key;
                  flag = 1;
              }
          }
  
          // Check if a key with frequency B was found
          if(flag == 1)
          {
              // Return the sum modulo mod
              return sum % mod;
          }
  
          // If no key with frequency B was found, return -1
          return -1;
    }
}
