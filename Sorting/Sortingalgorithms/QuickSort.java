/*
 
https://www.geeksforgeeks.org/quick-sort-vs-merge-sort/

https://www.geeksforgeeks.org/when-does-the-worst-case-of-quicksort-occur/

Time Complexity:
Worse case: O(n2)
When the array is sorted and we choose the leftmost element as pivot,
 or the array is reverse-sorted and we choose the rightmost element as pivot, 
 the time complexity becomes quadratic since partitioning the array results 
 in highly unbalanced subarrays in such cases.

Average case and best case: O(n log n)
The best case for quick-sort happens when we 
successfully pick the median element for partitioning every time. 
Such partitioning allows us to divide the array in half every time. 


*Space Complexity

Worst case: O(n)
This happens when the pivot element is the largest or smallest
 element of the array in every recursive call. The size of the 
 subarray after partitioning will be n-1 and 1. In this case,
  the size of the recursive tree will be n. 

Best case: O(log n)
This happens when the pivot element’s correct position in the partitioned array
 is in the middle every time. The size of subarrays will be 
 half the size of the original array. In this case, the recursive tree’s size will be O(log n). 

 */


import java.util.*;
public class QuickSort {
    public static void main(String[] args) {
        int A[] = {33, 11 ,1, 9,2,-9};
                 int l=0;
                 int n = A.length;
                 QuickSort(A,l,n-1);
                    
                // return A;
      
                 String stringArr = Arrays.toString(A); 
        
              // print the String representation 
              System.out.print("Array: " + stringArr); 
          }

          public static void QuickSort( int A[],int l, int h)
          {
            if(l<h)  //base condition
    {
      int pi = partition(A,l,h);  //partition function where all work
                                   //of quick sort is performed
                                   
      QuickSort(A,l,pi-1);        //dividing array in 2 parts
                                   // and applying recursive call
       
      QuickSort(A,pi+1,h);         //dividing array in 2 parts
                                   // and applying recursive call
      
    }
          }
          
          public static int partition(int A[],int l, int h)
          {
            
           //pivot : it means that element whose at first or last index in
              //unsorted array but after sorting ele on left are 
               //and ele on right are greater
    
// in this case we choose pivot as lower index

    int pivot = A[l];              //taking out pivot as low ele of array
    int i =l;                     // Initialize the pointer i to the low index

    int j=h;                      // Initialize the pointer j to the high index
    
    while(i<j)                  //base condition of QuickSort
    {
    while(A[i]<=pivot && i<h )   /// Loop to find an element greater than the pivot from the left side
     i++;                             // Move the i pointer to the right
    
    
    while(A[j]>= pivot && j >l )    // Loop to find an element smaller than the pivot from the right side
      j--;                                // Move the j pointer to the left
    
    
    if(i<j)                         // if any point i is less than j then swap (A,i,j)
    {
      int temp = A[i];
      A[i] = A[j];
      A[j] = temp;
      
    }
    }
    
    if(j!=l)                          // If the j pointer did not reach the low index
    {
      int temp = A[j];    // Swap the pivot (A[l]) with the element at position j
      A[j] = A[l];
      A[l] = temp;
      
    }
    
    return j; // Return the new position of the pivot after partitioning
    
}    
}

