/*
Question: LongestSubarraywithzerosum

Problem Description
Given an array A of N integers.
Find the length of the longest subarray in the array which sums to zero.

Note :
while we A[i] multiple times, it may cross the range of integer, 
so wisely select data type for any operations.



Problem Constraints
1 <= N <= 105
-109 <= A[i] <= 109


Input Format
Single argument which is an integer array A.


Output Format
Return an integer.


Example Input
Input 1:

 A = [1, -2, 1, 2]
Input 2:

 A = [3, 2, -1]


Example Output
Output 1:

3
Output 2:

0


Example Explanation
Explanation 1:

 [1, -2, 1] is the largest subarray which sums up to 0.
Explanation 2:

 No subarray sums up to 0.





 */ 

import java.util.*;

public class LongestSubarraywithzerosum {
    

    public static void main(String[] args)
    {
    int A[] = {1, -2, 1, 2};
     String str = Arrays.toString(A);
     int res = solve(A);
     System.out.print(res);
    }

    public static int solve(int[] A) {

        int n = A.length;
        
        // Create an array to store the prefix sum of the input array
        long psum[] = new long[n];
        
        // Compute the prefix sum
        psum[0] = A[0];
        for(int i = 1; i < n; i++) {
            psum[i] = psum[i-1] + A[i];
        }
        
        // Create a HashMap to store the prefix sum values and their corresponding indices
        HashMap<Long,Integer> hm = new HashMap<>();
        
        // Initialize the answer to 0
        int ans = 0;
        
        // Add an initial prefix sum of 0 with index -1 to the HashMap
        hm.put(0L, -1);
        
        // Iterate through the array to find the maximum length of subarray with sum 0
        for(int i = 0; i < n; i++) {
            
            // If the current prefix sum is already present in the HashMap, it means we have encountered a subarray with sum 0 before
            if(hm.containsKey(psum[i])) {
                
                // Get the index of the first occurrence of this prefix sum
                int first = hm.get(psum[i]);
                
                // Calculate the current index
                int curr = i;
                
                // Calculate the length of the subarray
                int len = curr - first;
                
                // Update the answer if the current length is greater than the previous maximum
                ans = Math.max(ans, len);
            }
            else {
                // If the current prefix sum is not present in the HashMap, add it along with its index
                hm.put(psum[i], i);
            }
        }

        // Return the maximum length of subarray with sum 0
        return ans;
    }
}
