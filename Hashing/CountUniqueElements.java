/*

Problem Description
You are given an array A of N integers. Return the count of elements
 with frequncy 1 in the given array.


Problem Constraints
1 <= N <= 105
1 <= A[i] <= 109


Input Format
First argument A is an array of integers.


Output Format
Return an integer.


Example Input
Input 1:
A = [3, 4, 3, 6, 6]
Input 2:
A = [3, 3, 3, 9, 0, 1, 0]


Example Output
Output 1:
1
Output 2:
2


Example Explanation
Explanation 1:
Only the element 4 has a frequency 1.
Explanation 2:
The elements 9 and 1 has a frequncy 1.





 */

import java.util.*;

public class CountUniqueElements {

    public static void main(String [] args)
    {
        int A[] = {1, -2, 1, 2};
        String str = Arrays.toString(A);
        int res = solve(A);
        System.out.print(res);
    }

   public static int solve(int A[]) {
    int n = A.length;
    
    // Create a HashMap to store the elements of array A and their frequencies
    HashMap<Integer, Integer> hmap = new HashMap<>();
    
    // Count the frequencies of each element in array A
    for (int i = 0; i < n; i++) {
        if (hmap.containsKey(A[i])) {
            // If the current element exists in the HashMap, increment its frequency
            int f = hmap.get(A[i]); // Get the frequency of the element
            hmap.put(A[i], f + 1); // Increment the frequency by 1 and update the HashMap
        } else {
            // If the current element is encountered for the first time, add it to the HashMap with frequency 1
            hmap.put(A[i], 1);
        }
    } 

    int count = 0; // Initialize the count of elements with frequency 1
    
    // Traverse the HashMap to count elements with frequency 1
    for (Map.Entry<Integer, Integer> e : hmap.entrySet()) {
        if (e.getValue() == 1) {
            // If the frequency of the element is 1, increment the count
            count++;
        }
    }

    return count; // Return the count of elements with frequency 1
   }
}
