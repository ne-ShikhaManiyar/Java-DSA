/*
  Question : Combinations

  
  https://leetcode.com/problems/combinations/  (leetcode - 77)

 */
import java.util.*;
public class Combinations {
    
    public static void main(String [] args)
    {
        int n = 4;
        int k = 2;

        ArrayList<ArrayList<Integer>> combinations = solve(n, k);

        // Print the generated combinations
        for (ArrayList<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }

    
    public static ArrayList<ArrayList<Integer>> solve(int n, int k) {
        // Create an ArrayList to store the combinations
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        
        // Call the recursive function to generate combinations
        generateCombinations(result, new ArrayList<>(), n, k, 1);

        return result;
    }

    static void generateCombinations(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> templist, int n, int k, int start) {
        // If the current combination size equals 'k', add it to the result
        if (templist.size() == k) {
            result.add(new ArrayList<>(templist));
            return; // Return to explore other possibilities
        }

        // Iterate through numbers from 'start' to 'n'
        for (int i = start; i <= n; i++) {
            // Include the current number in the combination
            templist.add(i);
            
            // Recursively generate combinations with the next number (i+1)
            generateCombinations(result, templist, n, k, i + 1);
            
            // Remove the last added number to backtrack and explore other possibilities
            templist.remove(templist.size() - 1);
        }
    }
}

/*
  Explanation of above code 

 
1)Main method

-> In the main method, we set the values of n and k to 4 and 2, respectively.
We then call the solve method to generate combinations of size k from a set of numbers from 1 to n.
Finally, we print the generated combinations.


2)Solve Method (public static ArrayList<ArrayList<Integer>> solve(int n, int k))

-> This method is responsible for initializing the process of generating combinations.
-> It creates an ArrayList called result to store the generated combinations.
-> It calls the generateCombinations method to start generating combinations.


3)GenerateCombinations Method (static void generateCombinations(ArrayList<ArrayList<Integer>> result,
 ArrayList<Integer> templist, int n, int k, int start))

-> This is the heart of the combination generation logic, implemented recursively using backtracking.

-> The method takes several parameters:

result: The ArrayList to store the generated combinations.
templist: An ArrayList that temporarily stores a combination being constructed.
n: The maximum value for elements in the set (1 to n).
k: The size of combinations to generate.
start: The current number being considered for inclusion in the combination.
Inside this method:

-> If the size of templist becomes equal to k, it means a valid combination of size
 k has been formed. It is added to the result ArrayList.
-> It iterates through the numbers from start to n.
-> For each number, it includes that number in templist, recursively generates 
combinations with the next numbers, and then removes
 the last added number (backtracks) to explore other possibilities.

 TC: In the worst case, when generating all possible combinations, 
 the time complexity is also O(n choose k), as each possible combination is generated once.

 SC:In the worst case, when generating all possible combinations, 
 the space complexity is O(n choose k), where "n choose k" is the 
 binomial coefficient, representing the number of combinations of n items taken k at a time.
 */