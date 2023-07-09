/*

Question : CheckPairDifference

Problem Description
Given an one-dimensional unsorted array A containing N integers.
You are also given an integer B, find if there exists a pair 
of elements in the array whose difference is B.

Return 1 if any such pair exists else return 0.

Problem Constraints
1 <= N <= 105
-103 <= A[i] <= 103
-105 <= B <= 105


Input Format
First argument is an integer array A of size N.
Second argument is an integer B.

Output Format
Return 1 if any such pair exists else return 0.

Example Input
Input 1:

 A = [5, 10, 3, 2, 50, 80]
 B = 78
Input 2:

 A = [-10, 20]
 B = 30
Input 2=3:

 A = [-100, 20, 80]
 B = 9


Example Output
Output 1: 1
Output 2:1
Output 3:0



*/


import java.util.*;
public class CheckPairDifference {
    

    public static void main(String [] args)
    {
        int A=78;
        int B[] = {5, 10, 3, 2, 50, 80};
        String str = Arrays.toString(B);
        int res = solve(A,B);
        System.out.print(res);
    }

    public static int solve(int A, int B[]) {
        // Get the length of the array B
        int n = B.length;
        
        // Create a HashSet to store unique values
        HashSet<Integer> set = new HashSet<>();
        
        // Iterate over each element in the array B
        for (int i = 0; i < n; i++) {
            // Check if the set contains B[i] - A or B[i] + A
            if (set.contains(B[i] - A) || set.contains(B[i] + A)) {
                // If either B[i] - A or B[i] + A is already in the set, return 1
                return 1;
            } else {
                // Otherwise, add B[i] to the set
                set.add(B[i]);
            }
        }
        
        // If no pair (B[i] - A, B[i] + A) is found in the set, return 0
        return 0;
    }
}
