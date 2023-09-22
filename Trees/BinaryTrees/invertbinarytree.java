/*

   https://www.interviewbit.com/problems/invert-the-binary-tree/

   https://leetcode.com/problems/invert-binary-tree/description/
 */


public class invertbinarytree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public TreeNode invert(TreeNode root) {
        if (root == null) {
            return null;
        }

        // Swap the left and right subtrees
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively swap the left and right subtrees of the children
       invert(root.left);
        invert(root.right);

        return root;
    }

    // Utility function to print the binary tree (inorder traversal)
    public void printTree(TreeNode root) {
        if (root == null) {
            return;
        }

        printTree(root.left);
        System.out.print(root.val + " ");
        printTree(root.right);
    }

    public static void main(String[] args) {
        invertbinarytree tree = new invertbinarytree();

        // Construct a sample binary tree
        TreeNode root = tree.new TreeNode(1);
        root.left = tree.new TreeNode(2);
        root.right = tree.new TreeNode(3);
        root.left.left = tree.new TreeNode(4);
        root.left.right = tree.new TreeNode(5);

        System.out.println("Original tree:");
        tree.printTree(root);

        TreeNode swappedRoot = tree.invert(root);

        System.out.println("\nTree after swapping left and right subtrees:");
        tree.printTree(swappedRoot);

    }
}

/*
   TC: o(n) we would traverse all nodes so o(n)
   SC : o(h) we would traverse all nodes in recursive stack

   Explanation of above code

   1)base case : need to check root node is null or not 

   2) then do swaping of nodes bcoz at all levels we do  swapping to make invert of original tree

   3) then we call the function recursively for left & right subtree respectively

   4) and then return the root
 */