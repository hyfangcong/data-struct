package leetcode;

public class 对称二叉树 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode p, TreeNode q){
        if(p == null && q == null)
            return true;
        if(p == null || q == null )
            return false;

        boolean b1 = isMirror(p.left, q.right);
        boolean b2 = isMirror(p.right, q.left);
        return b1 && b2 && p.val == q.val;
    }
}
