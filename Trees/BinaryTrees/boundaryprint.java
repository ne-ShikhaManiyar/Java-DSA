import java.util.*;
 
// Definition of a binary tree node
class Node {
    int data;
    Node left, right;
 
    // Constructor to create a new binary tree node
    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}
 
class BinaryTree {
    // Function to print the left boundary nodes of a binary tree
    static void printLeftBoundary(Node root) {
        if (root == null) {
            return;
        }
        if (root.left != null || root.right != null) {
            System.out.print(root.data + " ");
        }
        if (root.left != null) {
            printLeftBoundary(root.left);
        } else {
            printLeftBoundary(root.right);
        }
    }
 
    // Function to print the right boundary nodes of a binary tree
    static void printRightBoundary(Node root) {
        if (root == null) {
            return;
        }
        if (root.right != null) {
            printRightBoundary(root.right);
        } else {
            printRightBoundary(root.left);
        }
        if (root.left != null || root.right != null) {
            System.out.print(root.data + " ");
        }
    }
 
    // Function to print the leaves of a binary tree
    static void printLeaves(Node root) {
        if (root == null) {
            return;
        }
        printLeaves(root.left);
        if (root.left == null && root.right == null) {
            System.out.print(root.data + " ");
        }
        printLeaves(root.right);
    }
 
    // Function to print the boundary nodes of a binary tree in anticlockwise order
    static void printBoundary(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        printLeftBoundary(root.left);
        printLeaves(root.left);
        printLeaves(root.right);
        printRightBoundary(root.right);
    }
 
    // Driver code
    public static void main(String[] args) {
        // Creating the binary tree
        Node root = new Node(20);
        root.left = new Node(8);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.right = new Node(22);
        root.right.right = new Node(25);
 
        // Printing the boundary nodes of the binary tree
        printBoundary(root);
    }
   
}


/*
      boundary traversal with arraylist

      public class Solution {
    // Function to check if a given TreeNode is a leaf node.
    public boolean isLeaf(TreeNode A) {
        return (A.left == null) && (A.right == null);
    }

    // Function to traverse the left boundary of the tree and add non-leaf nodes to ans.
    public void leftboundary(TreeNode A, ArrayList<Integer> ans) {
        TreeNode temp = A.left;
        while (temp != null) {
            if (isLeaf(temp) == false) // If it's not a leaf node, add its value to ans.
                ans.add(temp.val);
            if (temp != null)
                temp = temp.left; // Move to the left child.
            else
                temp = temp.right; // If left child is null, move to the right child.
        }
    }

    // Function to traverse the right boundary of the tree and add non-leaf nodes to ans.
    public void rightboundary(TreeNode A, ArrayList<Integer> ans) {
        TreeNode temp = A.right;
        ArrayList<Integer> list = new ArrayList<Integer>(); // Temporary list to store values.
        while (temp != null) {
            if (isLeaf(temp) == false) // If it's not a leaf node, add its value to the list.
                list.add(temp.val);
            if (temp != null)
                temp = temp.right; // Move to the right child.
            else
                temp = temp.left; // If right child is null, move to the left child.
        }
        int i;
        // Add values from the list in reverse order to ans.
        for (i = list.size() - 1; i >= 0; i--) {
            ans.add(list.get(i));
        }
    }

    // Function to add leaf nodes to ans.
    public void addLeaves(TreeNode A, ArrayList<Integer> ans) {
        if (isLeaf(A)) {
            ans.add(A.val); // If it's a leaf node, add its value to ans.
            return;
        }
        if (A.left != null)
            addLeaves(A.left, ans); // Recursively process left subtree.
        if (A.right != null)
            addLeaves(A.right, ans); // Recursively process right subtree.
    }

    // Main function to solve the problem.
    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<Integer>(); // Initialize the result list.
        if (isLeaf(A) == false)
            ans.add(A.val); // If the root is not a leaf node, add its value to ans.
        leftboundary(A, ans); // Traverse and add left boundary.
        addLeaves(A, ans); // Add leaf nodes.
        rightboundary(A, ans); // Traverse and add right boundary.
        return ans; // Return the final result.
    }
}

Explanation of above code

Approach: Boundary traversal in an anti-clockwise direction can be described as a traversal 
consisting of three parts:

Part 1: Left Boundary of the tree (excluding the leaf nodes).
Part 2: All the leaf nodes travelled in the left to right direction.
Part 3: Right Boundary of the tree (excluding the leaf nodes), traversed in the reverse direction.
-> We take a simple data structure like a vector/Arraylist to store the Boundary Traversal.
-> The root node is coming from both the boundaries (left and right). 
-> Therefore, to avoid any confusion, we push it on our list at the very start.


Part 1:  Left Boundary
-> To traverse the left boundary, we can set a simple iteration. 
-> Initially, we make the cur pointer point to the root’s left. In every iteration,
 if the cur node is not a leaf node, we print it. Then we always try to move left of the cur pointer.
 ->  If there is no left child, then we move to the right of cur and in the next iteration, 
 again try to move to the left first. We stop our execution when cur is pointing to NULL. 

Part 2: Leaf nodes
-> To print the leaf nodes, we can do a simple preorder traversal, and check if the current node 
is a leaf node or not. If it is a leaf node just print it.
-> Please note that we want the leaves to come in a specific order which is bottom-left to top-right,
 therefore a level order traversal will not work because it will print the upper-level leaves first. 
 -> Therefore, we use a preorder traversal.

Part 3: Right Boundary
-> We need to print the right boundary in the Reverse direction. It is very similar to the left boundary
 traversal. 
 -> We initialize our cur pointer to the right child of the root node and set an iterative loop. 
 -> To achieve the reverse direction, we take an auxiliary list. In every iteration, we check if the 
 current node is not a leaf node then we push it to the auxiliary list. 
 ->Then we first try to move right of cur, if there is no right child only then we move left.
 -> We stop our execution once cur points to NULL.
-> Now the auxiliary list contains the nodes of the right boundary.
-> We iterate from the end to start off this list and in every iteration, 
 push the value to our main boundary traversal list. 
 ->This way we get the nodes in the reverse direction.

TC: o(n)
SC:o(H) (height of tree) ~ o(n) as it will visit to all nodes

 */