package Sortingalgorithms;
import java.io.*; 
import java.util.*;
public class QuickSort {
    public static void main(String[] args) {
        int A[] = {33, 11 ,1, 9,2,-9};
                 int l=0;
                 int n = A.length;
                 QuickSort(A,l,n-1);
                    
                // return A;
      
                 String stringArr = Arrays.toString(A); 
        
              // print the String representation 
              System.out.print("Array: " + stringArr); 
          }

          public static void QuickSort( int A[],int l, int h)
          {
            if(l<h)  //base condition
    {
      int pi = partition(A,l,h);  //partition function where all work
                                   //of quick sort is performed
                                   
      QuickSort(A,l,pi-1);        //dividing array in 2 parts
                                   // and applying recursive call
       
      QuickSort(A,pi+1,h);         //dividing array in 2 parts
                                   // and applying recursive call
      
    }
          }
          
          public static int partition(int A[],int l, int h)
          {
            
           //pivot : it means that element whose at first or last index in
              //unsorted array but after sorting ele on left are 
               //and ele on right are greater
    
    int pivot = A[l];              //taking out pivot as low ele of array
    int i =l;                      //taking out a pointers to perform 

    int j=h;                      //taking out a pointers to perform 
    
    while(i<j)                  //base condition of QuickSort
    {
    while(A[i]<=pivot && i<h)   // comparing the ith pointer with pivot if less than pivot 
     i++;                              //move on to next ele
    
    
    while(A[j]>= pivot && j>l)    // comparing the jth pointer with pivot if greater than pivot 
      j--;                                //move on to next ele(this loop is from backside)
    
    
    if(i<j)                         // if any point i is less than j then swap (A,i,j)
    {
      int temp = A[i];
      A[i] = A[j];
      A[j] = temp;
      
    }
    }
    
    if(j!=l)                             //if any point j is not equal to low swap
    {
      int temp = A[j];
      A[j] = A[l];
      A[l] = temp;
      
    }
    
    return j;
    
}    
}
