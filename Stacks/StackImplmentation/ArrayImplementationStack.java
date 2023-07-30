import java.util.Stack;

public class ArrayImplementationStack {

    // Inner class representing a stack
    public static class Stack {

        private int arr[] = new int[5]; // Array to store the elements of the stack
        private int idx = 0; // Index to keep track of the top element position

        // Method to push an element onto the stack
        void push(int x) {
            if (isFull()) { // Check if the stack is full
                System.out.print("Stack is Full");
                return;
            }
            arr[idx] = x; // Add the element to the top of the stack
            idx++; // Increment the index
        }

        // Method to peek at the top element of the stack without removing it
        int peek() {
            if (idx == 0) { // Check if the stack is empty
                System.out.print("Stack is Empty");
                return -1;
            }
            return arr[idx - 1]; // Return the top element of the stack
        }

        // Method to pop the top element from the stack
        int pop() {
            if (idx == 0) { // Check if the stack is empty
                System.out.print("Stack is Empty");
                return -1;
            }
            int top = arr[idx - 1]; // Get the top element of the stack
            arr[idx - 1] = 0; // Remove the element by setting it to 0 (optional step)
            idx--; // Decrement the index to remove the top element
            return top; // Return the popped element
        }

        // Method to display the elements of the stack
        void display() {
            for (int i = 0; i < idx; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

        // Method to get the size of the stack
        int size() {
            return idx;
        }

        // Method to check if the stack is empty
        boolean isEmpty() {
            return idx == 0;
        }

        // Method to check if the stack is full
        boolean isFull() {
            return idx == arr.length;
        }

        // Method to get the capacity of the stack
        int capacity() {
            return arr.length;
        }
    }

    public static void main(String[] args) {

        Stack st = new Stack(); // Create an instance of the Stack class

        // Push elements onto the stack
        st.push(4);
        st.push(10);
        st.push(1);
        st.display(); // Display the stack elements
        System.out.println(st.size()); // Print the size of the stack
        st.peek();
        st.pop(); // Pop the top element
        st.display(); // Display the updated stack
        st.push(7);
        st.push(20);
        st.push(18);
        st.display(); // Display the updated stack
        // System.out.println(st.isFull()); // Check if the stack is full (uncomment if needed)
        // st.push(90); // Uncommenting this line will cause "Stack is Full" message
        st.capacity(); // Get the capacity of the stack
    }
}



