package leetcode.leetcode2018.tree;

import java.util.TreeSet;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class 二叉搜索树中第K小元素 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int time = 0;
    public int kthSmallest(TreeNode root, int k) {
       int res = 0;
       if(root == null){
           return res;
       }

       res = kthSmallest(root.left, k);
       if(time == k){
           return res;
       }
       if(++time == k){
           return root.val;
       }
       return kthSmallest(root.right, k);
    }
}