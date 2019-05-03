package leetcode;

public class 验证二叉搜索树 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    long last = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;

        if(isValidBST(root.left)){
            if(last < root.val){
                last = root.val;
                return isValidBST(root.right);
            }
        }
        return false;
    }
}
