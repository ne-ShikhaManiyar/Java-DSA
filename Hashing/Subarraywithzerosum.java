/*
Question:  Sub-array with 0 sum


Problem Description
Given an array of integers A, find and return whether the given array 
contains a non-empty subarray with a sum equal to 0.

If the given array contains a sub-array with sum zero return 1, else return 0.



Problem Constraints
1 <= |A| <= 100000

-10^9 <= A[i] <= 10^9



Input Format
The only argument given is the integer array A.



Output Format
Return whether the given array contains a subarray with a sum equal to 0.



Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
Input 2:

 A = [4, -1, 1]


Example Output
Output 1:

 0
Output 2:

 1


Example Explanation
Explanation 1:

 No subarray has sum 0.
Explanation 2:

 The subarray [-1, 1] has sum 0.

 


 */
import java.util.*;
public class Subarraywithzerosum
{
    public static void main(String[] args)
    {
           int A[] = {2,-1,0,2,3};
     String str = Arrays.toString(A);
     int res = solve(A);
     System.out.print(res);
    }


    public static int solve(int A[]) {
        int n = A.length;
        
        // Create an array to store the prefix sums of array A
        long psum[] = new long[n];
        
        // Create a HashSet to store unique prefix sums
        HashSet<Long> set = new HashSet<>();
        
        psum[0] = A[0];
        set.add((long) A[0]);
        
        // Calculate the prefix sums and add them to the HashSet
        for (int i = 1; i < n; i++) {
            psum[i] = psum[i - 1] + A[i];
            set.add(psum[i]);
        }
    
        // Check if the HashSet contains 0 or if its size is less than n
        if (set.contains((long) 0) || set.size() < n) {
            // If either condition is true, return 1
            return 1;
        } else {
            // Otherwise, return 0
            return 0;
        }
    }
}