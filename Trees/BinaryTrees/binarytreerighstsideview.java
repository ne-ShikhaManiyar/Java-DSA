

/*

https://leetcode.com/problems/binary-tree-right-side-view/

*/

import java.util.*;

public class binarytreerighstsideview {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        // Create a binary tree for testing
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        binarytreerighstsideview solution = new binarytreerighstsideview();
        ArrayList<Integer> rightSideView = solution.solve(root);

        // Print the right side view of the binary tree
        System.out.println("Right Side View of Binary Tree: " + rightSideView);
    }

    public ArrayList<Integer> solve(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        rightview(root, ans, 0);
        return ans;
    }

    public void rightview(TreeNode root, ArrayList<Integer> ans, int level) {
        if (root == null)
            return;

        if (level == ans.size()) {
            ans.add(root.val);
        }

        // Traverse the right subtree before the left subtree
        rightview(root.right, ans, level + 1);
        rightview(root.left, ans, level + 1);
    }
}
/*
 
TC: o(N)  where N is the number of nodes in the binary tree. 
This is because we visit each node exactly once.

SC:where H is the height of the binary tree. In the worst case 
(a skewed tree), the space complexity would be O(N), and in a balanced tree, it would be O(log N).


Explanation of above code :

-> This method initializes an empty ArrayList<Integer> called ans 
to store the right-side view of the binary tree.
-> It then calls the rightview method, starting from the root node, and 
passes the ans list and the initial level, which is set to 0.
-> Finally, it returns the ans list containing the right-side view.

-> rightview(TreeNode root, ArrayList<Integer> ans, int level):

This method performs a depth-first traversal of the binary tree.
-> it performs reverse postorder recursively (root,right,left)
It takes three parameters:
root: The current node being processed.
ans: The list to store the right-side view.
level: The current level in the traversal.
-> If the root node is null, the method returns without performing any action,
 as there's nothing to process at this node.
-> If the current level is equal to the size of the ans list, 
it means we have reached a new level in the tree. In this case, 
we add the root.val to the ans list, as it represents the rightmost node at that level.
-> The method then recursively calls rightview on the right subtree (root.right) before the 
left subtree (root.left). This ensures that the rightmost nodes are processed first at each level.

-> for left view of binary tree same process

but it performs  postorder recursively (root,left,right)
 */