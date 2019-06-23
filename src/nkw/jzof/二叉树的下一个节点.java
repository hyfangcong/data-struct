package nkw.jzof;

/**
 * @author: fangcong
 * @date: 2019/6/23
 */

/**
 * 利用中序遍历的性质
 *
 */
public class 二叉树的下一个节点 {
    public TreeLinkNode GetNext(TreeLinkNode pNode){
        if(pNode == null)
            return null;
        if(pNode.right != null){
            TreeLinkNode p = pNode.right;
            while(p.left != null){
                p = p.left;
            }
            return p;
        }
        while(pNode.next != null){
            TreeLinkNode pRoot = pNode.next;
            if(pRoot.left == pNode)
                return pRoot;
            else{
                pNode = pRoot;
            }
        }
        return null;
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
