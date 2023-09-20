/*
   
https://www.interviewbit.com/problems/inorder-traversal/  (interviewbit)

https://leetcode.com/problems/binary-tree-inorder-traversal/description/  (leetcode 94)

 */


import java.util.*;

public class inordertraversal {
    
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


    //iterative solution of inorder traversal

    public static ArrayList<Integer> solve(TreeNode root)
    {
        
        ArrayList<Integer> ans = new ArrayList<>();
         Stack<TreeNode> stk = new Stack<>();
         if(root==null) return ans;
         if(root!=null) stk.push(root);
         while(stk.size()>0)
         {
            TreeNode temp = stk.peek();
            if(temp.left!=null) 
            {
                stk.push(temp.left);
                temp.left=null;
            }
            
            else
            {
                stk.pop();
                ans.add(temp.val);
                if(temp.right!=null) stk.push(temp.right);
            }

         }
        return ans;
     
}

     // recursive solution of inorder traversal

   /* public static ArrayList<Integer> solve(TreeNode root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        inorder(root,ans);
        return ans;
    }

    public static void inorder(TreeNode root, ArrayList<Integer> ans)
    {
        if(root==null) return;
        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);
    }*/  
}

/*
  Explanation of above code

  1)traverse to left subtree first
  2) then add root value 
  3)then traverse to right subtree

  TC :o(n) it will traverse too all nodes of tree
  SC :o(n) recursive stack + 1dAL
 */