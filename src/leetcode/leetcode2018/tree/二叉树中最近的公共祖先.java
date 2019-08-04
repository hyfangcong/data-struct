package leetcode.leetcode2018.tree;

public class 二叉树中最近的公共祖先 {
    /**
     * Definition for a binary tree node.
     * public class FFFFF {
     * int val;
     * FFFFF left;
     * FFFFF right;
     * FFFFF(int x) { val = x; }
     * }
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        if(root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p ,q);
        if(left != null && right != null){
            return root;
        }else if(left != null){
            return left;
        }else if (right != null){
            return right;
        }
        return null;
    }
}
