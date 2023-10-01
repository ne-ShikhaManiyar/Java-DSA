
/*

Question: Connect ropes

https://www.interviewbit.com/problems/connect-ropes/

*/
package HeapQuestions;
import java.util.*;

public class connectropes
{
    public static void main(String[] args)
    {

          int A[] = {5, 17, 100, 11};

          int result = solve(A);
          System.out.print(result);
    }

   public static int solve(int A[]) {
    // Get the length of the input array
    int n = A.length;
    
    // Create a priority queue to store elements in ascending order
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    // Add all elements of the input array to the priority queue
    for (int i = 0; i < n; i++) {
        pq.add(A[i]);
    }

    // Initialize a variable to store the final answer
    int ans = 0;

    // Repeat the following process until there is only one element left in the priority queue
    for (int i = 0; i < n - 1; i++) {
        // Extract the two smallest elements from the priority queue
        int first = pq.poll();
        int second = pq.poll();
        
        // Calculate the sum of the two smallest elements
        int sum = first + second;
        
        // Add the sum to the answer
        ans += sum;
        
        // Add the sum back to the priority queue for further processing
        pq.add(sum);
    }
    
    // Return the final answer
    return ans;
}
}

/*
   Explanation:

1)The solve function takes an integer array A as input.

2)It calculates the length of the array n.

3)It creates a priority queue pq, which is implemented as a min-heap. 
This means that the smallest element will always be at the front of the queue.

4)It adds all elements from the input array A into the priority queue. 
This step ensures that the elements are sorted in ascending order in the priority queue.

5)It initializes a variable ans to store the final answer, initially set to 0.

6)It enters a loop that continues until there is only one element left in the priority queue.
 Inside the loop:
a. It extracts the two smallest elements (first and second) from the priority queue using the poll method, 
which removes and returns the smallest element.
b. It calculates the sum of the two smallest elements and stores it in the variable sum.
c. It adds the sum to the ans variable.
d. It adds the sum back to the priority queue for further processing.

7)Finally, it returns the computed ans as the result.

Time Complexity:

The loop runs for n-1 iterations, where n is the length of the input array.
Inside the loop, the poll and add operations on the priority queue take O(log n) time.
Therefore, the overall time complexity of the code is O(n * log n).
Space Complexity:

The space complexity is O(n) because of the priority queue, which can store up to n elements.
 */