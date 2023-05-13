/* 
   Binary search must be applied when
   i)The data structure must be sorted.
  ii) Access to any element of the data structure takes constant time.
 * 
 *   https://www.geeksforgeeks.org/binary-search/
 * 
 * Time complexity of binary search : o(logn)
 * Space complexity of binary search :o(1)
 * if we use recursive approach then space complexity is o(logN)
 */


package Algorithms;
import java.lang.*;
import java.util.*;

public class binarySearch{

       public static void main(String[] args)
    {
         int A[] = {4,5,6,7,9,10};
         int x = 9;
         String str = Arrays.toString(A);
        int res = Solve(A, x);
        System.out.print(res);
        
    }

    public static int Solve(int A[], int x)
    {
        int n = A.length;
        int low = 0;
        int high = n-1;
     
      while(low<=high)
      {
        int mid = low+(high-low)/2;        //calculating mid like this to avoid the space complexity issue
        if(A[mid]==x)            // Check if x is present at mid
        {
            return mid;
        }

        if(A[mid]<x)           // If x greater than mid, discard left half
                                // and move to right
        {
            low=mid+1;
        }

        else{                  // If x is smaller than mid, discard right half
            high =mid-1;         // and move to left
        }
    }
       return -1;              // if we reach here, then element was
                                // not present
    }
}
