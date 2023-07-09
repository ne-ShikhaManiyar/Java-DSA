/* 

Question: Subarray Sum Equals K


Problem Description
Given an array of integers A and an integer B.
Find the total number of subarrays having sum equals to B.


Problem Constraints
 1 <= length of the array <= 50000
-1000 <= A[i] <= 1000


Input Format
The first argument given is the integer array A.
The second argument given is integer B.


Output Format
Return the total number of subarrays having sum equals to B.


Example Input
Input 1:
A = [1, 0, 1]
B = 1
Input 2:
A = [0, 0, 0]
B = 0


Example Output
Output 1:
4
Output 2:
6


Example Explanation
Explanation 1:
[1], [1, 0], [0, 1] and [1] are four subarrays having sum 1.
Explanation 1:
All the possible subarrays having sum 0.


*/

import java.util.Arrays;
import java.util.HashMap;

public class SubarraySumEqualsK {
    

    public static void main(String args[])
    {
       int B=2;
        int A[] = {1,1,1};
        String str = Arrays.toString(A);
        int res = solve(A,B);
        System.out.print(res);
    }


    public static int solve(int[] A, int B) {
        int n = A.length;
        
        // Create an array to store the prefix sums of array A
        int psum[] = new int[n];
        psum[0] = A[0];
        
        // Calculate the prefix sums
        for (int i = 1; i < n; i++) {
            psum[i] = psum[i - 1] + A[i];
        }
        
        // Create a HashMap to store the prefix sums and their frequencies
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1); // Initialize with prefix sum 0 and frequency 1
        
        int count = 0; // Initialize the count of subarrays
        
        // Traverse through the prefix sums array
        for (int i = 0; i < n; i++) {
            if (hm.containsKey(psum[i] - B)) {
                // If the difference between the current prefix sum and B exists in the HashMap, increment the count
                int f = hm.get(psum[i] - B); // Get the frequency of the prefix sum
                count += f; // Increment the count by the frequency
            }
            
            if (hm.containsKey(psum[i])) {
                // If the current prefix sum exists in the HashMap, increment its frequency
                int f = hm.get(psum[i]); // Get the frequency of the prefix sum
                hm.put(psum[i], f + 1); // Increment the frequency by 1 and update the HashMap
            } else {
                // If the current prefix sum is encountered for the first time, add it to the HashMap with frequency 1
                hm.put(psum[i], 1);
            }
        }
        
        return count; // Return the count of subarrays
    }
}

