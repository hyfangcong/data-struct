package nkw.zsjinjie.binarytree;

import java.util.HashMap;

/**
 * @author: fangcong
 * @date: 2019/8/6
 */
public class 二叉树上累加和为sum的最长路径 {
    public static void main(String[] args) {
        HashMap<Integer,Integer> sumMap = new HashMap<>();
        sumMap.put(0,0); // important
        TreeNode root = new TreeNode(-1);
        int sum = 10;
        System.out.println(preOrderInTree(root, sum, 0, 0, 0, sumMap));
    }

    public static int preOrderInTree(TreeNode root, int sum, int preSum, int level,
                                     int maxLength, HashMap<Integer,Integer>sumMap){
        if(root == null){
            return maxLength;
        }
        int curSum = preSum + root.value;
        if(sumMap.containsKey(curSum-sum)){
            maxLength = Math.max(level - sumMap.get(curSum-sum) + 1, maxLength);
        }
        if(!sumMap.containsKey(curSum)){
            sumMap.put(curSum, level);
        }
        maxLength = preOrderInTree(root.left, sum, curSum, level+1, maxLength, sumMap);
        maxLength = preOrderInTree(root.right, sum, curSum, level+1, maxLength, sumMap);
        if(level == sumMap.get(curSum)){  //考虑有负数的情况
            sumMap.remove(curSum);
        }
        return maxLength;
    }
}
