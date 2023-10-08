/*
   https://leetcode.com/problems/maximum-length-of-pair-chain/  (leetcode 646)
 */


import java.util.*;
public class MaxlengthchainNopairs
{
    public static void main(String[] args)
    {
        int pairs[][] = {{5,24},{39,60},{5,28},{27,40},{50,90}};

        Arrays.sort(pairs,Comparator.comparingDouble(o->o[1]));  // sorting as per 2nd number
        int chainLen =1;
        int chainend =pairs[0][1] ;// Last pair end , (Chain end)

        for(int i=1;i<pairs.length;i++)
        {
            if(pairs[i][0] > chainend)  // start  > chainend
            {
                chainLen++;
                chainend =pairs[i][1]; // updating chainend to last number so it can calculate the further length
            }
        }

        System.out.println("chainlength:"+ chainLen);
    }
}

/*
  Code Explanation

  1)Sorting: The program sorts the input pairs based on the second element (b) in each pair using Arrays.sort 
  with a custom comparator. Sorting has a time complexity of O(n log n), where 'n' is the number of pairs.

2)Iterating through Pairs: After sorting, the program iterates through the pairs once, 
comparing the start of each pair with the end of the previous chain. 
-> If the start of the current pair is greater than the end of the previous chain, it increments the 
chain length and updates the end of the chain. This process ensures that the pairs are chained together 
optimally.

Space Complexity: The space complexity of your program is O(n) because you are storing the sorted pairs in memory,
 which takes up additional space.

Time Complexity: The time complexity of the program is O(n log n) due to the sorting step and O(n) 
for the iteration through the sorted array. Therefore, the overall time complexity is dominated by
 the sorting step, which is O(n log n).
 */