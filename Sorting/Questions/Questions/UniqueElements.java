/*
Problem Description

You are given an array A of N elements. You have to make all elements unique. To do so, in one step you can increase any number by one.
Find the minimum number of steps.

Problem Constraints
1 <= N <= 105
1 <= A[i] <= 109

Output Format:
Return the minimum number of steps required to make all elements unique.

Input 1:
 A = [1, 1, 3]
 o/p:1 

//int A[] = {1,2,3,4};
o/p2 : 0
        
int A[] = {1,2,3,4,6,6,6,7,6};
o/p:3

Hint : sort the array first
if (A[i]>=A[i+1]) then count+=A[i]-A[i+1]+1 and A[i]=A[i+1]+1;

*/
package Questions;
import java.util.Arrays;
public class UniqueElements{

    public static void main(String[] args) {

        //int A[] = {1,2,3,4};
        int A[] = {1,2,3,4,6,6,6,7,6};
        int res = solve(A);
        System.out.print(res);
    }

    public static int solve(int A[])
    {
        int n=A.length;
        int steps=0;
        Arrays.sort(A);       // first will sort the array so we can come to know how 
                                // many element needs to make unique
        for(int i=0;i<n-1;i++)
        {
            if(A[i]>=A[i+1])               //if(current ele >= next ele then steps+=A-B+1)
            {
                steps+=(A[i]-A[i+1])+1;         //and increasing value of the similar ele 
                A[i] = A[i+1]+1;
            }
        }
         return steps;
    }

}