/*

  Question :  Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.

Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.

https://leetcode.com/problems/middle-of-the-linked-list/

*/


public class MiddleElementofLL {
    

     public static class Node
        {
            int data;
             Node next;
             
             public Node(int data)
             {
                this.data = data;
             }
        }

        public  static Node middleNode(Node head)
        {
            Node slow = head;
            Node fast = head;
            while(fast!=null && fast.next!=null) // to find the middle element if even index left middle will be return
     // while(fast!=null && fast.next.next!=null) to find the middle element if even index right middle will be return
            {
                slow= slow.next;
                fast = fast.next.next;
            }
            return slow;
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
         
        Node a = new Node(1);
          Node b = new Node(2);
          Node c = new Node(3);
          Node d = new Node(4);
          Node e = new Node(5);
          Node f = new Node(6);

          a.next =b;
          b.next=c;
          c.next=d;
          d.next=e;
          e.next=f;

          
          //display(a);
        //  middleNode(a);
         // display(a);

         Node middle = middleNode(a); // Store the result of middleNode function
         System.out.println("Middle element: " + middle.data); // Print the middle element
 
    }
}


/*
 Pseudocode of above code

 1)Intialise 2 pointers slow and fast 
 2) move slow (1x) and fast (2x) speed
 3) while condition is such if we have even nodes we dont want our fast.next
  to be null so fast.next!=null
  -> And for odd nodes we dont want our fast to be null so used fast!=null
  4) we return slow as we found our middle ele 
  5) in even nodes we majorly return right middle ele most times
  for left middle ele we can use fast.next.next!=null
 */