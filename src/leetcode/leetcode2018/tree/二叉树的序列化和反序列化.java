package leetcode.leetcode2018.tree;

import java.util.Queue;

import java.util.ArrayDeque;
import java.util.Arrays;

public class 二叉树的序列化和反序列化 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private TreeNode root;
    private int size;

    public 二叉树的序列化和反序列化(){
        root = null;
        size = 0;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "$,";
        }
        return root.val + "," + serialize(root.left) +serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strings = data.split(",");
        java.util.Queue<String> queue = new ArrayDeque<>(Arrays.asList(strings));

        return deserialize(queue);
    }

    private TreeNode deserialize(Queue<String> queue){
            String s = queue.remove();
            if("$".equals(s)){
                return null;
            }
            TreeNode node = new TreeNode(Integer.parseInt(s));
            node.left = deserialize(queue);
            node.right = deserialize(queue);
            return node;
    }

    public void add(Integer e){
        root = add(root, e);
    }
    private TreeNode add(TreeNode node, Integer e){
        if(node == null){
            size++;
            return new TreeNode(e);
        }

        if(e < node.val)
            node.left = add(node.left, e);
        else if(e > node.val)
            node.right = add(node.right, e);
        //e == node.val 什么也不用做，直接将node返回
        return node;
    }

    private void inOrder(TreeNode node){
        if(node != null){
            inOrder(node.left);
            System.out.print(node.val + " ");
            inOrder(node.right);
        }
    }

    public static void main(String[] args) {
        二叉树的序列化和反序列化 tt =new 二叉树的序列化和反序列化();
        int[] arr = new int[]{3,1,2,4};
        for(int i = 0 ; i < arr.length; i++){
            tt.add(arr[i]);
        }
        tt.inOrder(tt.root);
        System.out.println("*******************************");
        String deser = tt.serialize(tt.root);
        System.out.println(deser);
        TreeNode newRoot = tt.deserialize(deser);
        tt.inOrder(newRoot);
    }
}
