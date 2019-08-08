package nkw.zsjinjie.binarytree;

import javax.print.attribute.standard.NumberUp;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: fangcong
 * @date: 2019/8/5
 */
public class 是否是完全二叉树 {
    public static void main(String[] args) {

    }

    public static boolean iswanquan(TreeNode root){
        if(root == null){
            return true;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        boolean leaf = true;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode l = node.left;
            TreeNode r = node.right;
            if((!leaf && (l != null || r != null))
             || (l == null && r != null)){
                return false;
            }

            if(l != null)
                queue.offer(l);
            if(r != null)
                queue.offer(r);
            if(l == null || r == null){   //如果左右孩子不全，此后所有的节点都必须是叶子节点
                leaf = false;
            }
        }
        return true;
    }
}
