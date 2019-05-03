package leetcode;

public class 二叉树的最小深度 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;

        int left = minDepth(root.left);
        int right = minDepth(root.right);

//        if(left != 0 && right != 0)
//            return left < right ? left + 1 : right + 1;
//        else{
//            return left < right ? right + 1 : left + 1;
//        }

        return left !=0 && right != 0  ? 1 + Math.min(left, right) : left + right + 1;
    }
}
