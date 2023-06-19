/*
Ques : Next Greater 
Problem Description

Given an array A, find the next greater element G[i] for every element A[i] in the array.
The next greater element for an element A[i] is the first greater element on the right side 
of A[i] in the array, A.

More formally:

G[i] for an element A[i] = an element A[j] such that 
    j is minimum possible AND 
    j > i AND
    A[j] > A[i]

Elements for which no greater element exists, consider the next greater element as -1.

Problem Constraints

1 <= |A| <= 105

1 <= A[i] <= 107


Input 1:
 A = [4, 5, 2, 10] 
Input 2:
 A = [3, 2, 1] 

Output 1:
 [5, 10, 10, -1] 
Output 2:
 [-1, -1, -1] 

Hints : Create a new array of given i/p array size
2)push the index of ele in stack rather than value and we re maintaining decreasing order by comparing
A[i](curr element) with top of stack 
3)if A[i] > top of stack pop out , if small push in stack 
4)if still elements in stack after iterating array return them as -1;




*/

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement
{

    public static void main(String[] args)
    {
          int arr[] = {4, 5, 2, 10};
        //  int arr[] = {4, 2, 1};
          int res[] = nextGreater(arr);
            String str = Arrays.toString(res);
        System.out.print(str);  
    }


    public static int[] nextGreater(int[] A) {
        int ans[] = new int[A.length];
        Stack<Integer> stk = new Stack<>();

// we are maintaining our order in decreasing order as we are comparing with top of the stack
        for (int i = 0; i < A.length; i++) {
            // Check if the current element is greater than the top of the stack
            while (!stk.isEmpty() && A[i] > A[stk.peek()]) {
                // If the current element is greater, update the answer for the top of the stack
                ans[stk.peek()] = A[i];
                stk.pop(); // Remove the top element from the stack
            }
            stk.push(i); // Push the index of the current element to the stack
        }

        // Process remaining elements in the stack (no greater element found)
        while (!stk.isEmpty()) {
            ans[stk.peek()] = -1; // Set answer for remaining elements to -1
            stk.pop(); // Remove the remaining elements from the stack
        }

        return ans; // Return the array containing the next greater elements
    }
}