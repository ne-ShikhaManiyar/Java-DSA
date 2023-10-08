/*
     https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1           gfg 

 */

import java.util.Arrays;
import java.util.Comparator;

public class Nmeetings {

    public static void main(String[] args)
    {
        //int start[] = {1,3,0,5,8,5};
        //int end [] = {2,4,6,7,9,9};

        int start[] = {10, 12, 20};
        int end[] = {20, 25, 30};

        int mat[][] = new int[start.length][3];

        for(int i=0;i<start.length;i++)
        {
            mat[i][0]=i;
            mat[i][1]=start[i];
            mat[i][2]= end[i];
        }

        Arrays.sort(mat,Comparator.comparingDouble(o->o[2]));

        int count = 1;
        int endmeetings = end[0];

        for(int i=1;i<start.length;i++)
        {
            if(mat[i][1] > endmeetings)
            {
                count++;
                endmeetings = mat[i][2];
            }
        }

        System.out.println("Total meetings:"+ count);

    }
    
}


/*
  -> Same approach as activity problem

 */