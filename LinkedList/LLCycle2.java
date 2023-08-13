/*
Question : Detect cycle is their or not and return node where cycle starts

https://leetcode.com/problems/linked-list-cycle-ii/description/

nput: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.

Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.

Input: head = [1], pos = -1
Output: no cycle
Explanation: There is no cycle in the linked list.

The number of the nodes in the list is in the range [0, 104].
-105 <= Node.val <= 105
pos is -1 or a valid index in the linked-list.
 

Follow up: Can you solve it using O(1) (i.e. constant) memory?

 */


public class LLCycle2 {
    
    public static class Node
    {
        int data;
         Node next;
         
         public Node(int data)
         {
            this.data = data;
         }
    }

    static void display(Node head) {
        Node temp = head;
        while (temp != null) {

            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();

    }

    public static Node Cycle(Node head)
    {
        if(head==null || head.next==null)  //base condition for 1 of test case
         return null;

         Node slow = head;
         Node fast = head;

         while(fast!=null && fast.next!=null)  // checking for both fast bcoz we are moving fast at(2x) speed
         {
            slow=slow.next;
            fast = fast.next.next;
            if(slow==fast) break;  // at any point slow==fast break the loop
         }

         Node temp = head;  // intialse with head bcoz wee need to return node where cycle starts
                               // so will iterate for slow and temp if they are slow==temp return slow
                            
         while(slow!=null && temp!=slow)
         {
            temp = temp.next;
            slow=slow.next;
         }
         return slow;
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
}
}

/*
 Pseudcode for above code

 1) check if head or head.next is null if yes return null
 2) intialise 2 pointers slow and fast
 3)move slow(1x) and fast(2x)

-> while condition is such if no cycle it will go for (fast!=null) 
and for single or 2 node it checks for(fast.next!=null) 
-> if slow==fast break the loop

4) intialize Node temp = head;

5)check if slow and temp are equal return slow pointer 
6) also adding slow!=null bcoz if their is no cycle 1->2-> null to avoid null pointer exception
 */