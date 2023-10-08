

/*
   -> Given two integer arrays A and B of size N each which represent values and weights 
   associated with N items respectively.

-> Also given an integer C which represents knapsack capacity.

NOTE:

You can break an item for maximizing the total value of the knapsack

Problem Constraints
1 <= N <= 105

1 <= A[i], B[i] <= 103

1 <= C <= 103


 */
import java.util.*;
public class Fractionalknapsack
{
    public static void main(String[] args)
    {
        
       /*  int value [] ={60, 100, 120};
        int weight[] = {10, 20, 30};
        int W=50;*/

        int value [] ={10, 20, 30, 40};
        int weight[] = {12, 13, 15, 19};
        int W=10;


       // int value[] = {16,3,3,6,7,8,17,13,7};
       // int weight[] = {3,10,9,18,17,17,6,16,13};
       // int W=11;

        double ratio[][] = new double[value.length][2];
        //0th col -> idx; 1st col -> ratio

        for(int i=0;i<value.length;i++)
        {
            ratio[i][0] =i;  //idx
            ratio[i][1]= (double)value[i]/weight[i];  // value/weight
        }

         // sorted in ascending order
        Arrays.sort(ratio,Comparator.comparingDouble(o -> o[1]));

        int Capacity =W;
        int finalValue=0;

         // we want ratio in desc order as high value less weight
        for(int i=value.length-1;i>=0;i--)
        {
            int idx =(int)ratio[i][0];  // picking the item and storing its idx
            // can w include full item 
            if(Capacity >= weight[idx])
            {
                finalValue+=value[idx];  // will add full value 
                Capacity-=weight[idx]; // decrease that weight from capacity
            }
            else // include fractional value
            {
                finalValue+=ratio[i][1]*Capacity;  // so we cant take whole weight so will take partially 
                                                   //and multiply with remaining capacity
                Capacity=0;  // making capacity 0 as knapsack is full 
                break;  // and breaking the loop
            }
        }

        System.out.println("finalValue:"+ finalValue);
    }
}