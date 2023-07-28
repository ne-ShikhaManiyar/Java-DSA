/*
 Explanation :

1)The function solve takes an input array A and returns an array ans, 
where each element in ans represents the previous greater element for the 
corresponding element in the input array A.

2)It initializes an empty stack stk to keep track of indices and creates 
an array ans of the same length as A to store the previous greater elements.

3)The algorithm traverses the input array A from right to left. 
For each element A[i], it checks if it is greater than the element 
at the top of the stack (A[stk.peek()]). If it is, it means A[i] is 
the previous greater element for the element at the index stored in the 
stack top. So, it updates ans[stk.peek()] and pops the index from the stack.

4)After processing all the elements, there might be some indices 
left in the stack. This means there is no previous greater element for 
those elements. So, the algorithm sets the corresponding elements in ans to -1.

5)Finally, the function returns the ans array, which contains the
 previous greater elements for each element in the input array A.

The code efficiently finds the previous greater element for each element
 in the array using a stack-based approach.


 */



import java.util.Arrays;
import java.util.Stack;

public class previousgreaterelement {
    
    public static void main(String[] args) {
      
      
      int A[] = {10, 4, 2, 20, 40, 12, 30};
      // int A[] = {4,5,2,10};
      int ans[] = solve(A);
      String str = Arrays.toString(ans);
      System.out.print(str);
      
      
  }
  
  
  public static int[] solve(int A[])
{
    int n = A.length;
    int ans[] = new int[n]; // Create an array to store the previous greater element for each element in the input array A.
    Stack<Integer> stk = new Stack<>(); // Create an empty stack to keep track of indices.

    // Traverse the input array A from right to left.
    for (int i = n - 1; i >= 0; i--)
    {
        // For each element in A, check if it is greater than the element at the top of the stack.
        while (!stk.isEmpty() && A[i] > A[stk.peek()])
        {
            // If A[i] is greater, it becomes the previous greater element for the element at the index stored in the stack top.
            ans[stk.peek()] = A[i];
            stk.pop(); // Pop the index from the stack since it has been processed.
        }

        // Push the current index i into the stack for further comparisons.
        stk.push(i);
    }

    // At this point, there might be some indices left in the stack for which there is no previous greater element.
    // So, update ans accordingly for these elements.
    while (!stk.isEmpty())
    {
        ans[stk.peek()] = -1; // Set ans[stk.peek()] to -1 as there is no previous greater element for the element at stk.peek().
        stk.pop(); // Pop the index from the stack.
    }

    return ans; // Return the array containing the previous greater elements for each element in the input array A.
}

}
