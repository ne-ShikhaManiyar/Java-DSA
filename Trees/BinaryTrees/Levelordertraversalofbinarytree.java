/*
    https://leetcode.com/problems/binary-tree-level-order-traversal/ (leetcode 102)
 */


import java.util.*;
public class Levelordertraversalofbinarytree {
    

    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode() {}
             TreeNode(int val) { this.val = val; }
             TreeNode(int val, TreeNode left, TreeNode right) {
                 this.val = val;
                 this.left = left;
                this.right = right;
             }
         }


         public static void main(String[] args)
         {

         }

         public int height(TreeNode root) {
            // Function to calculate the height of the binary tree.
            // If the root is null or a leaf node, return 0.
            if (root == null || (root.left == null && root.right == null))
                return 0;
        
            // Recursively compute the height as 1 plus the maximum height
            // of the left and right subtrees.
            return 1 + Math.max(height(root.left), height(root.right));
        }
        
        public void nthlevel(TreeNode root, ArrayList<Integer> ans, int n) {
            // Function to collect values of nodes at a specific level 'n'.
            if (root == null)
                return;
            if (n == 1) {
                // If 'n' is 1, we've reached the desired level, so add the
                // value of the current node to the 'ans' ArrayList.
                ans.add(root.val);
                return;
            }
        
            // Recursively call 'nthlevel' on left and right children with 'n' decremented by 1.
            nthlevel(root.left, ans, n - 1);
            nthlevel(root.right, ans, n - 1);
        }
        
        public ArrayList<ArrayList<Integer>> solve(TreeNode root) {
            // Main function to perform level-order traversal and collect values at each level.
            int height = height(root) + 1; // Calculate the height of the tree.
            ArrayList<ArrayList<Integer>> list = new ArrayList<>(); // Initialize the result list.
        
            if (root == null)
                return list; // If the root is null, return an empty list.
        
            for (int i = 1; i <= height; i++) {
                // Iterate through each level from 1 to the height.
                ArrayList<Integer> ans = new ArrayList<>(); // Create a list for the current level.
                nthlevel(root, ans, i); // Call 'nthlevel' to collect values at the current level.
                list.add(ans); // Add the current level's list to the result list.
            }
        
            return list; // Return the list of lists containing values at each level.
        }

}

/*

Explanation of code


1) height of tree 
->  This function calculates the height of the binary tree.
->  It's a recursive function that returns the height of the tree rooted at the given node root. 
-> If the node is null or a leaf node (i.e., it has no left or right children), the height is
 considered to be 0. 
 -> Otherwise, it computes the height as 1 plus the maximum of the heights
  of the left and right subtrees.

nthlevel Function:

2)This function is used to collect values of nodes at a specific level 'n' in a binary tree.
-> If the current node is null, it means you've reached the end of a branch, so the function returns.
-> If 'n' is 1, it means you've reached the desired level, and the function adds the
 value of the current node to the 'ans' ArrayList.
-> If 'n' is greater than 1, it means you need to traverse down one level. 
-> So, it recursively calls itself on the left and right children with 'n' decremented by 1.
-> when we call function intially asking the function to collect values at level n in the binary tree.

Inside the function, n is checked(while doing n-1)
-> If n is 1, it means you've reached the desired level, and you add the value of the current node
 to the ans ArrayList.
-> If n is greater than 1, it means you haven't reached the desired level yet.
 In this case, you need to traverse down to the next level. To do that, you recursively call nthlevel 
 on the left and right subtrees with n - 1. 
 -> This effectively reduces the level you're looking for by one and continues the traversal.



3)solve Function:
->This is the main function for performing a level-order traversal of the binary tree.
->It calculates the height of the tree (in terms of levels) and stores it in the 'height' variable.
-> So, when you calculate the height with + 1, you are essentially
 counting the number of levels in the tree. If you don't add + 1,
  you are counting the number of edges along the longest path from the root to a leaf. 
-> It initializes an empty 'list' to store the result, which will be a list of lists
 containing values at each level.
-> If the 'root' is null, indicating an empty tree, it returns an empty 'list'.
-> It iterates from level 1 to the calculated height, and for each level:
-> It creates a new 'ans' ArrayList to store the values at that level.
-> Calls the 'nthlevel' function to collect values at the current level.
-> Adds the 'ans' list to the 'list' of lists.
-> Finally, it returns the 'list' containing values at each level.

TC:o(n)
SC : o(n)


   
 */
