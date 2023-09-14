/*

https://leetcode.com/problems/combination-sum-iii/ 


 
 
*/


import java.util.ArrayList;
import java.util.List;

public class Combinationsum3 {

    public static void main(String[] args) {
        // Define the target sum (n) and the number of elements in each combination (k)
        int n = 7;
        int k = 3;

        // Call the solve function to find combinations that sum to n with k elements
        ArrayList<ArrayList<Integer>> result = solve(n, k);

        // Print the resulting combinations
        for (ArrayList<Integer> combination : result) {
            System.out.println(combination);
        }
    }

    public static ArrayList<ArrayList<Integer>> solve(int n, int k) {
        // Initialize the result list to store valid combinations
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        // Start generating combinations
        generateCombinationSum(1,9,k,n,result,new ArrayList<>());
        return result;
    }

    static void generateCombinationSum(int start, int end,int k, int target,ArrayList<ArrayList<Integer>> result,ArrayList<Integer>tempList) {
        // If the target sum is reached and the number of elements is k, add the combination to the result
        if (target == 0 && tempList.size() == k) {
            result.add(new ArrayList<>(tempList));
        }
        
        // Recursively generate combinations
        for (int i = start; i <= end; i++) {
            tempList.add(i); // Include the current number in the combination
            generateCombinationSum(i+1,end,k,target-i,result,tempList); // Recursive call with updated parameters
            tempList.remove(tempList.size() - 1); // Backtrack by removing the last added element to explore other possibilities
        }
    }
}

/*
  Explantaion of code


->  code finds all combinations of k numbers from 1 to 9 that add up to a target sum n.
 It uses a recursive approach to generate these combinations.


-> The main method initializes the target sum n and the number of elements 
in each combination k, then calls the solve method to find combinations 
that sum to n with k elements.

2) In the solve method, an empty ArrayList called result is 
created to store valid combinations. It then calls the generateCombinationSum 
method to start generating these combinations.

3) The generateCombinationSum method is a recursive function that 
takes several parameters: start and end represent the
 range of numbers to consider (1 to 9 in this case), k is the number of elements
  in each combination, target is the remaining sum to achieve, result 
  is the list of valid combinations, and tempList is the temporary list
   to hold the current combination being generated.

4) Inside generateCombinationSum, it checks two conditions:

-> If the target is 0 and tempList has k elements, it means a valid 
combination is found, so it adds this combination to the result list.
-> It then enters a loop from start to end, and for each number i, 
it adds i to tempList, recursively calls itself with 
updated parameters (subtracting i from the target), and then removes 
the last added element (i) to backtrack and explore other possibilities.

Tc: In the worst case, the function generateCombinationSum is called
 repeatedly for each number from 1 to 9, 
 leading to a time complexity of O(9^k), where k is the number of elements in each combination.

 SC: the space complexity is O(N * k) due to the result list and the tempList.
 */