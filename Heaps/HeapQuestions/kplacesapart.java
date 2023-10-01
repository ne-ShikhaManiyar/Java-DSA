/*
  Problem Description
N people having different priorities are standing in a queue.

The queue follows the property that each person is standing at most B places away from its position in the sorted queue.

Your task is to sort the queue in the increasing order of priorities.

NOTE:

No two persons can have the same priority.
Use the property of the queue to sort the queue with complexity O(NlogB).


Problem Constraints
1 <= N <= 100000
0 <= B <= N



Input Format
The first argument is an integer array A representing the priorities and initial order of N persons.
The second argument is an integer B.



Output Format
Return an integer array representing the sorted queue.

Example Input
Input 1:

 A = [1, 40, 2, 3]
 B = 2
Input 2:

 A = [2, 1, 17, 10, 21, 95]
 B = 1

Example Output
Output 1:

 [1, 2, 3, 40]
Output 2:
 [1, 2, 10, 17, 21, 95]
Example Explanation
Explanation 1:

 Given array A = [1, 40, 2, 3]
 After sorting, A = [1, 2, 3, 40].
 We can see that difference between initial position of elements amd the final position <= 2.
Explanation 2:

 After sorting, the array becomes [1, 2, 10, 17, 21, 95].

 */


package HeapQuestions;
import java.util.*;
public class kplacesapart {
    
    public static void main(String[] args) {
        int A[] = {2, 1, 17, 10, 21, 95};
        int B = 1;
    
        // Call the solve function and print the result
        int[] result = solve(A, B);
        System.out.print("Sorted Array: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
    
    public static int[] solve(int A[], int B) {
        int n = A.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int ans[] = new int[n];
    
        // Add elements from A to the min heap (pq)
        for (int i = 0; i < n; i++) {
            pq.add(A[i]);
        }
    
        // Extract elements from the min heap in ascending order and store in ans[]
        int i = 0;
        while (!pq.isEmpty()) {
            ans[i] = pq.peek();
            pq.poll();
            i++;
        }
    
        return ans; // Return the sorted array
    }
}


/*
  Explanation of code : 

1)The solve function takes an integer array A and an integer B as parameters.

2)nside the solve function, a min heap (priority queue) pq is created to store the elements in 
ascending order.

3)The elements of the input array A are added to the min heap pq, which automatically sorts 
them in ascending order.

4)The sorted elements are extracted from the min heap, and the results are stored in the ans array.

5)Finally, the ans array containing the sorted elements is returned.

Time Complexity:

Adding each element to the min heap (pq) takes O(log n) time, and this is done for all elements, so the overall time complexity is O(n * log n).
Space Complexity:

The space complexity is O(n) because of the ans array that stores n elements.
Additionally, the min heap (pq) stores all n elements, so it also contributes O(n) to the space complexity.
 */