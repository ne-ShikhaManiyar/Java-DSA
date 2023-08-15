/*

Question : Palindrome LL
https://leetcode.com/problems/palindrome-linked-list/



 */

public class PalindromeLL {
    
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
        Node curr = head;
        Node prev = null;
        Node forw = null;

        while(curr!=null)
        {
            forw = curr.next;
            curr.next =prev;
            prev = curr;
            curr = forw;
        }
        return prev;
    }

    public static boolean isPalindromeList(Node head)
    {
        Node slow = head;
        Node fast = head;
        while(fast.next!=null && fast.next.next!=null)  // taking out middle for odd nodes and left middle 
                                                        // for even nodes
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node temp = Reverse(slow.next);  // reversing the 2nd half of LL (slow.next)
       slow.next = temp;      // storing 2nd half of LL in a temp node 

        Node p1 = head;  // creating 2 ppinters 2 compare the value from head
        Node p2 = temp;  // creating 2 ppinters 2 compare the value from reverse LL (slow.mext)

        while(p2!=null)  // if at any point p1!=p2 return false else true;
        {
            if(p1.data!=p2.data) return false;
            p1 =p1.next;
            p2 = p2.next;
        }
        return true;
    }


    public static void main(String [] args)
    {
      
        Node a = new Node(1);
        Node b = new Node(3);
        Node c = new Node(3);
        Node d = new Node(1);

        a.next =b;
        b.next=c;
        c.next=d;

        display(a);
        boolean palindrome = isPalindromeList(a);
        
        System.out.println(palindrome);
    }
}

/*
 Pseudocode 

 1) what is palindrome 
 -> first half and second half is same 

 eg : 1->2->3->3->2->1
 eg: 1->2->2->1


 2) so we required a reverse function for palindrome to reverse second half of the list 
 -> so we create a reverse function first

 3) inside palindrome function we create 2 pointers slow & fast intialise them with head

 4)we move slow (1x) and fast (2x)
 5) while loop condition we take out left middle for even nodes so we use fast.next.next 
 and for even nodes we use fast.next!=null

 6) create temp node and reverse the 2nd half of the list(slow.next)

 7)store reversed list in temp 

 8)create 2 pointers p1 & p2
 intialise p1 = head
 p2 = temp(basically slow.next reverse LL) 

 9)compare value of p1&p2 if not same return false else return true
 -> while loop will run till p2!=null

 */