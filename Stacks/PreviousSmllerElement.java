/*

Given an array A, find the nearest smaller element G[i] for
 every element A[i] in the array such that the element has an index smaller than i.

More formally,

G[i] for an element A[i] = an element A[j] such that

j is maximum possible AND

j < i AND

A[j] < A[i]

Elements for which no smaller element exist, consider the next smaller element as -1.



Problem Constraints
1 <= |A| <= 100000

-109 <= A[i] <= 109



Input Format
The only argument given is integer array A.



Output Format
Return the integar array G such that G[i] contains the
 nearest smaller number than A[i]. If no such element occurs G[i] should be -1.



Example Input
Input 1:

 A = [4, 5, 2, 10, 8]
Input 2:

 A = [3, 2, 1]


Example Output
Output 1:

 [-1, 4, -1, 2, 2]
Output 2:

 [-1, -1, -1]


Example Explanation
Explanation 1:

index 1: No element less than 4 in left of 4, G[1] = -1
index 2: A[1] is only element less than A[2], G[2] = A[1]
index 3: No element less than 2 in left of 2, G[3] = -1
index 4: A[3] is nearest element which is less than A[4], G[4] = A[3]
index 4: A[3] is nearest element which is less than A[5], G[5] = A[3]
Explanation 2:

index 1: No element less than 3 in left of 3, G[1] = -1
index 2: No element less than 2 in left of 2, G[2] = -1
index 3: No element less than 1 in left of 1, G[3] = -1




 */


 /*
  
1)The function solve takes an input array A and returns an array ans, 
where each element in ans represents the previous smaller element for 
the corresponding element in the input array A.

2)It initializes an empty stack stk to keep track of indices and creates an 
array ans of the same length as A to store the previous smaller elements.

3)The algorithm traverses the input array A from right to left. 
For each element A[i], it checks if it is smaller than the element
 at the top of the stack (A[stk.peek()]). If it is, it means A[i] 
 is the previous smaller element for the element at the index stored
  in the stack top. So, it updates ans[stk.peek()] and pops the index from the stack.

4)After processing all the elements, there might be
 some indices left in the stack. This means there is 
 no previous smaller element for those elements. So, 
 the algorithm sets the corresponding elements in ans to -1.

5)Finally, the function returns the ans array, which contains the 
previous smaller elements for each element in the input array A.

6)The code efficiently finds the previous smaller element for each element 
in the array using a stack-based approach.


  */


import java.util.Arrays;
import java.util.Stack;

public class PreviousSmllerElement {

    public static void main(String[] args) {
      
      
      int A[] = {2, 5, 3, 7, 8, 1, 9};
      // 
      // -1 10
      int ans[] = solve(A);
      String str = Arrays.toString(ans);
      System.out.print(str);
      
      
  }
  
  public static int[] solve(int A[]) {
    int n = A.length;
    int ans[] = new int[n]; // Create an array to store the previous smaller element for each element in the input array A.
    Stack<Integer> stk = new Stack<>(); // Create an empty stack to keep track of indices.

    // Traverse the input array A from right to left.
    for (int i = n - 1; i >= 0; i--) {
        // For each element in A, check if it is smaller than the element at the top of the stack.
        while (!stk.isEmpty() && A[i] < A[stk.peek()]) {
            // If A[i] is smaller, it becomes the previous smaller element for the element at the index stored in the stack top.
            ans[stk.peek()] = A[i];
            stk.pop(); // Pop the index from the stack since it has been processed.
        }

        // Push the current index i into the stack for further comparisons.
        stk.push(i);
    }

    // At this point, there might be some indices left in the stack for which there is no previous smaller element.
    // So, update ans accordingly for these elements.
    while (!stk.isEmpty()) {
        ans[stk.peek()] = -1; // Set ans[stk.peek()] to -1 as there is no previous smaller element for the element at stk.peek().
        stk.pop(); // Pop the index from the stack.
    }

    return ans; // Return the array containing the previous smaller elements for each element in the input array A.
}

    
}
