/*
 
https://leetcode.com/problems/binary-tree-preorder-traversal/description/ (leetcode 144)

https://www.interviewbit.com/problems/preorder-traversal/ (interviewbit)
 */

import java.util.*;

public class preordertraversal {
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
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left = new TreeNode(2);

        ArrayList<Integer> result = solve(root);

        // Print the result
        System.out.println(result);
    }

    //Iterative solution

     public static ArrayList<Integer> solve(TreeNode root)
     {
          ArrayList<Integer> list = new ArrayList<>();
          if(root==null) return list;
          Stack<TreeNode> stk = new Stack<>();
          stk.push(root);
          while(!stk.isEmpty())
          {
              root = stk.pop();
              list.add(root.val);
              if(root.right!=null)
              {
                stk.push(root.right);
              }
              if(root.left!=null)
              {
                stk.push(root.left);
              }
          }
          return list;
     }

    // recursive preorder traversal

   /* public static ArrayList<Integer> solve(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    public static void preorder(TreeNode root, ArrayList<Integer> result) {
        if (root == null)
            return;
        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
    }
    */
}


/*
  explanation of code

  preorder travrsal 


  Recursive solution

  1) always take root node value first
  2)then move to nodes of left subtree 
  3) then move to nodes of right subtree

  Tc: o(N)

  The time complexity of the code is O(N), where N is the 
  number of nodes in the binary tree. This is because 
  the code visits each node in the tree once, and the work done
   at each node (adding it to the ArrayList) is constant time.


   SC: o(N) (recursion stack + 1dAL) 

   Iterative solution

   1) stack is required to add nodes
   2) push root node in stack
   3) need to add right node first bcoz (stack works as lifo)
   4) then we add left node in stack
  5)return the list
 */