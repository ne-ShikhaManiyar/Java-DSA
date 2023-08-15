/*
 Question :  Delete Node in a Linked List

 https://leetcode.com/problems/delete-node-in-a-linked-list/

 Input: head = [4,5,1,9], node = 5
Output: [4,1,9]
Explanation: You are given the second node with value 5, 
the linked list should become 4 -> 1 -> 9 after calling your function.


Input: head = [4,5,1,9], node = 1
Output: [4,5,9]
Explanation: You are given the third node with value 1, 
the linked list should become 4 -> 5 -> 9 after calling your function.

Constraints:

The number of the nodes in the given list is in the range [2, 1000].
-1000 <= Node.val <= 1000
The value of each node in the list is unique.
The node to be deleted is in the list and is not a tail node.
 */

public class DeleteNodeinLL {
 
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

        public static void DeleteNode(Node node)  //node is given
        {
            node.data = node.next.data;  //copying data of next node in the current node 
                                         // so LL early was 1->2->3->4
                                           // now 1->3->3-4
            node.next = node.next.next;    //removing the node 
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

        display(a);
        DeleteNode(c);
        display(a);
    }
}
/*
  Pseudocode for above approach 


  -> this approach works for only node is in head or in middle of LL
-> this does not work if node given is tail pointer 

  1) copy the next node data in the currrent node so given node and next node data would be same

  eg : 4->5->1->9 
      5 is given 
      we copy 4->1->1->9 
  2) remove the next node from the list this way 

    4->1->1->-> 9
    4->1->9 
 */