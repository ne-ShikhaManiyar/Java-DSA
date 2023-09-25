/*
   
https://www.interviewbit.com/problems/postorder-traversal/  (interviewbit)

https://leetcode.com/problems/binary-tree-postorder-traversal/description/  (leetcode 145)

 */

import java.util.*;

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


      //iterative code for postorder

      public static ArrayList<Integer> solve(TreeNode root)

      {
        ArrayList<Integer> list = new ArrayList<>();
        if(root==null) return list;
        Stack<TreeNode> stk = new Stack<>();
        while(!stk.isEmpty() || root!=null)
        {
            if(root!=null)
            {
                stk.push(root);
                  root = root.left;
            }
            else
            {
                TreeNode temp = stk.peek().right;
                if(temp==null)
                {
                    temp=stk.peek();
                    stk.pop();
                    list.add(temp.val);
                    while(!stk.isEmpty() && temp== stk.peek().right)
                    {
                        temp = stk.peek();
                        stk.pop();
                        list.add(temp.val);
                    }
                    
                }
                else root=temp;
            }
        }
        return list;
      }



    //recursive code for postorder
    /* 
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
    */
}

/*
  Explanation of above code

  1)traverse nodes of left subtree first
  2) then traverse nodes of right subtree
  3) then take value of root node

  TC :o(n) as it will move to all nodes
  SC: o(n) recursive stack + arraylist

  Iterative algorithm explanation

1) We take an explicit data structure and a root pointer pointing to the root of the tree.
2)We run a while loop till the time the cur is not pointing to NULL or the stack is non-empty.

3)If root is not pointing to NULL, it means then we simply 
-> push that value to the stack and move the root pointer to its left
-> child because we want to explore the left child before the root or the right child.

4)If the root is pointing to NULL, it means we can’t go further left,
 then we take a variable temp and set it to  root’s parent’s 
 right child (as we have visited the left child, now we want to visit the right child).
  We have node roots parent at the top of the stack.

5)If node temp is not pointing to NULL, we simply initialise root as node temp so 
that we can again start looking at the left of node temp from the next iteration.

6)If node temp is pointing to NULL, then first of all we 
are sure that we have visited both children of temp’s parent, so it’s time to print it. 
-> Therefore we set temp to its parent( present at the top of stack), pop the stack
 and then print temp’s value. Additionally,  this new temp(parent of NULL-pointing node) 
 can be the right child of the node present at the top of stack after popping.
->  In that case the node at top of the stack is parent of temp and the next node to be printed.
  Therefore we run an additional while loop to check if that is the case, if true
   then again move temp to its parent and print its value.

   TC: o(2n) as we will add all nodes in stack and then we check for its most left & right in while loop
   SC :o(n)
 */