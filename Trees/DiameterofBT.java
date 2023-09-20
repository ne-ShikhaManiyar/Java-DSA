
/*
  Question : Diameter of Binary Tree (leetcode 543)

  https://leetcode.com/problems/diameter-of-binary-tree/description/
 */

import java.util.*;

public class DiameterofBT
{

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
    // Function to print a binary tree using inorder traversal
    public static void printTree(TreeNode root) {
        if (root == null)
            return;

        // Recursively print left subtree
        printTree(root.left);

        // Print the current node's value
        System.out.print(root.val + " ");

        // Recursively print right subtree
        printTree(root.right);
    }

    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Print the binary tree
        System.out.print("Binary Tree: ");
        printTree(root);
        System.out.println();

        // Calculate and print the diameter of the binary tree
        int diameter = Diameter(root);
        System.out.println("Diameter of the Binary Tree: " + diameter);
    }

    public static int height(TreeNode root)
    {
        if(root==null ||(root.left==null && root.right==null))
        return 0;

        return 1+Math.max(height(root.left),height(root.right));

    }

    // Function to calculate the diameter of a binary tree
    public static int Diameter(TreeNode root)
    
    {
        // If the tree is empty or a leaf node, return 0 as there's no diameter
        if(root==null ||(root.left==null && root.right==null))
        return 0;

    // Recursively calculate the diameter of the left and right subtrees
        int left = Diameter(root.left);
        int right = Diameter(root.right);

        // Calculate the diameter passing through the current node (if it exists)
        int mid = height(root.left) + height(root.right);
        if(root.left!=null) mid++;
        if(root.right!=null) mid++;
         // Return the maximum of left, right, and mid diameters
        int max = Math.max(left,Math.max(right, mid));
        return max;
    }
}
/*
  Explanation of above code

1) we would first take diameter of left subtree
2) then we would take diameter of right subtree
3)then we find out mid with help of height function(as helper)
4) then if root left is not null (not an skew tree) we would increment mid
5)then if root right is not null (not an skew tree) we would increment mid
6) we find the max of left,right and mid 
7) and return the max diameter of binary tree



 */