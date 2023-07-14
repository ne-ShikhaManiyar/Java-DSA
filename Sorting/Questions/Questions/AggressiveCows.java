/* 

Question : Aggressive Cows

Problem Description
Farmer John has built a new long barn with N stalls.
 Given an array of integers A of size N where each element of the array 
 represents the location of the stall and an integer B which represents the number of cows.

His cows don't like this barn layout and 
become aggressive towards each other once put into a stall. To prevent the cows
 from hurting each other, John wants to assign the cows to the stalls, 
 such that the minimum distance between any two of them is as large as possible. 
 What is the largest minimum distance?

 Problem Constraints
2 <= N <= 100000
0 <= A[i] <= 109
2 <= B <= N



Input Format
The first argument given is the integer array A.
The second argument given is the integer B.



Output Format
Return the largest minimum distance possible among the cows.



Example Input
Input 1:

A = [1, 2, 3, 4, 5]
B = 3
Input 2:

A = [1, 2]
B = 2


Example Output
Output 1:

 2
Output 2:
 1


*/


import java.util.Arrays;

public class AggressiveCows
{
    public static void main(String[] args)
    {
        int A[] = { 1,2,8,4,9};
        int B=3;
        String str = Arrays.toString(A);
        int res = solve(A,B);
        System.out.print(res);
    }


  
    public static int solve(int[] A, int B) {

        int n = A.length;
        Arrays.sort(A); // Sorting the array in ascending order
        int low = 1; // Starting value for the binary search
        int ans = 0; // Variable to store the result
        int high = A[n - 1]; // Maximum possible distance is between the last element and the first element after sorting
        
        while (low <= high) {
            int mid = low + (high - low) / 2; // Calculating the middle value
            
            if (isPossible(B, A, mid)) { // Checking if it is possible to place B cows with minimum distance mid
                ans = mid; // Updating the result to the current mid
                low = mid + 1; // Searching for larger distances
            } else {
                high = mid - 1; // Searching for smaller distances
            }
        }
        
        return ans; // Returning the maximum possible distance
    }
    
    static boolean isPossible(int B, int A[], int mindistance) {
        int n = A.length;
        int cowsplaced = 1; // Count of cows placed
        int prevCow = A[0]; // Position of the previously placed cow
        
        for (int i = 1; i < n; i++) {
            if (A[i] - prevCow >= mindistance) {
                prevCow = A[i]; // Updating the position of the previously placed cow
                cowsplaced++; // Incrementing the count of cows placed
            }
        }
        
        return cowsplaced >= B; // Returning true if the count of cows placed is greater than or equal to B
    }
}

    
