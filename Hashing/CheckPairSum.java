/*

Question : CheckPairSum 


Problem Description
Given an Array of integers B, and a target sum A.
Check if there exists a pair (i,j) such that Bi + Bj = A and i!=j.


Problem Constraints
1<= Length of array B <= 103
0<= Bi <=109
0<= A <=109


Input Format
First argument A is the Target sum, and second argument is the array B


Output Format
Return an integer value 1 if there exists such pair, else return 0.


Example Input
Input 1:

A = 8   
B = [3, 5, 1, 2, 1, 2]
Input 2:

A = 21   
B = [9, 10, 7, 10, 9, 1, 5, 1, 5]

Example Output
Output 1:
1
Output 2:
0


*/


import java.util.*;
public class CheckPairSum {
    
 public static void main(String[] args)
 {
    int A=8;
    int B[] = {3, 5, 1, 2, 1, 2};
    String str = Arrays.toString(B);
    int res = solve(A,B);
    System.out.print(res);


 }




 public static int solve(int A, int[] B) {
 
    // Get the length of the array
    int n = B.length;

    // Create a HashSet to store elements from the array
    HashSet<Integer> set = new HashSet<>();

    // Iterate over each element in the array
    for(int i = 0; i < n; i++) {
        // Check if the set already contains the difference between A and the current element
        if(set.contains(A - B[i])) {
            // If it does, return 1
            return 1;
        } else {
            // If it doesn't, add the current element to the set
            set.add(B[i]);
        }
    }

    // If no pair of elements sums up to A, return 0
    return 0;
}

}