package nkw.jzof;

/**
 * @author: fangcong
 * @date: 2019/6/23
 */
public class 对称二叉树 {
    boolean isSymmetrical(TreeNode pRoot){
        if(pRoot == null)
            return true;
        return helper(pRoot.left, pRoot.right);
    }

    private boolean helper(TreeNode lRoot, TreeNode rRoot){
        if(lRoot != null && rRoot != null){
            if(lRoot.val == rRoot.val){
                return helper(lRoot.left, rRoot.right) && helper(lRoot.right, rRoot.left);
            }else
                return false;
        }else if((lRoot == null && rRoot != null) || (lRoot != null && rRoot == null))
            return false;
        else
            return true;
    }
}
