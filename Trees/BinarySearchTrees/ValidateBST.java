/*
   Question : validate bst

   https://www.interviewbit.com/problems/valid-binary-search-tree/

 */

package BinarySearchTrees;

import java.util.ArrayList;

public class ValidateBST {

    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

    }

    public int isValidBST(Node A) {
        // Function to check if a binary tree is a valid Binary Search Tree (BST).

        // If the tree is empty (null), it's considered a valid BST.
        if (A == null)
            return 1;

        // Create an ArrayList to store node values in ascending order.
        ArrayList<Integer> ans = new ArrayList<>();

        // Perform an inorder traversal of the tree to populate the ArrayList.
        helper(A, ans);

        // Initialize a flag isBST as 1 (true), assuming it's a valid BST.
        int isBST = 1;

        // Initialize a variable prev with the first element in ans (the smallest
        // value).
        int prev = ans.get(0);

        // Iterate through the ArrayList starting from the second element.
        for (int i = 1; i < ans.size(); i++) {
            // Check if the current element is less than or equal to the previous element.
            if (ans.get(i) <= prev)
                // If this condition is true, it indicates the tree is not a valid BST,
                // so set isBST to 0 (false).
                isBST = 0;

            // Update prev with the current element for the next comparison.
            prev = ans.get(i);
        }

        // Return the value of isBST (1 for true if it's a valid BST, 0 for false if
        // it's not).
        return isBST;
    }

    void helper(Node A, ArrayList<Integer> ans) {
        // Helper function to perform an inorder traversal of the binary tree
        // and populate the ArrayList ans with node values in ascending order.

        // If the current node is null (empty), return.
        if (A == null)
            return;

        // Recursively traverse the left subtree.
        helper(A.left, ans);

        // Add the value of the current node to the ArrayList ans.
        ans.add(A.val);

        // Recursively traverse the right subtree.
        helper(A.right, ans);
    }
}

/*
1) The isValidBST function checks if a binary tree is a valid BST by performing an inorder traversal
 and comparing node values.
2)The helper function is a recursive helper function that performs an inorder traversal of the tree, 
collecting node values in ascending order.
3)In the isValidBST function, it initializes a flag isBST as 1 (true) by default,
 assuming the tree is a valid BST.
4)It iterates through the ArrayList ans, which contains node values in ascending order, and
 -> checks if each value is greater than the previous value. If any value is not greater or equal, 
 it sets isBST to 0 (false).
5)Finally, the function returns the value of isBST, indicating whether the tree is a
 valid BST or not (1 for true, 0 for false).

 TC: o(N) as it will visit all nodes of tree
 SC : o(H) height of tree(recursive stack)
 */