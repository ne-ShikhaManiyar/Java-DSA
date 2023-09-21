/*
 Question : LCAofBT (leetcode 236)

 https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */



public class LCAofBT {

    public static class TreeNode {
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
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        // Print the binary tree
        System.out.println("Binary Tree:");
        printTree(root, 0);

        // Define two nodes for which you want to find the LCA
        TreeNode p = root.left;
        TreeNode q = root.right;

        // Find and print the Lowest Common Ancestor (LCA)
        TreeNode lcaNode = LCA(root, p, q);
        System.out.println("\nLowest Common Ancestor (LCA) of " + p.val + " and " + q.val + " is: " + lcaNode.val);

        // Calculate time complexity: O(n), where n is the number of nodes in the tree.
        // Calculate space complexity: O(h), where h is the height of the tree.
    }

    // Function to print a binary tree
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

    public static boolean contains(TreeNode root, TreeNode node) {
        // Check if the current node is the target node
        if (root == node) return true;
        
        // If the current node is null, the target node is not found
        if (root == null) return false;
        
        // Recursively search for the target node in the left and right subtrees
        return contains(root.left, node) || contains(root.right, node);
    }

    public static TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        // Base cases
        if (p == root || q == root) return root; // If either p or q is the current root, return the root as the LCA.
        if (p == q) return p; // If p and q are the same node, return either one as the LCA.

        // Check if p is in the left subtree and if q is in the right subtree
        boolean leftp = contains(root.left, p);
        boolean rightq = contains(root.right, q);

        // Determine the LCA based on the search results
        if ((leftp && rightq) || (!leftp && !rightq)) return root; // If p and q are in different subtrees or neither is found, return the current root as the LCA.
        if (leftp && !rightq) return LCA(root.left, p, q); // If p is in the left subtree and q is not in the right subtree, recursively search in the left subtree.
        if (!leftp && rightq) return LCA(root.right, p, q); // If p is not in the left subtree and q is in the right subtree, recursively search in the right subtree.
        return root; // This line should not be reached under normal circumstances.
    }
}
/*

Rules of LCA 

1) “The lowest common ancestor is defined between two nodes p and q 
as the lowest node in T that has both p and q as descendants 
(where we allow a node to be a descendant of itself).”

2)since a node can be a descendant of itself according to the LCA definition.

Explanation of above code

1) base case 
-> if p==root || q==root we return the root(is our LCA)

-> if p==q we can return anything p or q

2) now we make a function to check whether our p lies in left subtree and q lies in right subtree 
-> we store this function in a boolean variable

3)now condtions to check what is LCA of p&q

-> we check whter p is in left & q in right || !leftp && !rightq(vice-versa) so we return root as LCA
-> we check whter p is in left & q is not in right so we return  LCA funtion with root.left and p,q nodes
(as our both nodes may be in left subtree)
-> -> we check whter p is not in left & q is in right so we return  LCA funtion with root.right and p,q nodes
(as our both nodes may be in right subtree)
-> in the end we can return root or null anything

4) contains function will have root & treenode and return true and false 
-> where if root==null we return null
-> where if root==node will return true
-> and in the end we would return root.left || root.right along with node

TC: O(n) because it visits each node in the tree once.
SC:  O(h), where h is the height of the tree. In the worst case (skewed tree), 
it can be O(n), and in a balanced tree, it's O(log n).

 
// another solution 
public static TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null; // If the root is null, return null (base case).
        }

        if (root == p || root == q) {
            return root; // If the current node is one of the target nodes, return it.
        }

        TreeNode leftLCA = LCA(root.left, p, q); // Recursively search in the left subtree.
        TreeNode rightLCA = LCA(root.right, p, q); // Recursively search in the right subtree.

        if (leftLCA != null && rightLCA != null) {
            return root; // If both left and right subtrees have found a target node, 
            the current node is the LCA.
        } else if (leftLCA != null) {
            return leftLCA; // If only the left subtree has found a target node, 
            return that as a potential LCA.
        } else {
            return rightLCA; // If only the right subtree has found a target node, 
            return that as a potential LCA.
        }
    }


 */