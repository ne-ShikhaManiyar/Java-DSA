/*
 https://leetcode.com/problems/combination-sum/description/ (leetcode)
 */

import java.util.ArrayList;
import java.util.List;

public class CombinationsSum {
    
    public static void main(String[] args) {
        // Input values
      //  int[] candidates = {2, 3, 5};
      // int target = 8;
      int [] candidates = {2, 3, 6,7};
        int target = 7;
        
        // Create an instance of CombinationsSum
        CombinationsSum combinationsSum = new CombinationsSum();
        
        // Call combinationSum to find combinations
        List<List<Integer>> result = combinationsSum.combinationSum(candidates, target);
        
        // Print the result
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        generateCombinationSum(result, new ArrayList<>(), candidates, 0, target);
        return result;
    }

    void generateCombinationSum(List<List<Integer>> result, List<Integer> templist, 
            int candidates[], int start, int target) {

        if (target == 0) {
            // If target becomes 0, it means we found a valid combination, so add it to the result.
            result.add(new ArrayList<>(templist));
        }

        if (target < 0) {
            // If target becomes negative, it means the current combination doesn't work.
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            templist.add(candidates[i]); // Add the current candidate to the temporary list
            generateCombinationSum(result, templist, candidates, i, target - candidates[i]);
            templist.remove(templist.size() - 1); // Backtrack by removing the last element
        }
    }
}


/*
 Explanation of above code


 -> The above code is to find all combinations of numbers from an array (candidates)
  that add up to a given target sum. 

1) The main method:

-> Defines an array of candidates [2, 3, 5] and a target sum 8.
-> Creates an instance of the CombinationsSum class.
-> alls the combinationSum method to find combinations that sum up to the target.
-> Prints the resulting combinations.


2) The combinationSum method:

-> Initializes an empty list called result to store the valid combinations.
Calls the generateCombinationSum method to find combinations, passing the result,
 an empty temporary list (templist), the candidates array, a start index (initially 0),
  and the target sum.

3)The generateCombinationSum method (recursive):

-> Checks if the target sum is 0. If so, it means a valid combination is found,
 so it adds a copy of the templist to the result list.
-> Checks if the target sum is negative. If so, it means the current combination doesn't work, 
so it returns without doing anything.
-> Iterates through the candidates array starting from the start index.
-> Adds the current candidate to the templist.
-> Recursively calls itself with the updated templist, the same candidates array, 
the current index i, and the reduced target sum (target - candidates[i]).
-> After the recursive call, it removes the last added element from templist
 to backtrack and explore other combinations.
-> The code uses a depth-first search approach to explore all possible combinations.
 When the target becomes 0, it adds the combination to the result. When the target becomes negative,
  it backtracks. The process continues until all valid combinations
   are found and stored in the result list.


   TC: o(k*2^n)
   TC: o(k*2^n)
 */