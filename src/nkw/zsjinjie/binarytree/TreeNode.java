package nkw.zsjinjie.binarytree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: fangcong
 * @date: 2019/8/3
 */
public class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
    public TreeNode(int value) {
        this.value = value;
    }

    public static void main(String[] args) {
        TreeNode root = buildTree("1_2_#_4_#_#_3_#_#_");
        System.out.println(root.left);
        System.out.println(serialize(root));
    }

    public static TreeNode buildTree(String s){
        String[] ss = s.split("_");
        Queue<String> queue = new LinkedList<String>(Arrays.asList(ss));
        return buildTree(queue);
    }

    private static TreeNode buildTree(Queue<String>queue){
        String s = queue.remove();
        if(s.equals("#")){
            return null;
        }

        TreeNode treeNode = new TreeNode(Integer.valueOf(s));
        treeNode.left = buildTree(queue);
        treeNode.right = buildTree(queue);
        return treeNode;
    }

    public static String serialize(TreeNode root){
        if(root == null){
            return "#_";
        }

        return root.value + "_" + serialize(root.left) + serialize(root.right);
    }


}
