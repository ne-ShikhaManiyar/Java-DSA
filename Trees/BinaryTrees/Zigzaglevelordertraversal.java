import java.util.*;

public class Zigzaglevelordertraversal
{


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
        
         // left to right (level order )
        public static void nthlevel(TreeNode root, ArrayList<Integer> ans, int n) {
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
        
        // right to left  (level order )
        public static void nthlevel2(TreeNode root, ArrayList<Integer> ans, int n) {
            // Function to collect values of nodes at a specific level 'n'.
            if (root == null)
                return;
            if (n == 1) {
                // If 'n' is 1, we've reached the desired level, so add the
                // value of the current node to the 'ans' ArrayList.
                ans.add(root.val);
                return;
            }
        
            // Recursively call 'nthlevel' on right and left children with 'n' decremented by 1.
            nthlevel(root.right, ans, n - 1);
            nthlevel(root.left, ans, n - 1);
        }
        
        public ArrayList<ArrayList<Integer>> solve(TreeNode root) {
            // Main function to perform level-order traversal and collect values at each level.
            int level = height(root) + 1; // Calculate the height of the tree.
            ArrayList<ArrayList<Integer>> list = new ArrayList<>(); // Initialize the result list.
        
            if (root == null)
                return list; // If the root is null, return an empty list.
        
            for (int i = 1; i <= level; i++) {
                // Iterate through each level from 1 to the height.
                ArrayList<Integer> ans = new ArrayList<>(); // Create a list for the current level.
                if (i % 2 != 0)
                    nthlevel(root, ans, i); // If the level is odd, use nthlevel.
                else
                    nthlevel2(root, ans, i); // If the level is even, use nthlevel2.
                list.add(ans); // Add the current level's list to the result list.
            }
        
            return list; // Return the list of lists containing values at each level.
        }

}
/*
  Explanation of above code

  1)height Function:

->This function calculates the height of a binary tree.
->It starts from the root of the tree and recursively checks the height of the left and right subtrees.
->The height of a node is defined as the length of the longest path from that node to a leaf node.
-> The function returns the height of the tree.


2)nthlevel and nthlevel2 Functions:
->These functions collect values of nodes at a specific level 'n' in the tree.
Inside the function, n is checked(while doing n-1)
-> If n is 1, it means you've reached the desired level, and you add the value of the current node
 to the ans ArrayList.
-> If n is greater than 1, it means you haven't reached the desired level yet.
 In this case, you need to traverse down to the next level. To do that, you recursively call nthlevel 
 on the left and right subtrees with n - 1. 
 -> This effectively reduces the level you're looking for by one and continues the traversal.
->They start from the root and move down the tree, decrementing 'n' until 'n' becomes 1, 
indicating that the desired level is reached.
-> When 'n' becomes 1, they add the value of the current node to an ArrayList called 'ans.'

3)solve Function:

-> This is the main function that performs a level-order traversal of the binary tree.
-> It first calculates the height of the tree using the height function.
> So, when you calculate the height with + 1, you are essentially
 counting the number of levels in the tree. If you don't add + 1,
  you are counting the number of edges along the longest path from the root to a leaf. 
-> Then, it iterates through each level from 1 to the height.
-> For each level, it creates an ArrayList called 'ans' to store the values of nodes at that level.
-> If the level is odd, it calls the nthlevel function to collect values, 
and if it's even, it calls the nthlevel2 function.
-> The collected 'ans' lists for each level are added to a result list.
-> Finally, the function returns the list of lists, where each inner list contains 
values at a specific level of the tree.

TC: o(n)
SC: o(H)


 */