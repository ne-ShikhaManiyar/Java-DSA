/*
  Question : product of 3

-> Given an integer array A of size N.

->You have to find the product of the three largest integers in array A from range 1 to i,
 where i goes from 1 to N.

-> Return an array B where B[i] is the product of the largest 3 integers in range 1 to i in array A.
 If i < 3, then the integer at index i in B should be -1.

Problem Constraints
1 <= N <= 105
0 <= A[i] <= 103

Input Format
First and only argument is an integer array A.

Output Format
Return an integer array B. B[i] denotes the product of the largest 3 integers 
in range 1 to i in array A.

Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
Input 2:
 A = [10, 2, 13, 4]

Example Output
Output 1:
 [-1, -1, 6, 24, 60]

Output 2:
 [-1, -1, 260, 520]


Example Explanation
Explanation 1:

 For i = 1, ans = -1
 For i = 2, ans = -1
 For i = 3, ans = 1 * 2 * 3 = 6
 For i = 4, ans = 2 * 3 * 4 = 24
 For i = 5, ans = 3 * 4 * 5 = 60

 So, the output is [-1, -1, 6, 24, 60].
 
Explanation 2:

 For i = 1, ans = -1
 For i = 2, ans = -1
 For i = 3, ans = 10 * 2 * 13 = 260
 For i = 4, ans = 10 * 13 * 4 = 520

 So, the output is [-1, -1, 260, 520].


 */

package HeapQuestions;

import java.util.*;

public class Productof3 {

    public static void main(String[] args) {

    }

    public static int[] solve(int A[]) {
        int n = A.length;
        int ans[] = new int[n]; // Create an array to store the results

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        // Create a max heap (priority queue in reverse order) to maintain the largest
        // elements

        for (int i = 0; i < n; i++) {
            pq.add(A[i]); // Add the current element to the max heap

            if (pq.size() > 2) {
                // If there are at least 3 elements in the max heap, calculate the product of
                // the top 3 elements
                int p1 = pq.poll(); // Remove and retrieve the largest element
                int p2 = pq.poll(); // Remove and retrieve the second largest element
                int p3 = pq.poll(); // Remove and retrieve the third largest element

                ans[i] = p1 * p2 * p3; // Calculate the product
                pq.add(p1); // Add the elements back to the max heap
                pq.add(p2);
                pq.add(p3);
            } else {
                ans[i] = -1; // If there are less than 3 elements in the max heap, set the result to -1
            }
        }

        return ans; // Return the array of results
    }
}
/*
 * Explanation of code
 * 
 * 1)The solve function takes an integer array A as input.
 * 
 * 2)It creates an integer array ans to store the results, where each result
 * corresponds to a position
 * in the input array.
 * 
 * 3)It initializes a max heap (pq) in reverse order (so that the largest
 * elements are at the top).
 * 
 * 4)The loop iterates over each element in the input array A:
 * 
 * a. It adds the current element to the max heap.
 * 
 * b. If there are at least 3 elements in the max heap, it calculates the
 * product of the top 3 elements
 * and stores it in the ans array. It then adds the elements back to the max
 * heap.
 * 
 * c. If there are fewer than 3 elements in the max heap, it sets the result to
 * -1.
 * 
 * 5)Finally, it returns the ans array containing the results.
 * 
 * Time Complexity:
 * 
 * Adding an element to the max heap (pq) takes O(log n) time on average.
 * In the worst case, the loop runs for all elements in the input array, so the
 * overall time
 * complexity is O(n * log n).
 * 
 * Space Complexity:
 * 
 * The space complexity is O(n) because of the ans array, which stores n
 * results.
 * Additionally, the max heap (pq) can store at most 3 elements at any given
 * time.
 * Therefore, the space complexity related to the max heap is O(3) = O(1), which
 * is constant space.
 */