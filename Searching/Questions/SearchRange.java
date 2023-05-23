/*Search for a Range

Given a sorted array of integers A (0-indexed) of size N, find the starting and the ending 
position of a given integer B in array A.

Return an array of size 2, such that 
          First element = Starting position of B in A
          Second element = Ending position of B in A.
If B is not found in A, return [-1, -1].

Note : 
Your algorithm's runtime complexity must be in the order of O(log n).


Problem Constraints
1 <= N <= 106
1 <= A[i], B <= 109

Return the starting and ending positions of B in A as a 2-element array. 
If B is not found in A, return [-1, -1].

Input 1:

 A = [5, 7, 7, 8, 8, 10]
 B = 8
Input 2:

 A = [5, 17, 100, 111]
 B = 3


Example Output
Output 1:

 [3, 4]
Output 2:

 [-1, -1]

Hint : use binary search twice for first and last ocuurence 



*/




import java.lang.*;
import java.util.*;
public class SearchRange {
    public static void main(String[] args)
    {
       //  int A[] = {5, 7, 7, 8, 8, 10};
       int A[] = {-5,-5,-3,0,0,1,1,1,2,5,5,5,5,5,8,10,10,15,15};
       int x = 5;
         int ans[]= solve(A, x);
        String str = Arrays.toString(ans);
        System.out.print(str);
        
    }

    public static int[] solve(int A[],int B)
    {
        int n=A.length;
        int low=0;
        int high=n-1;
        int ans[] = new int[2];//in ques it is given to create size of 2 arr

        int x=0;   // pointers for traversing the 0th indx
        int y=0;   // pointers for traversing the 1st indx

        while(low<=high)  //for first occurence of ele  
        {
            int mid = low+(high-low)/2;
            if(A[mid]==B)
            {
                x=mid;     // i) mid can be our target 
                high=mid-1;   //or their can be more occurennce on left side so we can tell them as first occur
            }

            else if(A[mid]<B)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
           low =0;  // reintializing the low for last occurence
           high = n-1;  // reintializing the high for last occurence
        while(low<=high)  //for last occurence of ele  
        {
            int mid = low+(high-low)/2;
            if(A[mid]==B)
            {
                y=mid;     // i) mid can be our target 
                low=mid+1;   //or their can be more occurennce on right side so we can tell them 
                                  //as last occur
            }

            else if(A[mid]<B)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }

        ans[0]=x;
        ans[1]=y;

        if(ans[0]==0 && ans[0]==0 && A.length!=1)
        {
            ans[0]=-1;
            ans[1] =-1;
        }
          return ans;
    }
}
