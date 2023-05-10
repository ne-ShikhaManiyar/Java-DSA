/*
 * Given an array of integers A, sort the array into a wave-like array and return it.
In other words, arrange the elements into a sequence such that
a1 >= a2 <= a3 >= a4 <= a5..... 
NOTE: If multiple answers are possible, return the lexicographically smallest one.

Problem Constraints
1 <= len(A) <= 106
1 <= A[i] <= 106

i/p 1: A[1,2,3,4]
o/p 1: [2,1,4,3]

i/p 2: A[3,9,7,6,2]
 * o/p2: [3 2 7 6 9]
 * 
 * Hint : Sort the array 
 *        then on every alternate pairs swap it with adjacent element to form the given  pairs
 *      
 *    sorting gives A[0]<= A[1]<=A[2]<=A[3]=A[4]
 *     wave form (we want our answer)  A[1]>=A[0]<=A[3]>= A[2]<=A[4]
 *  
 *    eg : sorted array [2,3,6,7,9]
 *         wave array [3,2,7,6,9]
 * 
 * 
 */


package Questions;

import java.util.Arrays;
public class WaveArray {

    public static void main(String[] args) {
      
      
        int A[] = {3,9,7,6,2};
        int n = A.length;
        Arrays.sort(A);        // always sort the array
        for(int i=0;i<n-1;i++)
        {
          if(i==0||i%2==0)   // observe wave form for every alternate pairs we are swaping so thats why 
                               //checking on i=0 or i=2
          {
            int temp = A[i];      //swapping the adjacent elements as per the wave form pattern
            A[i] = A[i+1];
            A[i+1] = temp;
          }
          
          String str = Arrays.toString(A);
          System.out.print(str);
        }
        
        
        
              
          }
          
    
}
