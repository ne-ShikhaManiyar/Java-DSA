/*
   
https://www.interviewbit.com/problems/postorder-traversal/  (interviewbit)

https://leetcode.com/problems/binary-tree-postorder-traversal/description/  (leetcode 145)

 */

import java.util.ArrayList;

public class postordertraversal {
    
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
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        ArrayList<Integer> result = solve(root);

        // Print the result
        System.out.println(result);
    }

    public static  ArrayList<Integer> solve(TreeNode root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        postorder(root,ans);
        return ans;
    } 

    public static void postorder(TreeNode root, ArrayList<Integer> ans)
    {
        if(root==null) return;

        postorder(root.left, ans);
        postorder(root.right, ans);
        ans.add(root.val);

    }
}

/*
  Explanation of above code

  1)traverse nodes of left subtree first
  2) then traverse nodes of right subtree
  3) then take value of root node

  TC :o(n) as it will move to all nodes
  SC: o(n) recursive stack + arraylist
 */