package nkw.jzof;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: fangcong
 * @date: 2019/6/23
 */
public class 按之字形打印二叉树 {

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        TreeNode root = buildTree(arr);
        ArrayList<ArrayList<Integer>> res = Print(root);
        System.out.println();
    }

    public static TreeNode buildTree(int[] arr){
        TreeNode root = null;
        for(int i = 0; i < arr.length; i ++){
            if(i == 0){
                root = new TreeNode(arr[i]);
            }
            if(i == 1){
                TreeNode node = new TreeNode(arr[i]);
                root.left = node;
            }
            if(i == 2){
                TreeNode node = new TreeNode(arr[i]);
                root.right = node;
            }
        }
        return root;
    }

    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(pRoot == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        TreeNode curLast = pRoot, nextLast = pRoot;
        ArrayList<Integer> list = new ArrayList<>();
        boolean flag = true;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            if(node.left != null){
                queue.add(node.left);
                nextLast = node.left;
            }
            /**
             * node.left 和 node.right 是并列关系
             */
            if(node.right != null){
                queue.add(node.right);
                nextLast = node.right;
            }

            if(node == curLast){
                if(!flag){
                    Collections.reverse(list);
                }
                res.add(list);
                list = new ArrayList<>();
                flag = !flag;
                curLast = nextLast;
            }
        }
        return res;
    }
}
