/*
 
Question :  ShaggyandDistances

Problem Description
Shaggy has an array A consisting of N elements. We call a pair of distinct indices
 in that array a special if elements at those indices in the array are equal.

Shaggy wants you to find a special pair such that the distance between that pair is minimum. 
Distance between two indices is defined as |i-j|. If there is no special pair in the array, 
then return -1.


Problem Constraints
1 <= |A| <= 105

Input Format
The first and only argument is an integer array A.
Output Format
Return one integer corresponding to the minimum possible distance between a special pair.


Example Input
Input 1:

A = [7, 1, 3, 4, 1, 7]
Input 2:
A = [1, 1]
Example Output
Output 1:3
Output 2: 1
Example Explanation
Explanation 1:

Here we have 2 options:
1. A[1] and A[4] are both 1 so (1,4) is a special pair and |1-4|=3.
2. A[0] and A[5] are both 7 so (0,5) is a special pair and |0-5|=5.
Therefore the minimum possible distance is 3. 
Explanation 2:

Only possibility is choosing A[1] and A[2].






 */


import java.util.*;
public class ShaggyandDistances {
    
    public static void main(String[] args)
    {
        int A[] = {7, 1, 3, 4, 1, 7};
        String str = Arrays.toString(A);
        int res = solve(A);
        System.out.print(res);
    }

   
        public static int solve(int[] A) {
            int n = A.length;
            
            // Initialize the minimum distance as the maximum possible value
            int min = Integer.MAX_VALUE;
            
            // Create a HashMap to store the elements of the array and their indices
            HashMap<Integer, Integer> hm = new HashMap<>();
            
            // Iterate over each element in the array A
            for (int i = 0; i < n; i++) {
                if (hm.containsKey(A[i])) {
                    // If the element already exists in the HashMap, calculate the distance between the current index and the previous index
                    int x = hm.get(A[i]); // Previous index
                    int y = i; // Current index
                    int dist = y - x; // Calculate the distance
                    
                    // Check if the calculated distance is smaller than the current minimum distance
                    if (min > dist) {
                        // If yes, update the minimum distance
                        min = dist;
                    }
                    
                    // Update the HashMap with the current index as the new value for the element
                    hm.put(A[i], i);
                } else {
                    // If the element is encountered for the first time, add it to the HashMap with its index
                    hm.put(A[i], i);
                }
            }
            
            // Check if a valid minimum distance is found
            if (min == Integer.MAX_VALUE) {
                // If not, return -1
                return -1;
            }
            
            // Return the minimum distance
            return min;
        }
    }

