package HeapQuestions;
/*
 
Question : kth largest element

https://leetcode.com/problems/kth-largest-element-in-an-array/ (leetcode 215)

Q1 Given an integer array numY and an integer k, return the kth largest element in the array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.

i/p -> nums:[3,7,2,9,5]
k=3 
o/p -> 5
 */

import java.util.*;

public class kthlargestelement {
    public static void main(String[] args) {
    /*     int k = 3;
        List<Integer> ans = new ArrayList<>();
        ans.add(3);
        ans.add(7);
        ans.add(2);
        ans.add(9);
        ans.add(4);
        ans.add(5);
     


        // brute force

        List<Integer> sortedans = new ArrayList<>(ans);// o(n)
        sortedans.sort(Comparator.reverseOrder()); // o(nlogn)
        System.out.println(sortedans);
       // System.out.println(sortedans.get(k - 1)); // o(1)

        // better

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < ans.size(); i++) {
            // if top element is small then remove it and add element
            if (pq.size() == k) {
                if (pq.peek() < ans.get(i)) {
                    pq.poll();
                    pq.add(ans.get(i));
                        
                }
                continue;  // if element incoming is smaller than top then skip it
            
            }
            // for normal cases add in priorityqueue
            pq.add(ans.get(i));

        }
        System.out.println(pq.peek());*/
    }
    public int findKthLargest(int[] nums, int k) {
        // Create a priority queue (min-heap) to maintain the k largest elements.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // Iterate through the input array 'nums'.
        for (int i = 0; i < nums.length; i++) {
            // Check if the size of the priority queue is equal to 'k'.
            if (pq.size() == k) {
                // If it is, compare the smallest element in the priority queue with the current element.
                if (pq.peek() < nums[i]) {
                    // If the current element is larger than the smallest element in the priority queue,
                    // remove the smallest element and add the current element to the priority queue.
                    pq.poll();
                    pq.add(nums[i]);
                }
                // Continue to the next element in the input array if element coming already small then top of pq
                continue;
            }
         // If the size of the priority queue is less than 'k', simply add the current element to it.
            pq.add(nums[i]);
        }

    // Return the smallest element in the priority queue, which will be the kth largest element in 'nums'.
        return pq.peek();
    }
}

// Explantation of code

/*
   Bf : we can copy the elements in the new array and sort the new array
   -> and return the k largest element 

   1) Create priority queue
   2)iterate on i/p array add elements in priority queue if size becomes k then start comparing
   top element with i/p array
   3) if top ele < nums[i] remove top and nums[i] in pq
   4)if coming element already smallet than top element we can skip it 
   5) return top element of pq 

   TC: o(nlogk)
   Sc: o(k)
 */