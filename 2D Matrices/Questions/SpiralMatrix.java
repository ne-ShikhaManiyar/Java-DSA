package Questions;
/* Question : Spiral matrix 2
 * 
 * Problem Description
Given an integer matrix A of size NxN. Print the matrix in spiral form starting from A[0][0] in the first row.
For example : Given matrix of 2x2
1 2
3 4
You should print => 1 2 4 3

Problem Constraints
1 <= N <= 1000
1 <= A[i] <= 109

Example Input
Input 1:
2
5 2
6 8 
Input 2:
3
8 2 5 
2 9 6 
5 8 7

Output 1:
5 2 8 6 
Output 2:
8 2 5 6 7 8 5 2 9


Logic : use a loop to form a spiral 
take 2 variable i & j and loop it over them
Do n=n-2 bcoz after 1st iteration in matrix outer boundary will be completed 
matrix will squeeze down and take n-1 elements but n-2 is total size 
remember array logic of length;

Edge case :If(n==1) {sop mat[i][j]} bcoz if 1x1 matrix is their so 

 * 
 */


import java.lang.*;
import java.util.*;

public class SpiralMatrix{

    public static void main(String[]args)
    {
        
        Scanner src = new Scanner(System.in);
        int n = src.nextInt();
         int mat[][] = new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
               mat[i][j] = src.nextInt();
            }
        }

        int i=0;
        int j=0;

        while(n>1)
        {
            for(int k=0;k<n-1;k++)
            {
                System.out.print(mat[i][j]+" ");
                j++;
            }

            for(int k=0;k<n-1;k++)
            {
                System.out.print(mat[i][j]+" ");
                i++;
            }

            for(int k=0;k<n-1;k++)
            {
                System.out.print(mat[i][j]+" ");
                j--;
            }

            for(int k=0;k<n-1;k++)
            {
                System.out.print(mat[i][j]+" ");
                i--;
            }
            i++;j++;
            n=n-2;

            if(n==1)
            {
                System.out.print(mat[i][j]);
            }

        }
    }
}