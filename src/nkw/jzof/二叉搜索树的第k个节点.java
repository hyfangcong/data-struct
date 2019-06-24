package nkw.jzof;

import java.util.Stack;

/**
 * @author: fangcong
 * @date: 2019/6/24
 */
public class 二叉搜索树的第k个节点 {
    static 序列化二叉树 build = new 序列化二叉树();

    public static void main(String[] args) {
        二叉搜索树的第k个节点 instant = new 二叉搜索树的第k个节点();
        String str = "8,6,5,#,#,7,#,#,10,9,#,#,11,#,#,";
        TreeNode root = build.Deserialize(str);
        TreeNode res = instant.KthNode2(root, 7);
        System.out.println(res.val);
    }


    int index = 0;
    TreeNode KthNode(TreeNode pRoot, int k){
        if(pRoot != null){
            TreeNode node = KthNode(pRoot.left, k);
            if(node != null)
                return node;
            index++;
            if(k == index)
                return pRoot;
            node = KthNode(pRoot.right, k);
            if(node != null)
                return node;
        }
        return null;
    }

    /**
     * 非递归实现
     *
     */
    public TreeNode KthNode2(TreeNode pRoot, int k){
        if(pRoot == null || k == 0)
            return null;

        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        TreeNode node = pRoot;
        do{
            if(node != null){
                stack.push(node);
                node = node.left;
            }else{
                node = stack.pop();
                count++;
                if(count == k)
                    return node;
                node = node.right;
            }
        }while (node != null || !stack.isEmpty());
        return null;
    }
}
