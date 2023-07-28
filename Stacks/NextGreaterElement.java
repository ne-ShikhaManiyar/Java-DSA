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


/*

 brute force of Next Greater Element

int res[] = new int [arr.length];
 for(int i=0;i<n;i++)
 {
    for(int j=i+1;j<n;j++)
    {
        res[i]=-1;
        if(arr[j]>a[i])
        {
            res[i]=arr[j];
            break;
        }
    }
 }



 */


/*
 
Explanation of the below code

1)Initialize the necessary variables and data structures:

-> ans[]: An array with the same length as the input array A[].
 It will store the next greater element for each element in A[].
-> stk: A stack data structure to keep track of the indices of elements in the input array A[].


2)Loop through each element in the input array A[]:

-> The loop starts from index 0 and goes up to the last element (index A.length - 1) in the array.


3)Inside the loop, the code checks if the stack stk is not empty and if the 
current element A[i] is greater than the element at the index represented by stk.peek() 
(the top of the stack). If yes, it means the code has found the next greater 
element for the element at stk.peek().

4)If the code finds a greater element:

-> It sets the answer for the element at index stk.peek() to be the current element A[i].
-> It then removes the top element from the stack since the code has found the 
next greater element for it.

5)Regardless of whether a greater element is found or not, the code pushes
 the current index i onto the stack. This is because the code hasn't found 
 the next greater element for the current element A[i] yet, and it will continue to 
 compare it with upcoming elements.

6)After processing all elements in the input array,
 the code might have some elements left in the stack for 
 which no greater element was found. In such cases, 
 the code sets their answer to -1.

7)The code returns the ans[] array containing the next greater elements 
for each element in the input array.


 */

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement
{

    public static void main(String[] args)
    {
         // int arr[] = {4, 5, 2, 10};
        //  int arr[] = {4, 2, 1};
         int arr[] = {10,7,6,4,2,8,4,5,15,14,13};
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


/*
 
Approach 2: for next greater ele, iterating from reverse

 int res[] = new int[A.length];
  Stack<Integer> stk = new Stack<>();
res[n-1]=-1;
stk.push(A[n-1]);
for(i=n-2;i>=0;i--)
{
    while(stk.peek() <A[i] && stk.size()>0)
    {
        stk.pop();
    }

    if(stk.size()==0)
    {
        res[i]=-1;
    }
    else
    {
        res[i]= stk.peek();
    }
    stk.push(A[i]);
}

TC :o(n)
SC:o(n)

 */