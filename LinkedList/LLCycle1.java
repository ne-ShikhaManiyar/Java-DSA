/*
   Question : Detect LL has cycle or not

   https://leetcode.com/problems/linked-list-cycle/description/

   Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list,
 where the tail connects to the 1st node (0-indexed).


 Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, 
where the tail connects to the 0th node.

Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.
 */


public class LLCycle1 {

    public static class Node
    {
        int data;
         Node next;
         
         public Node(int data)
         {
            this.data = data;
         }
    }

    public static boolean CycleLL(Node head)
    {
        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast) return true;  //if at any point slow==fast break loop return true
        }

        return false;
    }

    static void display(Node head) {
        Node temp = head;
        while (temp != null) {

            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();

    }

    
    public static void main(String [] args)
    {
        Node a = new Node(1);
          Node b = new Node(2);
          Node c = new Node(3);
          Node d = new Node(4);

          a.next =b;
          b.next=c;
          c.next=d;
         // d.next =b;

          System.out.println("Original Linked List:");
          display(a);
    }
}


/*  Pseudocode for Cycle Code

1) Intialize 2 pointers fast and slow
2)move slow(1x) and fast (2x) speed
3) while condition is such for single pointer we checking fast.next is null or not 
-> and we checking for fast!=null (bcoz if no cycle is their fast would become null and it goes normally)
4) if we found out fast and slow are equal fast==slow return true
5)else return false
 
 */