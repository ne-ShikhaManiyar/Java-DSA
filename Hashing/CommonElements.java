/*

Question : CommonElements

Problem Description
Given two integer arrays, A and B of size N and M, respectively.
 Your task is to find all the common elements in both the array.

NOTE:

Each element in the result should appear as many times as it appears in both arrays.
The result can be in any order.


Problem Constraints
1 <= N, M <= 105

1 <= A[i] <= 109



Input Format
First argument is an integer array A of size N.

Second argument is an integer array B of size M.



Output Format
Return an integer array denoting the common elements.



Example Input
Input 1:

 A = [1, 2, 2, 1]
 B = [2, 3, 1, 2]
Input 2:

 A = [2, 1, 4, 10]
 B = [3, 6, 2, 10, 10]


Example Output
Output 1:

 [1, 2, 2]
Output 2:

 [2, 10]


Example Explanation
Explanation 1:

 Elements (1, 2, 2) appears in both the array. Note 2 appears twice in both the array.
Explantion 2:

 Elements (2, 10) appears in both the array.


*/

import java.util.*;
public class CommonElements {


    public static void main(String[] args)
    {
        
         int A[]= {1, 2, 2, 1};
        int B[]= {2, 3, 1, 2};
      
        //int res = solve(A,B);
       // System.out.print(res);
    }

    public static ArrayList<Integer>  solve(ArrayList<Integer> A, ArrayList<Integer> B)
    {

          // Get the size of ArrayLists A and B
          int n = A.size();
          int m = B.size();
          
          // Create a HashMap to store the occurrences of each element in ArrayList A
          HashMap<Integer, Integer> hmap = new HashMap<>();
          
          // Count the occurrences of each element in ArrayList A
          for(int i = 0; i < n; i++) {
              int val = A.get(i);
              
              // If the HashMap already contains the element, increase its frequency by 1
              if(hmap.containsKey(val)) {
                  int f = hmap.get(val);
                  hmap.put(val, f + 1);
              } else {
                  // If the element is encountered for the first time, add it to the HashMap with frequency 1
                  hmap.put(val, 1);
              }
          }
          
          // Create an ArrayList to store the common elements
          ArrayList<Integer> list = new ArrayList<>();
          
          // Check each element in ArrayList B
          // If it exists in the HashMap and has at least one occurrence in A, add it to the result list
          for(int i = 0; i < m; i++) {
              int val = B.get(i);
              
              // If the HashMap contains the element and its frequency is at least 1
              if(hmap.containsKey(val) && hmap.get(val) >= 1) {
                  int f = hmap.get(val);
                  hmap.put(val, f - 1); // Decrement the frequency by 1
                  list.add(val); // Add the element to the result list
              }
          }
          
          return list; // Return the list of common elements
    }
    
}
