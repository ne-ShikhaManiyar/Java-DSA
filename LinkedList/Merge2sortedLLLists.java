
/*
  Question : Merge 2 sorted Lists

  https://leetcode.com/problems/merge-two-sorted-lists/

  You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be 
made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

Example 1:


Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]
 

Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.


 */

public class Merge2sortedLLLists {
    
    public static class Node
    {
        int val;
         Node next;
         
         public Node(int val)
         {
            this.val = val;
         }
    }

    static void display(Node head) {
        Node temp = head;
        while (temp != null) {

            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();

    }

    public static Node Merge2LL(Node list1, Node list2)
    {
         Node t1 = list1;
         Node t2 = list2;
         Node h = new Node(100);
         Node t=h; // storing the refrence of new node and moving the refrence ahead in the lists

         while(t1!=null && t2!=null)
         {
             if(t1.val<t2.val)
             {
                t.next=t1;  //connext t pointer towards t1 if condition satisfies
                t=t1;    // move the t pointer on t1
                t1=t1.next; // now move to next node of the list 
             }
             else
             {
                t.next=t2; //connect t pointer towards t2 else condition satisfies
                t=t2;     // move the t pointer on t2
                t2=t2.next; // now move to next node of the list 
             }
         }

         if(t1==null)  // for remaininig lists add in the t pointer
         {
            t.next=t2;
         }
         else
         {
            t.next=t1;
         }
         return h.next;   // we need to return head so new node h next is our head 
    }

    public static void main(String[] args)
    {

        Node a = new Node(1);
        Node b = new Node(3);
        Node c = new Node(5);
        Node d = new Node(8);
        Node e = new Node(9);
    
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        Node f = new Node(2);
        Node g = new Node(4);
        Node h= new Node(6);
        Node i = new Node(7);
        
    
        f.next = g;
        g.next = h;
        h.next = i;
  
    
        Node list1 = a;
        Node list2 = f;  // You can create another sorted linked list for list2
    
        Node mergedList = Merge2LL(list1, list2);
    
        System.out.println("Merged Sorted List:");
        display(mergedList);
    }
}

/*
 Pseudocode for above approach

1)Take 2 pointers t1 & t2
2)Intialise t1=list1 and t2=list2
3)create a new node h with any value
4)store h in a node like t=h;
5)run the while loop until none of the lists becomes empty
6) inside the loop compare the t1.val <t2.val if true
-> move t.next to t1 
-> move t to t1 make new connection t=t1
-> then move t1=t1.next to next pointer 
-> same goes in else part

7)if any lists becmes null then check
->if t1==null t.next=t1;
else t2==null t,next=t2;

return head which is stored in h so we do h.next;

 */