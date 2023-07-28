/*
 Explanation:

 1)The function solve takes an integer array A as input and returns another 
 integer array ans containing the next smaller element for each element in the input array. 
 If there is no smaller element found for an element, the corresponding value in the output 
 array will be set to -1.

2)n is initialized to the length of the input array A[].

3)An array ans[] of size n is created to store the results.

$)A stack stk is created to keep track of the indices of elements from the input array.

5)The function loops through each element in the input array A[] using a for loop.

6)Inside the loop, it checks if the stack stk is not empty and 
if the current element A[i] is smaller than the element at the index
 represented by stk.peek() (the top of the stack). If yes, it means 
 the function has found the next smaller element for the element at stk.peek().

7)If a smaller element is found:

-> It sets the answer for the element at index stk.peek() to be the current element A[i].
-> It then removes the top element from the stack since the function has found the
 next smaller element for it.

8) Regardless of whether a smaller element is found or not, the 
function pushes the current index i onto the stack. This is because
 the function hasn't found the next smaller element for the current 
 element A[i] yet, and it will continue to compare it with upcoming elements.

9)After processing all elements in the input array, 
the function might have some elements left in the stack 
for which no smaller element was found. In such cases, it sets their answer to -1.

10)Finally, the function returns the ans[] array containing 
the next smaller elements for each element in the input array.
 */

import java.util.Arrays;
import java.util.Stack;
public class NextSmallerElement {

    public static void main(String[] args)
    {
        // int arr[] = {7,3,4,1,5,3};
        int arr[] = { 11, 13, 21, 3};
       
          int res[] = solve(arr);
            String str = Arrays.toString(res);
        System.out.print(str);  
    }

    public static int[] solve(int A[]) {
    int n = A.length;
    int ans[] = new int[n];  // Initialize the result array to store the next smaller element for each element in the input array
    Stack<Integer> stk = new Stack<>();  // Create a stack to keep track of indices of elements

    for (int i = 0; i < n; i++) {
        // Check if the current element is smaller than the element at the top of the stack
        while (!stk.isEmpty() && A[i] < A[stk.peek()]) {
            // If the current element is smaller, update the answer for the top of the stack
            ans[stk.peek()] = A[i];
            stk.pop();  // Remove the top element from the stack since we have found the next smaller element for it
        }
        stk.push(i);  // Push the index of the current element to the stack
    }

    // Process remaining elements in the stack (no smaller element found)
    while (!stk.isEmpty()) {
        ans[stk.peek()] = -1;  // Set answer for remaining elements to -1 (no smaller element found)
        stk.pop();  // Remove the remaining elements from the stack
    }

    return ans;  // Return the array containing the next smaller elements
}
}