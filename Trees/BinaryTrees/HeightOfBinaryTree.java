/*
  You are given the root node of a binary tree A. 
  You have to find the height of the given tree.

A binary tree's height is the number of nodes along the
 longest path from the root node down to the farthest leaf node.

 Input 1:

 Values =  1 
          / \     
         4   3                        
Input 2:

 
 Values =  1      
          / \     
         4   3                       
        /         
       2                                     


Example Output
Output 1:2 
Output 2:3

Explanation 1:

 Distance of node having value 1 from root node = 1
 Distance of node having value 4 from root node = 2 (max)
 Distance of node having value 3 from root node = 2 (max)


Explanation 2:
 Distance of node having value 1 from root node = 1
 Distance of node having value 4 from root node = 2
 Distance of node having value 3 from root node = 2
 Distance of node having value 2 from root node = 3 (max)
 */


public class HeightOfBinaryTree {
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
        // Create a binary tree
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(2);

        // Calculate the height of the binary tree
        int result = solve(root);

        // Print the result
        System.out.println("Height of the binary tree: " + result);
    }

    // Function to calculate the height of a binary tree
    public static int solve(TreeNode root) {
        // Base case: If the root is null or it's a leaf node (no children),
        // the height is 0.
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }

        // Recursive case: Calculate the height of the left and right subtrees,
        // and return the maximum height plus 1 (to account for the current level).
        return 1 + Math.max(solve(root.left), solve(root.right));
    }
}

/*
  Explanation of the solve function:

1)The solve function calculates the height (also known as the depth) of a binary tree using
 a recursive approach.
2)It starts with a base case: If the root is null or it's a leaf node (has no left or right children), 
the height is considered to be 0.
3)In the recursive case, it calculates the height of the left and right 
subtrees by recursively calling the solve function on the left and right children.
4)It then returns the maximum of the heights of the left and right subtrees,
 plus 1 to account for the current level.

 TC: O(N), where N is the number of nodes in the binary tree. 
 SC : O(H), where H is the height of the binary tree. This is due to the recursive calls 
 in the function, which create a call stack of maximum depth equal to the height of the tree.
 */