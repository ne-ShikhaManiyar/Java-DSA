import java.util.Stack;

public class Reversestack {

    // Helper function to push an element 'x' at the bottom of the stack 'stk'
    public static void pushAtBottom(Stack<Integer> stk, int x) {
        // If the stack is empty, directly push the element 'x'
        if (stk.size() == 0) {
            stk.push(x);
            return;
        }
        
        // If the stack is not empty, pop the top element
        int top = stk.pop();
        
        // Recursively call pushAtBottom to push 'x' at the bottom
        pushAtBottom(stk, x);
        
        // After 'x' is pushed at the bottom, push the original top element back to the stack
        stk.push(top);
    }

    // Function to reverse the elements of the stack using recursion
    public static void Reverse(Stack<Integer> stk) {
        // Base case: If the stack has only one element or is empty, return
        if (stk.size() == 1 || stk.isEmpty())
            return;

        // Pop the top element from the stack
        int top = stk.pop();

        // Recursively call Reverse to reverse the remaining elements in the stack
        Reverse(stk);

        // After the stack is reversed, push the original top element at the bottom
        pushAtBottom(stk, top);
    }

    public static void main(String[] args) {
        // Create a stack of integers
        Stack<Integer> stk = new Stack<>();
        stk.push(11);
        stk.push(12);
        stk.push(13);
        stk.push(14);

        System.out.println("Original Stack: " + stk);

        // Call the Reverse function to reverse the stack
        Reverse(stk);

        System.out.println("Reversed Stack: " + stk);
    }
}



//https://onecompiler.com/java/3zfgdjyrz

//Explanation

/*
 
1)The code defines a class Reversestack.
2)It includes two static methods: pushAtBottom and Reverse, and the main method.
3)The pushAtBottom method is a helper function that takes a stack (stk) and an integer (x)
 as parameters and pushes the element x at the bottom of the stack using recursion.
  If the stack is empty, it directly pushes the element x.
4)The Reverse method is the main function that takes a stack (stk) as a parameter and 
recursively reverses the elements in the stack by using the pushAtBottom function. 
It pops the top element from the stack, reverses the remaining elements, and then pushes 
the top element at the bottom.
5)The main method creates a stack stk of integers and pushes four elements (11, 12, 13, 14) into it.
6)It then prints the original stack using System.out.println(stk).
7)Next, it calls the Reverse function to reverse the elements of the stack.
8)Finally, it prints the reversed stack using System.out.println(stk).


 */