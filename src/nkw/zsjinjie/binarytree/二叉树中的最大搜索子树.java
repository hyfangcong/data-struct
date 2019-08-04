package nkw.zsjinjie.binarytree;

/**
 * @author: fangcong
 * @date: 2019/8/2
 */

/**
 * 1.可能性分析：求出以树中每个节点为根的二叉树的最大搜索子树。那么一定包含结果
 *
 * 2.怎么求以一个节点为根的树中的最大搜索子树
 *    1）可能出现在它的左子树上
 *    2）可能出现在它的右子树上
 *    3）可能是左子树 + 根节点 + 右子树 ， 左子树上的最大搜索子树的最大值 < 根节点的值 < 右子树的最大搜索子树的最小值
 *    在这所有的情况中我们选择最大的那种情况
 *
 * 3.我们要进行2中的判断，需要的信息有：
 *   左右是对称的，我们可以定义相同的信息。
 *   a)最大搜索子树的根节点
 *   b)最大搜索子树的大小
 *   c）最大搜索子树中的最小值min
 *   d）最大搜索子树中的最大值max
 *
 * 4.边界条件：当为null时，null,0,Integer.MAX_VALUE,Integer.MIN_VALUE
 *
 */
public class 二叉树中的最大搜索子树 {
    static class ReturnType{
        TreeNode root;
        int size;
        int min;
        int max;
        public ReturnType(TreeNode root, int size, int min, int max){
            this.root = root;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static ReturnType process(TreeNode root){
        if(root == null){
            return new ReturnType(null, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        int includeItself = 0;
        ReturnType leftReturnType = process(root.left);
        ReturnType rightReturnType = process(root.right);
        if(leftReturnType.root == root.left && rightReturnType.root == root.right
            && leftReturnType.max < root.value && root.value < rightReturnType.min){
            includeItself = leftReturnType.size + 1 + rightReturnType.size;
        }
        int size = Math.max(Math.max(leftReturnType.size, rightReturnType.size), includeItself);
        TreeNode maxHead = leftReturnType.size > rightReturnType.size ? leftReturnType.root : rightReturnType.root;
        if(size == includeItself){
            maxHead = root;
        }
        return new ReturnType(maxHead, size,
                    Math.min(Math.min(leftReturnType.min, rightReturnType.min), root.value),
                    Math.max(Math.max(leftReturnType.max, rightReturnType.max), root.value));
    }
}
