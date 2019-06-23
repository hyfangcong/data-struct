package nkw.jzof;

/**
 * @author: fangcong
 * @date: 2019/6/23
 */
public class 序列化二叉树 {
    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null){
            sb.append("#,");
            return sb.toString();
        }else{
            sb.append(root.val + ",");
            sb.append(Serialize(root.left));
            sb.append(Serialize(root.right));
            return sb.toString();
        }
    }

    TreeNode Deserialize(String str) {
        String[] strings = str.split(",");
        return helper(strings);
    }

    int index = -1;
    TreeNode helper(String[] str){
        index++;
        if(str[index].equals("#")){
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(str[index]));
        node.left = helper(str);
        node.right = helper(str);
        return node;
    }
}
