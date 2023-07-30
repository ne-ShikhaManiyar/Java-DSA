import java.util.Stack;

public class LLImplementationStack {
    
    // Inner class representing a node in the linked list
    public static class Node {  

        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    // User-defined stack data structure using a linked list
    public static class LLStack {

        private Node head = null;
        private int size = 0;

        // Method to push an element onto the stack
        void push(int x) {
            Node temp = new Node(x);
            temp.next = head;
            head = temp;
            size++;
        }

        // Recursive method to display the elements of the stack in reverse order
        void displayRec(Node h) {
            if (h == null)
                return;
            displayRec(h.next);
            System.out.print(h.val + " ");
        }

        // Method to display the elements of the stack
        void display() {
            displayRec(head);
            System.out.println();
        }

        // Method to display the elements of the stack in the order they were pushed
        void displayRev() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
            System.out.println();
        }

        // Method to get the size of the stack
        int size() {
            return size;
        }

        // Method to pop the top element from the stack
        int pop() {
            if (head == null) {
                System.out.print("Stack is Empty");
                return -1;
            }
            int x = head.val;
            head = head.next;
            size--;
            return x;
        }

        // Method to peek at the top element without removing it
        int peek() {
            if (head == null) {
                System.out.print("Stack is Empty");
                return -1;
            }
            return head.val;
        }

        // Method to check if the stack is empty
        boolean isEmpty() {
            return size == 0;
        }
    }

    public static void Main(String[] args) {
        LLStack st = new LLStack();
        
        // Pushing elements onto the stack
        st.push(4);
        st.push(10);
        st.push(1);

        // Displaying the elements of the stack
        st.display();

        // Getting the size of the stack and displaying it
        System.out.println(st.size());

        // Popping an element from the stack and displaying the updated stack
        st.pop();
        st.display();

        // Pushing more elements onto the stack and displaying the updated stack
        st.push(7);
        st.push(20);
        st.push(18);
        st.display();

        // Pushing another element onto the stack and displaying the updated stack
        st.push(90);
        st.display();
    }
}
