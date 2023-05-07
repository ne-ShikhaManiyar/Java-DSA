/* Ques: Given NxM a 2d matrix print its boundary in clockwise direction

 * problem constraints: 
 * 1<=N,M<=1000;
 * 1<=A[i][j]<=1000000000
 * 
 * i/p 1: 3*3  [ 1 2 3
 *              4 5 6
 *               7 8 9 ]
 * 
 * o/p 1: 1 2 3 6 9 8 7 4
 *         
 * Hint : loop on the matrix and keep the edge case in mind if matrix 
 *         is 1x1 then n==1 {mat[i][j]}
 *  
 * we can solve using normal 2d array or 2d arraylist too
 * 

 */


package Questions;

import java.lang.*;
import java.util.*;
public class Boundaryinclockwisedirection {

    public static void main(String[]args)
    {
     
        /*below is solution of 2d matrix using array */
        Scanner src = new Scanner(System.in);
        int n=src.nextInt();
        int m = src.nextInt();
        int mat [][] = new int[n][m];

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                mat[i][j] = src.nextInt();
            }
        }

        int i=0;
        int j=0;

        for(int k=1;k<m;k++)
        {
               System.out.print(mat[i][j]+" ");
               j++;
        }
        for(int k=1;k<n;k++)
        {
               System.out.print(mat[i][j]+" ");
               i++;
        }
        for(int k=1;k<m;k++)
        {
               System.out.print(mat[i][j]+" ");
               j--;
        }
        for(int k=1;k<m;k++)
        {
               System.out.print(mat[i][j]+" ");
               i--;
        }

        if(n==1)
        {
            System.out.print(mat[i][j]);
        }




  /*->     below is solution using 2d arraylist 

        public class Solution {
    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
        
        int N = A.size(), M=A.get(0).size();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int i=0,j=0;
        for(int k=1;k<M;k++)
        {
            ans.add(A.get(i).get(j));
            j++;
        }
         for(int k=1;k<N;k++)
        {
            ans.add(A.get(i).get(j));
            i++;
        }
         for(int k=1;k<M;k++)
        {
            ans.add(A.get(i).get(j));
            j--;
        }
        
         for(int k=1;k<N;k++)
        {
            ans.add(A.get(i).get(j));
            i--;
        }
        
        if(N==1)
        {
            return ans;
        }
        return ans;
    }
}







         */
    
}

}
