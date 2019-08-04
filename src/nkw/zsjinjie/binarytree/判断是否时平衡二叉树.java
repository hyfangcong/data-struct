package nkw.zsjinjie.binarytree;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/3
 */
public class 判断是否时平衡二叉树 {
    static class ReturnData{
        boolean isBalance;
        int height;
        public ReturnData(boolean isBalance, int height){
            this.isBalance = isBalance;
            this.height = height;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            TreeNode root = TreeNode.buildTree(scanner.next());
            System.out.println(isBalance(root));
        }
    }

    public static boolean isBalance(TreeNode root){
        return process(root).isBalance;
    }

    public static ReturnData process(TreeNode root){
        if(root == null){
            return new ReturnData(true, 0);
        }
        ReturnData leftInfo = process(root.left);
        if(!leftInfo.isBalance){ //如果子树不平衡，直接返回false
            return new ReturnData(false, 0);
        }
        ReturnData rightInfo = process(root.right);
        if(!rightInfo.isBalance){
            return new ReturnData(false, 0);
        }
        boolean isBalance = Math.abs(leftInfo.height - rightInfo.height) <= 1;
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        return new ReturnData(isBalance, height);
    }
}
