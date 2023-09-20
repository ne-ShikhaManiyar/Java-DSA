import java.util.*;
public class Levelordertraversalbt {
    
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
          TreeNode b  = new TreeNode(2);
          TreeNode c  = new TreeNode(3);
        root.left=b;
        root.right=c;
        TreeNode d  = new TreeNode(4);
        TreeNode e  = new TreeNode(5);
        b.left=d;
        b.right=e;
        TreeNode f  = new TreeNode(6);
        TreeNode g  = new TreeNode(7);
        c.left=f;
        c.right=g;

         solve(root);

    }

    //level order traversal in trees using bfs 
    public static void solve(TreeNode root)
    {
        Queue<TreeNode> q = new LinkedList<>();
       if(root!=null) q.add(root);
        while(q.size()>0)
        {
            TreeNode temp = q.peek();
            if(temp.left!=null)
            {
                q.add(temp.left);
            }
            if(temp.right!=null)
            {
                q.add(temp.right);
            }
            System.out.print(temp.val+" ");
            q.remove();
        }
    }
}

/* 
 
Explanation of above code

using bfs algorithm with queue (iterative approach )
1) declare an queue 
2)in the queue peek first element (1st level) in queue
3) before removing first element will add it child inside the queue
4) then same goes till all levels till queue becomes empty

*/