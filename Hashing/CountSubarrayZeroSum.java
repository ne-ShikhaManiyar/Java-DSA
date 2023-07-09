/*

Question : CountSubarrayZeroSum

Problem Description
Given an array A of N integers.

Find the count of the subarrays in the array which 
sums to zero. Since the answer can be very large, 
return the remainder on dividing the result with 109+7


Problem Constraints
1 <= N <= 105
-109 <= A[i] <= 109


Input Format
Single argument which is an integer array A.


Output Format
Return an integer.


Example Input
Input 1:

 A = [1, -1, -2, 2]
Input 2:

 A = [-1, 2, -1]


Example Output
Output 1:

3
Output 2:

1


Example Explanation
Explanation 1:

 The subarrays with zero sum are [1, -1], [-2, 2] and [1, -1, -2, 2].
Explanation 2:

 The subarray with zero sum is [-1, 2, -1].






 */

import java.util.*;
public class CountSubarrayZeroSum {
    
    public static void main(String [] args)
    {
       // int A[] = {1, -1, -2, 2};
       int A[] = {-1, 2, -1};
        String str = Arrays.toString(A);
        int res = solve(A);
        System.out.print(res);
    }

    public static  int solve(int[] A) {

        // Get the length of the input array
        int n = A.length;
        
        // Define the modulo value
        final int mod = 1000000009;
        
        // Create a HashMap to store the cumulative sums and their frequencies
        HashMap<Long, Integer> hmap = new HashMap<>();
        
        // Create an array to store the prefix sums
        long psum[] = new long[n];
        
        // Initialize variables
        psum[0] = A[0];
        int count = 0;
        
        // Check if the first element is zero and increment count accordingly
        if (psum[0] == 0) {
            count++;
        }
        
        // Calculate prefix sums and update count
        for (int i = 1; i < n; i++) {
            psum[i] = psum[i - 1] + A[i];
            
            // Check if the current prefix sum is zero and increment count accordingly
            if (psum[i] == 0) {
                count++;
            }
        }
        
        // Get the length of the prefix sums array
        int m = psum.length;
        
        // Iterate over the prefix sums array and update the HashMap
        for (int i = 0; i < m; i++) {
            if (hmap.containsKey(psum[i])) {
                // If the current prefix sum already exists in the HashMap,
                // increment the count by the frequency of the prefix sum
                int f = hmap.get(psum[i]);
                count = count + f;
                hmap.put(psum[i], f + 1);
            } else {
                // If the current prefix sum does not exist in the HashMap,
                // add it with a frequency of 1
                hmap.put(psum[i], 1);
            }
        }

        // Return the count modulo the defined value
        return count % mod;
    }
}

