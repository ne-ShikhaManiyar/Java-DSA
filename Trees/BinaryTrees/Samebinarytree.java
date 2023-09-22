/*

   Question : same tree (100)

  https://leetcode.com/problems/same-tree/

  https://www.interviewbit.com/problems/identical-binary-trees/
 */

public class Samebinarytree {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Samebinarytree solution = new Samebinarytree(); // Create an instance of the class
        TreeNode tree1 = solution.createTree1(); // Create the first binary tree
        TreeNode tree2 = solution.createTree2(); // Create the second binary tree

        // Print the two binary trees
        System.out.println("Tree 1:");
        solution.printTree(tree1, 0);

        System.out.println("\nTree 2:");
        solution.printTree(tree2, 0);

        // Check if the two binary trees are the same
        boolean areSame = solution.isSame(tree1, tree2);

        if (areSame) {
            System.out.println("\nThe two binary trees are the same.");
        } else {
            System.out.println("\nThe two binary trees are not the same.");
        }
        
        // Calculate time complexity: O(min(N, M)) where N and M are the numbers of nodes in tree1 and tree2.
        // Calculate space complexity: O(min(H1, H2)) where H1 and H2 are the heights of tree1 and tree2.
    }

    // Function to create the first binary tree
    public TreeNode createTree1() {
        // Example: Tree with values 1, 2, and 3
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        return root;
    }

    // Function to create the second binary tree
    public TreeNode createTree2() {
        // Example: Tree with values 1, 2, and null
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = null;
        return root;
    }

    // Function to print a binary tree
    public void printTree(TreeNode root, int level) {
        if (root == null) return;

        // Print right subtree
        printTree(root.right, level + 1);

        // Indent based on the level
        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }

        // Print the value of the current node
        System.out.println(root.val);

        // Print left subtree
        printTree(root.left, level + 1);
    }

    // Function to check if two binary trees are the same
    public boolean isSame(TreeNode p, TreeNode q) {
        // If both nodes are null, they are the same
        if (p == null && q == null) return true;

        // If one node is null and the other is not, they are different
        if (p == null || q == null) return false;

        // If the values of the current nodes are not the same, they are different
        if (p.val != q.val) return false;

        // Recursively check the left and right subtrees
        return isSame(p.left, q.left) && isSame(p.right, q.right);
    }
}

/*
  Explanation of above code 

  1) If both nodes p & q are null, they are the same return true
  2)If any  one node is null and the other is not, they are different return false
  3)If the values of the current nodes are not the same, they are different return false
  4) Recursively check the left and right subtrees if all condition satisifes it would return true;



  Time Complexity: The time complexity of the isSame function is O(min(N, M)), 
  where N and M are the numbers of nodes in tree1 and tree2, respectively, as it 
  performs a depth-first traversal of both trees simultaneously.

Space Complexity: The space complexity of the isSame function is O(min(H1, H2)), 
where H1 and H2 are the heights of tree1 and tree2, respectively, as it uses a 
recursive call stack to traverse the trees.
 */


/*
    // other solution when we have return type has int so we cant use && directly need to store in variable

   public class Solution {
    public int isSameTree(TreeNode A, TreeNode B) {
        
        if(A==null && B==null) return 1;
        if(A==null || B==null) return 0;
        if(A.val!=B.val) return 0;
        
        int leftresult = isSameTree(A.left,B.left);
        int rightresult = isSameTree(A.right,B.right);
        
        if(leftresult==1 && rightresult== 1)
        return 1;
        else return 0;
    }
}

 */