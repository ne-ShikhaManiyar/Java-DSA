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

Hint : Return the largest minimum distance possible among the cows.
and use a helper function which consist of cows, arr and mindistance which we need to find out

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
     Arrays.sort(A);  //sort the array first it would be easy to find distance
     int low =1;    //low could be at 1st index if A[1 or 2 size] so cow1 would be at 1stindex
     int high= A[n-1]-A[0];   //high is always the distance we need to find out between low-high
     int ans=0;     // ans to return 
     while(low<=high)
     {
        int mid =low+(high-low)/2;
        if(isCheck(B,A,mid))  //helper function consits of cows, array and mindistance between 2 cows
        {
            ans=mid;
            low=mid+1;
        }
        else{high =mid-1;}
     }
     return ans;
   }
    static boolean isCheck(int B, int A[],int mindistance)  //helper function consits of cows, array and mindistance between 2 cows
    {
           int n = A.length;
           int cowsplaced =1;  //how many cows is placed uptil now as we placed 1 cow at indx[1] and array 
                                  //is sorted 
           int previousplaced = A[0];   // previous cow placed is imp so from ther we can calculate now 
                                         // cow place distance 
           for(int i=1;i<n;i++)
           {
           if(A[i]-previousplaced>=mindistance)  //always minus the distane between cows 
           {
                 cowsplaced++;                    //update has next cows will be placed 
                 previousplaced= A[i];              // and it will update new cow placed position in array
           }
           
        }
        return cowsplaced>=B;          // need to return the largest minimum distance possible among the cows.
    }
}
