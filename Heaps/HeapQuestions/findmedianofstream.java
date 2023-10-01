/*
Question : Find Median from Data Stream (leetcode 295)

  https://leetcode.com/problems/find-median-from-data-stream/description/
 */

package HeapQuestions;
import java.util.*;
public class findmedianofstream {
    
    public static void main(String[] args)
    {

    }
    // Create two priority queues: one for the smaller half (maxheap) and one for the larger half (minheap)
    PriorityQueue<Integer> maxheap = new PriorityQueue<>(Comparator.reverseOrder());
    PriorityQueue<Integer> minheap = new PriorityQueue<>();

    // Function to add a number to the data structure
    public void addNum(int num) {
        // If maxheap is empty or the number is less than or equal to the maximum element in maxheap
        if (maxheap.isEmpty() || maxheap.peek() >= num) {
            maxheap.add(num);
        } else {
            minheap.add(num);
        }

        // Ensure that the sizes of maxheap and minheap are balanced
        if (maxheap.size() > minheap.size() + 1) {
            minheap.add(maxheap.poll());
        } else if (maxheap.size() < minheap.size()) {
            maxheap.add(minheap.poll());
        }
    }

    // Function to find the median of the data structure
    public double findMedian() {
        // If the sizes of maxheap and minheap are equal, return the average of their tops
        if (maxheap.size() == minheap.size()) {
            return (maxheap.peek() + minheap.peek()) / 2.0;
        }
        // Otherwise, maxheap will always contain one more element than minheap, so return the top of maxheap
        return maxheap.peek();
    }
}


/*
  Explanation of code

1)The class MedianFinder is designed to maintain a running median of a stream of numbers
 using two priority queues, maxheap and minheap.

2)In the addNum method, a number is added to one of the heaps based on its value. 
->If the number is less than or equal to the maximum element in maxheap, it is added to maxheap, 
otherwise, it is added to minheap.

3)After adding a number, the method checks if the sizes of maxheap and minheap are balanced.
 If maxheap has more than one extra element compared to minheap, the maximum element from maxheap 
 is moved to minheap to balance the sizes. Similarly, if maxheap has fewer elements than minheap, 
 the minimum element from minheap is moved to maxheap.

4)The findMedian method calculates and returns the median of the numbers in the data structure. 
If the sizes of maxheap and minheap are equal, it returns the average of the tops of both heaps. 
Otherwise, it returns the top of maxheap, which will always contain the median.

Time Complexity:

Adding a number (addNum): O(log n) on average, where n is the number of elements in the data structure.
Finding the median (findMedian): O(1), as it involves accessing the tops of the heaps.
Space Complexity:

Space complexity is O(n) in the worst case, where n is the number of elements added to the data structure. This is because both maxheap and minheap can store up to n/2 elements each.





 */