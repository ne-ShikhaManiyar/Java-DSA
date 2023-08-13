/*
   Question : Delete middle element of LL 

   https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/

   1) Input: head = [1,3,4,7,1,2,6]
Output: [1,3,4,1,2,6]

2)Input: head = [1,2,3,4]
Output: [1,2,4]

3)Input: head = [2,1]
Output: [2]



 */



public class DeleteMiddleEle {

    public static class Node
    {
        int data;
         Node next;
         
         public Node(int data)
         {
            this.data = data;
         }
    }

    public static Node DeleteMiddleEleNode(Node head)
    {
         // If the list is empty or has only one element, no middle to delete
        if( head.next==null)
        {
            return head;
        }
        Node slow = head;
        Node fast = head;

    // for even and odd node we are comming till 1 node before deleteing actual node
        while(fast.next.next!=null && fast.next.next.next!=null)
        {
            slow= slow.next; // Move slow pointer one step
            fast=fast.next.next; // Move fast pointer two steps

        }

        slow.next = slow.next.next;  // wiping out the actual node
        return head;  // for even node we always return right middle ele
    }


    static void display(Node head) {
        Node temp = head;
        while (temp != null) {

            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();

    }


    public static void main(String[] args)
    {
         Node a = new Node(2);
         Node b = new Node(1);
         // Node c = new Node(3);
         // Node d = new Node(4);
        //  Node e = new Node(5);
        //  Node f = new Node(6);
         // Node g = new Node(7);

          a.next =b;
        //  b.next=c;
         // c.next=d;
          //d.next=e;
          //e.next=f;
         // f.next=g;

          System.out.println("Original Linked List:");
        display(a);

        a = DeleteMiddleEleNode(a);

    System.out.println("Linked List after deleting middle element:");
    display(a);

    }
}

/*
 Pseudocode for above code


 1) check wheteher head.next is null or not if yes return head;
 2) create 2 pointers slow and fast
 3) move slow (1x) and fast(2x)
 4) while condition is such bcoz we need to delete an node so for both odd and even cases we want 
 slow pointer to come before a  node we want to delete and stop
 so we use for odd cases fast.next.next.next!=null && for even cases we want to delete right middle
 we use fast.next.next
 4)then we can wipe out our slow.next= slow.next.next
 5) return head 
 */