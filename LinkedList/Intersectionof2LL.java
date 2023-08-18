
/*
   Question : Intersection of 2 lists

   https://leetcode.com/problems/intersection-of-two-linked-lists/

   Given the heads of two singly linked-lists headA and headB, 
   return the node at which the two lists intersect. 
   If the two linked lists have no intersection at all, return null.

For example, the following two linked lists begin to intersect at node c1:


The test cases are generated such that there are no cycles anywhere in the entire linked structure.

Note that the linked lists must retain their original structure after the function returns.


 */
public class Intersectionof2LL {
    
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

    public static Node intersectionOfLists(Node head1, Node head2) {
        // Initialize two pointers to traverse the linked lists
        Node tempA = head1;
        Node tempB = head2;
    
        // Calculate the length of the first linked list (list A)
        int lengthA = 0;
        while (tempA != null) {
            lengthA++;
            tempA = tempA.next;
        }
    
        // Calculate the length of the second linked list (list B)
        int lengthB = 0;
        while (tempB != null) {
            lengthB++;
            tempB = tempB.next;
        }
    
        // Reset the pointers to the beginning of the linked lists
        tempA = head1;
        tempB = head2;
    
        // Adjust the starting position of the longer list
        if (lengthA > lengthB) {
            int steps = lengthA - lengthB;
            for (int i = 0; i < steps; i++) {
                tempA = tempA.next;
            }
        } else {
            int steps = lengthB - lengthA;
            for (int i = 0; i < steps; i++) {
                tempB = tempB.next;
            }
        }
    
        // Traverse both lists simultaneously until intersection or end is found
        while (tempA != tempB && tempA != null && tempB != null) {
            tempA = tempA.next;
            tempB = tempB.next;
        }
    
        // At this point, tempA and tempB are either the intersection point or null
        return tempA; // Return the intersection node (or null if no intersection)
    }
  public static void main(String[] args) {
    // Creating linked list A: 1 -> 3 -> 5 -> 8 -> 9
    Node a = new Node(1);
    Node b = new Node(3);
    Node c = new Node(5);
    Node d = new Node(18);
    Node e = new Node(9);

    a.next = b;
    b.next = c;
    c.next = d;
    d.next = e;

    // Creating linked list B: 8 -> 9
   
    Node x = new Node(18);
    Node y = new Node(9);

   
    x.next = y;
    y.next = d; // Intersection point with list A

    // Finding the intersection point
    Node intersectionNode = intersectionOfLists(a, x);

    // Printing the intersection point value (or null if no intersection)
    if (intersectionNode != null) {
        System.out.println("Intersection Point: " + intersectionNode.val);
    } else {
        System.out.println("No Intersection");
    }
}
}

/*
 Pseudocode for above code

 1)take 2 temp pointers intialise them with given head of the 2 lists
 2)we will take out length of the lists individually
 3) store the length of the lists in a variable
 4)reintialize temp pointers to head of the lists
 ->bcoz both have traveled till node to take out length of the lists
 5)compare the lengths of the lists whose length is bigger
 -> we are adjusting the startng position of the longer lists
 means if listA is longer than listB we are moving listsA few steps ahead so both lists
 can check for intersection point at same place
 
 6)after that reaching at same point lists will start checking for intersecting point 
 if intersects it will return the node else null

 */