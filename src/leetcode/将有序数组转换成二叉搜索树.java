package leetcode;

public class 将有序数组转换成二叉搜索树 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return nums == null ? null : buildBST(nums, 0 , nums.length - 1);
    }

    private TreeNode buildBST(int[] nums , int l, int r){
        if(l < r)
            return null;

        int mid = l + (r - l) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildBST(nums, l, mid - 1);
        node.right = buildBST(nums, mid + 1 , r);
        return node;
    }
}
