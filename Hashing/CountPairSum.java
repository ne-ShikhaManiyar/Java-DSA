/*
Question :  CountPairSum

Problem Description
You are given an array A of N integers and an integer B. 
Count the number of pairs (i,j) such that A[i] + A[j] = B and i ≠ j.

Since the answer can be very large, return the remainder after dividing the count with 109+7.

Note - The pair (i,j) is same as the pair (j,i) and we need to count it only once.


Problem Constraints
1 <= N <= 105
1 <= A[i] <= 109
1 <= B <= 109


Input Format
First argument A is an array of integers and second argument B is an integer.


Output Format
Return an integer.


Example Input
Input 1:

A = [3, 5, 1, 2]
B = 8
Input 2:

A = [1, 2, 1, 2]
B = 3


Example Output
Output 1:

1
Output 2:
4


Example Explanation
Example 1:

The only pair is (1, 2) which gives sum 8
Example 2:

The pair which gives sum as 3 are (1, 2), (1, 4), (2, 3) and (3, 4). 





 */

import java.util.*;
public class CountPairSum {
    
    public static void main(String[] args)
    {
        int B=8;
        int A[] = {3, 5, 1, 2};
        String str = Arrays.toString(A);
        int res = solve(A,B);
        System.out.print(res);
    }

     public static int solve(int A[], int B) {
    int n = A.length;
    
    // Create a HashMap to store the elements of array A and their frequencies
    HashMap<Integer, Integer> hmap = new HashMap<>();
    
    int ans = 0; // Initialize the answer
    final int mod = 1000000009; // Define the modulus value for the answer
    
    for (int i = 0; i < n; i++) {
        int x = B - A[i]; // Calculate the difference between B and the current element
        
        if (hmap.containsKey(x)) {
            // If the difference exists in the HashMap, add its frequency to the answer
            ans = ans + hmap.get(x);
        }
        
        if (hmap.containsKey(A[i])) {
            // If the current element exists in the HashMap, increment its frequency
            int f = hmap.get(A[i]); // Get the frequency of the element
            hmap.put(A[i], f + 1); // Increment the frequency by 1 and update the HashMap
        } else {
            // If the current element is encountered for the first time, add it to the HashMap with frequency 1
            hmap.put(A[i], 1);
        }
    }

    ans = ans % mod; // Take the modulus of the answer
    return (int) ans; // Return the answer as an integer
}
}