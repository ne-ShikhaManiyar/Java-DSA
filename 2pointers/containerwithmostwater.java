/*
   Question : Container with most water

   https://www.interviewbit.com/problems/container-with-most-water/  // interviewbit

   https://leetcode.com/problems/container-with-most-water/   // leetcode


 */



public class containerwithmostwater

{

    public static void main(String [] args)
    {
     
       // int A[] = {1,8,6,2,5,4,8,3,7};
      // int A[] = {1, 5, 4, 3};

      int A[] = {1,1};
        int res = containerwater(A);
        System.out.print(res);
    }

    public static int containerwater(int A[]) {
        // Get the length of the input array A
        int n = A.length;
        
        // Initialize two pointers, i and j, at the beginning and end of the array
        int i = 0;
        int j = n - 1;
        
        // Initialize a variable to store the maximum water capacity
        int water = 0;
        
        // Check if the array is empty
        if (n == 0) {
            // If the array is empty, return 1 (or any appropriate value based on your requirements)
            return 1;
        }
        
        // Use a two-pointer approach to find the maximum water capacity
        while (i < j) {
            // Calculate the width of the container
            int width = j - i;
            
            // Calculate the height of the container as the minimum of the heights at positions i and j
            int height = Math.min(A[i], A[j]);
            
            // Calculate the capacity of the container
            int capacity = height * width;
            
            // Update the maximum water capacity if the current capacity is greater
            if (capacity > water) {
                water = capacity;
            }
            
            // Move the pointer with the smaller height towards the other pointer
            if (A[i] < A[j]) {
                i++;
            } else {
                j--;
            }
        }
        
        // Return the maximum water capacity found
        return water;
    }
}

/*

TC: o(n) as we iterate on whole array
SC:o(1); 

Pseudocode 

1) declare 2 pointers i & j 
2)intialse i =0 & j=n-1;
3)edge case if n==1 return 0;
4)iterate on i/p array while(i<j)
5) calculate width = j-i
6)calculate heigth =Min of A[i], A[j]
7) capacity = width * height
8) if  A[i]<A[j] move i++
9) else move j--


 */