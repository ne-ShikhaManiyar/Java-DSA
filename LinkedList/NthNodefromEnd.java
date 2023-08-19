/*

Question : Remove Nth Node From End of List

   https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/


   Given the head of a linked list,
   remove the nth node from the end of the list and return its head.

Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]


Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
 */

public class NthNodefromEnd {
    
    public static Node nthNode(Node head, int n) // its a code which we can use as a brute force
                                                    // as 2 pass 
    {
        int size=0;
        Node temp = head;
        while(temp!=null)
        {
            size++;
            temp = temp.next;
        }
        int m = size - n+1;

        //mth node from start
         temp = head;
        for(int i=0;i<m-1;i++)
        {
          temp = temp.next;
        }
        return temp;
    }

    public static Node nthNode2(Node head ,int n)  // if we want to return the nth node instead of 
                                                    //deleting it 
    {
        Node slow = head;
        Node fast = head;

        for(int i=0;i<n;i++)
        {
            fast=fast.next;
        }
        while(fast!=null)
        {
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }

    public static Node deleteNthNode(Node head, int n)
    {
        Node slow = head;  // intializing both slow & fast with head
        Node fast = head;

        for(int i=0;i<n;i++)        // iterating fast till n times 
        {
            if(fast.next==null)   // base case if 1 node in the list
            return head.next;
            fast = fast.next;
        }
        
        while(fast.next!=null)    // afer iterating b times moving both slow & fast 
                                    // pointers till node before deletion
        {
            slow= slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;  // removing the n node from the list and returning head
          return head;
    }

    static void display(Node head) {
        Node temp = head;
        while (temp != null) {

            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();

    }
    public static class Node
    {
        int data;
        Node next;

        public Node(int data)
        {
            this.data=data;
        }
    }
    public static void main(String [] args)
    {
          Node a = new Node(1);
          Node b = new Node(2);
          Node c = new Node(3);
          Node d = new Node(4);
          Node e = new Node(5);
         

          a.next=null;
        //  b.next=c;
          //c.next=d;
          //d.next=e;
          
            // 100,13,4,5,12,10
          //  Node temp = nthNode(a, 3);
         // Node temp = nthNode(a, 2);
           // Node temp = nthNode2(a, 4);
         // System.out.print(temp.data);
         display(a);
        a= deleteNthNode(a, 1);
         display(a);
    }
}
/*
 Pseudocode for above code

i) first take 2 pointers slow and fast 
-> Intialise them with head slow = head; fast=head;
ii) iterate fast pointers B times
-> by doing this fast pointer will reach till Bth node
iii)now run the while loop till fast!=null & move slow and fast pointers by 1x speed
->as soon as fast.next==null loop breaks
iv) we reach to a node that is before the node we want to remove
-> and then we remove the nth node by doing slow.next = slow.next.next;
5) and we return the head

edge case 
when list =1 and n=1 we need to return empty 
-> so when we iterate b times loop we check fast.next ==null if yes we return head.next
as we need to return empty list


T:C : o(n)

-> Overall, the dominant factor in the time complexity is the second loop, 
which runs in O(n) time. Therefore, the total time complexity of the code is O(n).

S:C : o(1)


The code uses a constant amount of extra space for the slow and fast pointers, 
regardless of the size of the input linked list. 
Therefore, the space complexity of the code is O(1).
 */