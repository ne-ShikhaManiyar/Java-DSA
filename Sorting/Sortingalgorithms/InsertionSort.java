package Sortingalgorithms;

import java.util.Arrays;

public class InsertionSort {
    
    public static void main(String[] args) {

         int A[] = {8,4,1,5,9,2};
         InsertionSort(A);
         String str = Arrays.toString(A);
         System.out.print(str);

    }


    public static void InsertionSort(int A[])
    {
          int n = A.length;
          for(int i=1;i<n;i++)   //1st element with index 0 is always sorted so we start from i=1 
          {
            int temp = A[i];         // we store i=1 or other index ele which we compare in temp so we 
                                       //not loose it;
            int j=i-1;                     //  we here are comparing with previous index of i so i-1;
            while(j>=0 && A[j]>temp)         //and checking j index >0 and it is greater than temp
            {
                A[j+1] = A[j];                 // we move the greater element to right (like one shift)
                j--;
            }
            A[j+1] = temp;                      // and now the place is empty so we moved that emp variable 
          }
    }
}
