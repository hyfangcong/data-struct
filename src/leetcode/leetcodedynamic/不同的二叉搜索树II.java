package leetcode.leetcodedynamic;

import java.util.LinkedList;
import java.util.List;

public class 不同的二叉搜索树II {
    public static void main(String[] args) {
        List<TreeNode> res = generateTrees(3);
        for(TreeNode node : res){
            printTree(node);
            System.out.println();
        }
    }

    public static void printTree(TreeNode root){
        if(root != null){
            System.out.print(root.val + " ");
            printTree(root.left);
            printTree(root.right);
        }else{
            System.out.print("null" + " ");
        }
    }

    public static List<TreeNode> generateTrees(int n) {
        if(n == 0)
            return new LinkedList<TreeNode>();
        return generateTrees(1,n);
    }

    /**
     * 返回每个二分搜索树的根节点
     */
    public static List<TreeNode> generateTrees(int start,int end) {
        List<TreeNode> res = new LinkedList<TreeNode>();
        if(start > end){  //start > end 此时二分搜索树为null
            res.add(null);
            return res;
        }
        for(int i = start;i <= end;i++){
            List<TreeNode> subLeftTree = generateTrees(start,i-1);
            List<TreeNode> subRightTree = generateTrees(i+1,end);
            for(TreeNode left : subLeftTree){
                for(TreeNode right : subRightTree){
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    res.add(node);
                }
            }
        }
        return res;
    }

    public static class TreeNode {
      int val;
      TreeNode left;
     TreeNode right;
      TreeNode(int x) { val = x; }
  }

}
