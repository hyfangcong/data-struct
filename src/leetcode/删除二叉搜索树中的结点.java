package leetcode;

public class 删除二叉搜索树中的结点 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //删除以root为根节点的二叉搜索树中值最大的节点，并且返回新的二叉树的根节点
    private static TreeNode delMaxNode(TreeNode root){
        if(root == null)
            return null;

        if(root.right == null){
            TreeNode leftNode = root.left;
            root.left = null;
            return leftNode;
        }

        root.right = delMaxNode(root.right);
        return root;
    }

    //返回以root为根节点的二叉搜索树中值最大的节点
    private static TreeNode maxmum(TreeNode node){
        if(node.right == null)
            return node;

        return maxmum(node.right);
    }

    //删除以root为根节点的二叉搜素树中值为key的节点，并且返回新的二叉树的根节点
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return null;

        if(key < root.val){
            root.left = deleteNode(root.left, key);
            return root;
        }
        else if(key > root.val){
            root.right = deleteNode(root.right, key);
            return root;
        }
        else{
            if(root.left == null){
                TreeNode retNode = root.right;
                root.right = null;
                return retNode;
            }

            if(root.right == null){
                TreeNode retNode = root.left;
                root.left = null;
                return retNode;
            }

            //root.left != null && root.right != null
            TreeNode node = maxmum(root.left);
            TreeNode precursor = new TreeNode(node.val);
            precursor.left = node.left;
            precursor.right = node.right;

            precursor.left = delMaxNode(root.left);
            precursor.right = root.right;
            root.left = root.right = null;
            return precursor;
        }
    }

}
