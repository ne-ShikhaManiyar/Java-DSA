/*
   Question : Balanced Binary Tree(110)


   https://leetcode.com/problems/balanced-binary-tree/description/
 */


public class balancedBinaryTree {
    
    
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
        // Create a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        // Print the binary tree
        System.out.println("Binary Tree:");
        printTree(root, 0);

        // Check if the tree is balanced
        boolean isBalanced = balance(root);

        if (isBalanced) {
            System.out.println("The binary tree is balanced.");
        } else {
            System.out.println("The binary tree is not balanced.");
        }
        
     
    }

    // Function to print the binary tree
    public static void printTree(TreeNode root, int level) {
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


    public static int height(TreeNode root)
    {
       if(root ==null || (root.left==null && root.right==null))
        return 0;

        return 1+Math.max(height(root.left),height(root.right));
    }

    public static boolean balance(TreeNode root)
    {
        //base condition
        if(root==null) return false;
        //taking out height of left subtree
         int left = height(root.left);
         //if not an skewed left subtree then add left side height
         if(root.left!=null) left++;

        //taking out height of right subtree
         int right = height(root.right);

           //if not an skewed right subtree then add left side height
         if(root.right!=null) right++;

         //taking out the difference
         int diff = left-right;

         //if diff less than zero then multiply by mod (eg: left =2 & right =3 so diff =-1 which is fine so
         // making it positive by multiply by -1)
         if(diff<0) diff = -diff;

         if(diff > 1) return false;

         //bth will check if left subtree and right subtree balance at any level it is true;
         return balance(root.left) &&  balance(root.right);
    }
}

/*

Rule for balance binary tree

-> A balanced binary tree is a binary tree that follows the 3 conditions:
i)The height of the left and right tree for any node does not differ by more than 1.
ii)The left subtree of that node is also balanced.
iii) The right subtree of that node is also balanced.


Explanation of above code

i)base case if root==null return true;
ii)taking out height of left sbt with height helper function
iii)taking out height of right sbt with height helper function
iv)and we also checking if left sbt not an skewed tree then add left height++
(height from root to left node too)
v)and we also checking if right sbt not an skewed tree then add right height++
(height from root to right node too)
vi)we take out diff of left-right (to check whether it satisfies balance tree conditions)
vii)if(diff<0) then we diff = -d (it means if left =2 and right =3  2-3=-1)
-> so making it abs (so) multiplying by -1 so it would be 1
viii) if diff > 1 return false;
ix) at all level for left && right subtree it will check for balance and if all correct return true;


TC:As for the time complexity, your balance function has a
 time complexity of O(n^2) in the worst case because for each node,
  it calculates the height of its left and right subtrees

  SC: The space complexity is determined by the maximum depth 
  of the recursive call stack, which is equal to the height of the tree.
   So, the space complexity is O(h), where h is the height of the tree.
 */