/*  Given an sorted array fnd the floor of given value x

floor  greatest ele<=k in arr[]
 * 
 * floor : it is the smallest value near of the number
 *  eg : 14 is floor of 15
 * Hint : apply binary search and intialize ans with int min_value
 * and update ans in binary search and return the ans;
 * 
 */


package Questions;
import java.lang.*;
import java.util.*;

public class floorfunction {
    public static void main(String[] args)
    {
        int arr[] = { 1, 2, 4, 6, 10, 12, 14 };
         int x = 89;

         int res = Solve(arr, x);
        System.out.print("Floor of "+ " x " +" is: " + res);

    }

    public static int Solve(int A[],int x)
    {
        int n = A.length;
        int low =0;
        int high = n-1;
        int ans = Integer.MIN_VALUE;

        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(A[mid]==x)
            {
                ans = A[mid];
            }
            if(A[mid]<x)
            {
                ans=A[mid];
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return ans;
    }
}
