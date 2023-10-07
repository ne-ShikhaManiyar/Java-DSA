/*
    Question : activity selection

  Given two integer arrays A and B of size N.

-> There are N activities where A[i] denotes the start time of the ith activity and B[i] 
denotes the finish time of the ith activity.

-> Your task is to select the maximum number of activities that can be performed by a single person, 
assuming that a person can only work on a single activity at a time.


Input Format
The first argument given is the integer array A.
The second argument given is the integer array B.

Output Format:
Return the maximum number of activities that can be performed by a single person.

Constraints
1 <= N <= 100000
0 <= A[i] <= B[i] <= 2*10^9 
For Example

Input 1:
    A = [5, 1, 3, 0, 5, 8]
    B = [9, 2, 4, 6, 7, 9]
Output 1: 4

 Explanation 1:
 Activites 2, 3, 5 and 6 can be selected (1- based indexing).

Input 2:
    A = [17, 8, 14, 24, 10, 8, 1, 30]
    B = [18, 45, 24, 27, 18, 10, 38, 35]
Output 2: 4


 */

import java.util.*;

public class ActivitySelection {

  public static void main(String[] args) {
    int start[] = { 5, 1, 3, 0, 5, 8 }; // {1,3,0,5,8,5};
    int end[] = { 9, 2, 4, 6, 7, 9 };// {2,4,6,7,9,9}; // end time basis sorted activity

    // based on end time activity is sorted
    int maxact = 0;
    ArrayList<Integer> ans = new ArrayList<>();

    // 1st activity
    maxact = 1;
    ans.add(0); // if end time is sorted

    int lastend = end[0]; // last activity selected that activity end time if sorted

    for (int i = 1; i < start.length; i++) {

      if (start[i] >= lastend) // non - overlapping activity // if end time sorted
      {
        maxact++;
        ans.add(i);
        lastend = end[i];
      }

    }

    System.out.println("max activtiy=" + " " + maxact);
    for (int i = 0; i < ans.size(); i++) {
      System.out.print("A" + ans.get(i) + " ");
    }

    System.out.println();

  }

  // when end activity array is not sorted
  public int solve(int start[], int end[]) {
    // Create a 2D array 'mat' to store the activity index, start time, and end
    // time.
    // Initialize 'maxact' as 1 to represent the first activity.
    // Initialize 'lastend' with the end time of the first activity.
    int mat[][] = new int[start.length][3];
    int maxact = 1;
    int lastend = end[0]; // Initialize 'lastend' with the end time of the first activity.

    // Iterate through the activities starting from the second activity (index 1).
    for (int i = 1; i < start.length; i++) {
      // Fill the 'mat' array with activity indices, start times, and end times.
      mat[i][0] = i;
      mat[i][1] = start[i];
      mat[i][2] = end[i];

      // Sort the 'mat' array based on end times in ascending order.
      Arrays.sort(mat, Comparator.comparingDouble(o -> o[2]));

      // Compare the start time of the current activity with 'lastend'.
      // If the current activity starts after or at the same time as 'lastend',
      // it means the activities don't overlap, so we can select this activity.
      if (mat[i][1] >= lastend) {
        maxact++; // Increment the count of selected activities.
        lastend = mat[i][2]; // Update 'lastend' with the end time of the current activity.
      }
    }

    return maxact; // Return the maximum count of non-overlapping activities.
  }
}

/*
  TC:o(nlogn) with sorting
  SC:o(n)
  
  1)The function solve takes two arrays, start and end, representing the start and end times of activities.

2)It initializes mat as a 2D array to store the activities' indices, start times,
 and end times. maxact represents the count of selected activities, and lastend keeps
  track of the end time of the last selected activity.

3)The code iterates through the activities starting from the second activity (index 1).

4)Inside the loop, it fills the mat array with activity indices, start times, and end times.

5)The mat array is sorted based on end times in ascending order,
 ensuring that activities with earlier end times come first.

6)It compares the start time of the current activity with lastend.
 If the current activity starts after or at the same time as lastend, 
 it means the activities don't overlap, so the current activity is selected. 
 maxact is incremented, and lastend is updated with the end time of the current activity.

7)The function returns the maxact, which represents the maximum count of non-overlapping activities.

-> The above code finds and returns the maximum number of non-overlapping activities efficiently 
by sorting the activities based on their end times.
 */