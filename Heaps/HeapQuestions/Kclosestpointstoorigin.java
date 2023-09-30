/*
   Question : k closest points to origin 
  
   https://leetcode.com/problems/k-closest-points-to-origin/description/

 */

package HeapQuestions;

import java.util.*;

public class Kclosestpointstoorigin {

    
    public int[][] kClosest(int[][] points, int k) {
        
        // Check if the input array is null and handle it
        if(points == null) return null;

        // Create a Priority Queue (Min Heap) to store the points
        // The comparator is used to compare points based on their distance from the origin
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int p1[], int p2[]) {
                // Calculate the distance from the origin for both points and compare them
                // The point with a smaller distance comes first in the priority queue
                return (p2[0] * p2[0] + p2[1] * p2[1]) - (p1[0] * p1[0] + p1[1] * p1[1]);
            }
        });

        // Iterate through each point in the input array
        for (int i = 0; i < points.length; i++) {
            // Add the current point to the priority queue
            pq.add(points[i]);
            
            // If the size of the priority queue exceeds 'k', remove the point with the farthest distance
            if (pq.size() > k) {
                pq.remove();
            }
        }

        // Create a 2D array to store the 'k' closest points
        int result[][] = new int[k][2];
        int i = 0;

        // Pop points from the priority queue and store them in the result array
        while (!pq.isEmpty()) {
            result[i] = pq.remove();
            i++;
        }

        // Return the 'k' closest points
        return result;
    }
   
    public static void main(String[] args)
    {


    }
}

/*
   Explanation  of the Code:
1)Input Validation:
-> The code starts by checking if the input array points is null. If it's null, the method returns null. 
-> This is a defensive programming measure to handle potential null inputs.

2)Priority Queue:
-> A priority queue (pq) is created with the intention to use it as a min heap. 
This means that the element with the smallest value according to a specified comparator will be at
 the front of the queue.
-> The comparator is defined to compare two points based on their distance from the origin. 
The closer a point is to the origin, the smaller its distance, so it should come first in the 
priority queue.
-> The comparison is done using the Euclidean distance formula: distance = sqrt(x^2 + y^2).
 -> However, to avoid the square root operation (which is computationally expensive), the code uses 
 the squared distance for comparison (x^2 + y^2).

3)Iteration through Points:
-> The code then iterates through each point in the points array.
-> For each point, it calculates the squared distance from the origin (0, 0) and adds the point to the pq.
-> After adding each point, it checks if the size of pq exceeds k.
 If it does, it removes the point with the farthest squared distance from the origin.
  This ensures that pq always contains the K closest points.

4)Creating the Result Array:
-> After processing all points, the code creates a 2D array called result to store the K closest points.
 It initializes an index i to 0.

5) Populating the Result Array:
-> It then proceeds to pop points from the priority queue (pq) and stores them in the result array.
->The points are removed from pq in ascending order of their squared distances, 
which means the K closest points will be stored first in the result array.

6)Returning the Result:Finally, the code returns the result array containing 
the K closest points to the origin.


Here's why we use [k][2]:

Number of Rows (k): The number of rows in the result array is equal to k. 
This is because you want to store the K closest points. Each row in the 
result array will correspond to one of these K points.

Number of Columns (2): Each point in a 2D space is represented by two coordinates,
 an x-coordinate and a y-coordinate. Therefore, each row in the result array has
  two columns: one for the x-coordinate and one for the y-coordinate.

  TC: o(nlogk)
  SC:o(k)
 */