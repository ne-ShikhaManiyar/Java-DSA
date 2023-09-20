import java.util.ArrayList;

public class sumofnodesofbinarytree {
    
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
    public static void main(String [] args)
    {

         TreeNode root = new TreeNode(1);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(3);

        int  result = solve(root);

        // Print the result
        System.out.println(result);
    }


    public static int solve(TreeNode root)
    {
        if(root==null) return 0;

        int leftsum = solve(root.left);
        int rightsum = solve(root.right);
        int totalsum = leftsum+rightsum+root.val;

        return totalsum;
    }
}


/*
  Explanation of above code

  1) taking sum of left subtree
  2)then taking sum of right subtree
  3)then adding root value  and returning final sum

  TC: o(n)
  SC:(n)
 */