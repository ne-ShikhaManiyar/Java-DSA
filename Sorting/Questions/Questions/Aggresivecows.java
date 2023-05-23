/*
Problem Description
Farmer John has built a new long barn with N stalls. Given an array of integers A of size N 
where each element of the array represents the location of the stall and an integer B
 which represents the number of cows.

His cows don't like this barn layout and become aggressive towards each
 other once put into a stall. To prevent the cows from hurting each other, 
 John wants to assign the cows to the stalls, such that the minimum distance 
 between any two of them is as large as possible. What is the largest minimum distance?

Problem Constraints
2 <= N <= 100000
0 <= A[i] <= 109
2 <= B <= N

Input 1:

A = [1, 2, 3, 4, 5]
B = 3
o/p -> 2
Input 2:

A = [1, 2]
B = 2
o/p-> 1

A=[1,2,4,8,9]
B=3
o/p:2

*/

import java.util.Arrays;

public class Aggresivecows {

    public static void main(String[] args)
    {
           int A[] = {1,2,4,8,9};
        //  int A[] = {1,2,3,4,5};
          int B= 3;
            int res = solve(A,B);
           // String str = Arrays.toString(A);
            System.out.print(res);
    }

   public static int solve(int A[],int B)
   {
    int  n = A.length;
     Arrays.sort(A);
     int low =1;
     int high= A[n-1]-A[0];
     int ans=0;
     while(low<=high)
     {
        int mid =low+(high-low)/2;
        if(isCheck(B,A,mid))
        {
            ans=mid;
            low=mid+1;
        }
        else{high =mid-1;}
     }
     return ans;
   }
    static boolean isCheck(int B, int A[],int mindistance)
    {
           int n = A.length;
           int cowsplaced =1;
           int previousplaced = A[0];
           for(int i=1;i<n;i++)
           {
           if(A[i]-previousplaced>=mindistance)
           {
                 cowsplaced++;
                 previousplaced= A[i];          
           }
           
        }
        return cowsplaced>=B;
    }
}
