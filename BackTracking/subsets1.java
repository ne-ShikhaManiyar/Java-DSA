/*
 Question : subset

 https://www.interviewbit.com/problems/subset/ (interviewbit)

 https://leetcode.com/problems/subsets/description/ (leetcode)

 https://leetcode.com/problems/subsets/solutions/27281/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning/


 */

 import java.util.*;
public class subsets1 {
 
    
    public static void main(String[] args)
    {

    }

    public static ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> A) {
        // Sort the given input list
        Collections.sort(A);
        
        // Create a 2D ArrayList to store subsets
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    
        // Call the recursive subset function to generate subsets
        subset(result, new ArrayList<>(), A, 0);
    
        // Return the result list containing all the subsets
        return result;
    }
    
    // Recursive function to generate subsets
    public static void subset(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> templist, ArrayList<Integer> A, int start) {
        // Add the current subset (templist) to the result list
        result.add(new ArrayList<>(templist));
    
        // Iterate through the input list starting from the given 'start' index
        for (int i = start; i < A.size(); i++) {
            // Include the current element in the subset
            templist.add(A.get(i));
            
            // Recursively generate subsets starting from the next index (i + 1)
            subset(result, templist, A, i + 1);
            
            // Remove the last element from the subset to backtrack and explore other possibilities
            templist.remove(templist.size() - 1);
        }
    }
}

/*

TC:o(2^N*n) 
The code generates all possible subsets of the input list A. 
Since there can be 2^N subsets for a list of size N (where N is the length of the input list A), 
the time complexity of generating all subsets is O(2^N).
-> copying the all subsets in the list will be O(N).

SC: 

O(N) : if we only traverse our subsets, there will at max N recursion stack
O(2^N) : if we would store all the subsets we will need 2^N memory blocks to store each subset

Pseudocode :

1)Sorting the Input: The input list of numbers (A) is first sorted in ascending order.
 Sorting is not necessary for finding subsets but helps
  in generating subsets in a particular order.

2)Initializing Variables:

-> result: This is a list to store all the subsets we find.
-> Generating Subsets Recursively:

3)The subset function is called to generate subsets.
The function takes four parameters:
-> result: The list to store subsets.
-> templist: A temporary list to build subsets.
-> A: The sorted input list.
-> start: The index to start considering elements from the input list.

4)Recursive Function subset:

-> This function does the actual work of generating subsets.
-> It adds the current templist (subset) to the result.
-> Then, it iterates through the elements of the input list starting from the start index.
-> For each element:
-> It adds the element to the templist, effectively including it in the current subset.
-> It then recursively calls itself with an updated templist and an incremented start index.
-> After the recursion, it removes the last added element from the 
templist to backtrack and explore other possibilities.
Final Result:

-> After running the subset function for all possible combinations, 
the result list contains all the subsets.
The code returns this list as the final result.



/*
  
 Iterative approach
nums = [1,2,3]
 public List<List<Integer>> subset(int [] nums)
 {
    List<List<Integer>> result = new ArrayList<>(); // powerset contains all set
    result.add(new ArrayList()); // adding empty subset

    // in this approach we picking empty subset adding up elements in it then again adding in the sets which we got
    // above approach is called cascading style
    for(int num : nums){
    int n = res.size();  // modifying result list 
    for(int j=0;j<n;j++)
    {
        ArrayList<Integer> temp = new ArrayList<>(result.get(j)); // copying empty subset from result list
        temp.add(nums);// add number  // now we creating [1]
        result.add(temp) // then again add the susbet in result list


    }
}
    return result;
 }

 tc:o(n*2^n)
sc: o(n*2^n)
 */
  



