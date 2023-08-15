/*
 
Question : Reverse a LL
https://leetcode.com/problems/reverse-linked-list/

Given the head of a singly linked list, reverse the list, and return the reversed list.

Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]


Input: head = [1,2]
Output: [2,1]

Constraints:

The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000
 

Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
 */

public class ReverseLL {
    
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

    public static Node Reverse(Node head)
    {

        Node curr = head;   //intialising with head 
        Node prev= null;   //intialising with null 
        Node forw = null;  //intialising with null

        while(curr!=null)       // will continue this process curr not becomes null
        {
            forw = curr.next;  //storing curr.next so we wont loose ahead LL nodes
            curr.next = prev;  //changing connections from this -> to <- 
            prev=curr;         // now bringing prev pointer value to curr
            curr=forw;          // and taking curr value to forw to change the connections
                                 // from this -> to <-
        }
       
        return prev;     // LL is reverse and prev is our new head so we will return that

    }
    public static void main(String[] args)
    {

        Node a = new Node(1);
          Node b = new Node(2);
          Node c = new Node(3);
          Node d = new Node(4);
          Node e = new Node(5);

          a.next =b;
          b.next=c;
          c.next=d;
          d.next =e;

          display(a);
          Node reversedHead = Reverse(a); // Capture the reversed head
        display(reversedHead); // Display the reversed linked list

    }
}
/*
 Pseudocode for above reverse code

 1)Take 3 pointers
 curr,prev,forw

 2)Intialise curr=head; prev=null; forw=null;

 3)inside the loop
 i) will store forw=curr.next to save further LL
 ii)will change curr.next -> (connection ) to prev <- (connection) so LL would be like null <-1 2->3->4
 iii)will mark curr=prev so now curr value is pointing to reverse like this null<-1 2->3->4
 iv) will mark curr = forw so further connection -> like this can change to <- to reverse the list

 4) will continue 3rd step while loop until curr!=null 

 5) return prev node bcoz list is reversed and prev is our new head
 -> forw =curr(null).next is nothing and curr==null so loop will break
 */