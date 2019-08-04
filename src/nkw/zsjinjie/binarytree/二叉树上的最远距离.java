package nkw.zsjinjie.binarytree;

/**
 * @author: fangcong
 * @date: 2019/8/3
 */

import java.util.Scanner;

/**
 * 二叉树中，一个节点可以往上走和往下走，那么从节点A总能走到节点 B。
 * 节点A走到节点B的距离为：A走到B最短路径上的节点个数。
 * 求一棵二叉树上的最远距离
 */
public class 二叉树上的最远距离 {
    static class ReturnType{
        int dist;
        int depth;
        public ReturnType(int dist, int depth){
            this.dist = dist;
            this.depth = depth;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            TreeNode root = TreeNode.buildTree(scanner.next());
            System.out.println(TreeNode.serialize(root));
            ReturnType res = process(root);
            System.out.println(res.dist + " " + res.depth);
        }
    }

    public static ReturnType process(TreeNode root){
        if(root == null){
            return new ReturnType(0,0);
        }

        ReturnType leftReturnInfo = process(root.left);
        ReturnType rightReturnInfo = process(root.right);
        int maxDist = Math.max(Math.max(leftReturnInfo.dist, rightReturnInfo.dist),
                leftReturnInfo.depth+rightReturnInfo.depth+1);
        int maxDepth = Math.max(leftReturnInfo.depth, rightReturnInfo.depth) + 1;
        return new ReturnType(maxDist, maxDepth);
    }
}
