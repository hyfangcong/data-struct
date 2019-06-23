package nkw.jzof;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: fangcong
 * @date: 2019/6/23
 */
public class 把二叉树打印成多行 {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(pRoot == null)
            return res;
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        TreeNode curLast = pRoot, nextLast = pRoot;

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            if(node.left != null){
                queue.add(node.left);
                nextLast = node.left;
            }
            if(node.right != null) {
                queue.add(node.right);
                nextLast = node.right;
            }

            if(node == curLast){
                res.add(list);
                list = new ArrayList<>();
                curLast = nextLast;
            }
        }
        return res;
    }
}
