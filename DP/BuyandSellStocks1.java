/*
    https://leetcode.com/problems/best-time-to-buy-and-sell-stock/ (leetcode 121)
 */

import java.util.*;

public class BuyandSellStocks1 {
    
    public static void main(String [] args)
    {
      // int A[] = {7,1,5,3,6,4};
      int A[] = {7,6,4,3,1};
       int res = solve(A);
       System.out.print(res);
    }

    /*
    TC: o(n^2)
    SC:o(1)
Brute force : 
It would be to consider every day as a possibilty and iterate over 
the remaining array to find out the max_profit we can get. We can only sell
 if the selling price is greater than cost price,an additional check for that is prices[j] > prices[i].

Code :

 int maxProfit(int prices[]) {
        int n=prices.size(), maxprofit = 0;
        
       for(int i=0;i<n;i++){
           for(int j=i+1;j<n;j++){
               if(prices[j]>prices[i]){
                   int diff=prices[j] - prices[i];
                   if(diff>maxprofit){
                        maxprofit=diff;
                   }
               }
           }
       }
        return maxprofit;
    }
     */

     /* 
       Optimisation TC: o(n)
       SC:o(1)
     */

     public static int solve(int A[]) {
        // Get the length of the input array.
        int n = A.length;
        
        // Initialize variables to keep track of the maximum difference (max) and the minimum value seen (min).
        int max = 0;
        int min = Integer.MAX_VALUE;
    
        // Iterate through the elements of the array.
        for (int i = 0; i < n; i++) {
            // Update the minimum value (min) by comparing it with the current element.
            min = Math.min(min, A[i]);
            
            // Calculate the difference between the current element and the minimum value,
            // and update the maximum difference (max) if this difference is greater.
            max = Math.max(max, A[i] - min);
        }
    
        // Return the maximum difference (max) as the result.
        return max;
    }
}
