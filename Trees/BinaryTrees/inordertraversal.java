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
       if(root==null) return ans;
       Stack<TreeNode> stk = new Stack<>();
       TreeNode temp = root;
       while(!stk.isEmpty() || temp!=null)
       {
           while(temp!=null)
           {
            stk.push(temp);
            temp =temp.left;
           }

           temp= stk.pop();
           ans.add(temp.val);
           temp = temp.right;
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

  Explanation of iterative code

  1)use an stack of treenode to store the nodes of tree
  2) create an temp node so our changes doesnt affect original tree
  3) check if stack is not empty || temp is not null
  4)then if temp not null add it in stack
  5)push the left node inside stack
  6)as left node or right node may have reach null so pop the stack
  7) and add it in the ans list
  8) and then push right node inside stack


 */