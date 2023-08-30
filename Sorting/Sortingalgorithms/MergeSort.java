
/*
Worst case = Average Case = Best Case = O(n log n) : TC

Merge sort performs the same number of operations for any input array of a given size.

In this algorithm, we keep dividing the array into two subarrays 
recursively which will create O(log n) rows where each element is 
present in each row exactly once. 

For each row, it takes O(n) time to merge every pair of subarrays. 
So the overall time complexity becomes O(n log n).
  
Space Complexity: 
Since we use an auxiliary array of size at most n to 
store the merged subarray, the space complexity is O(n).
 */


import java.util.*;
public class MergeSort {
    public static void main(String[] args) {
  int A[] = {33, 11 ,1, 9,2};
           int s=0;
           int n = A.length;
           Divide(A,s,n-1);
          // return A;

           String stringArr = Arrays.toString(A); 
  
        // print the String representation 
        System.out.print("Array: " + stringArr); 
    }
    
     public static void Divide(int A[], int s, int e)
     {
       if(s>=e)   // base condition is if A[s] > A[e]
                    // or we done equal bcoz if their is single ele in array A[s]=A[e];
       {
         return;
       }
       
       int mid =s+(e-s)/2; //usually formula is e-s/2 but we using it to solve 
                           // space complexity problems on different problems
       
       Divide(A,s, mid);  // using recursion dividing array in 2 parts start to mid
       Divide(A,mid+1,e);  // using recursion dividing array in 2 parts  mid+1 to end
       Conquer(A,s,mid,e); // after dividing we sort them and merge them 
     }
   
    public static int[] Conquer(int A[], int s, int mid ,int e)
     {
       int C[] = new int[e-s+1];  // creating new array to sort array and
                                  //by adding +1 bcoz array starts from 0
                                  // and size is 1 less than the n;
       
       int p1 =s;  // after breaking array in 2 parts so p1 for 1stpart
                                 
       int p2 =mid+1; // after breaking array in 2 parts so p2 for 2ndpart
                     
        int p3=0; // for new array C 
        
        while(p1<=mid && p2<=e) // sorting both the breaked arrays
        {
          if(A[p1]<= A[p2])
          {
            C[p3] = A[p1];
            p1++;
            p3++;
            
          }
          else
          {
            C[p3] = A[p2];
            p2++;
            p3++;
          }
        }
        
        while(p1<=mid) // copying the remaining ele of A[p1] in C[]
        {
          C[p3] = A[p1];
          p1++;
          p3++;
        }
        
        while(p2<=e)   // copying the remaining ele of A[p2] in C[]
        {
          C[p3] = A[p2];
          p2++;
          p3++;
        }
        
        for(int i=0;i<C.length;i++)
        {
          A[i+s] = C[i]; //copying sorted ele from new array to original arr
                         //  A[i + s] represents the position where that element 
                           //should be inserted back into the original array.
        }
   
        return A;
     }
}