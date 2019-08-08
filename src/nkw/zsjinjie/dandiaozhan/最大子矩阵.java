package nkw.zsjinjie.dandiaozhan;

/**
 * @author: fangcong
 * @date: 2019/7/31
 */

import java.util.Stack;

/**
 *                 {"1","1","1","1","1","1","1","1"},
 *                 {"1","1","1","1","1","1","1","0"},
 *                 {"1","1","1","1","1","1","1","0"},
 *                 {"1","1","1","1","1","0","0","0"},
 *                 {"0","1","1","1","1","0","0","0"}};
 *
 *                 求1构成的最大子矩阵的面积
 *
 *                 时间复杂度为O(n * m) n为矩阵的行数，m为矩阵的列数
 */
public class 最大子矩阵 {

    public static void main(String[] args) {
        String[][] matrix = new String[][]{
                {"1","1","1","1","1","1","1","1"},
                {"1","1","1","1","1","1","1","0"},
                {"1","1","1","1","1","1","1","0"},
                {"1","1","1","1","1","0","0","0"},
                {"0","1","1","1","1","0","0","0"}};

        System.out.println(maxSubRectangle(matrix));
    }

    public static int maxSubRectangle(String[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        //记录以第i行为底，上面连续的1的个数
        int[] arr = new int[m];
        int maxArea = 0;
        for(int i = 0 ;  i < n; i ++){
            for(int j = 0; j < m ; j ++){
                arr[j] = matrix[i][j].equals("1") ? arr[j] + 1 : 0;
            }
            maxArea = Math.max(maxArea, maxRecFromBottom(arr));
        }
        return maxArea;
    }

    /**
     * 求直方图中所能构成的最大矩形的面积
     *
     * 使用单调栈
     *
     * 应用范围：在数组中找到一个数的两边最近比他大或者最近比她小的数
     *
     * 时间复杂度为O(N):因为每个元素只会进出栈一次
     * @param height
     * @return
     */
    public static int maxRecFromBottom(int[] height){
        if(height == null || height.length == 0)
            return 0;

        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < height.length ;i ++){
            while(!stack.isEmpty() && height[i] <= height[stack.peek()]){ //54564.对于高度相同的时候，只能够求出一个最大值，比如这里的4
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                int curArea = (i - k - 1) * height[j];
                maxArea = Math.max(maxArea, curArea);
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            int i = stack.pop();
            int j = stack.isEmpty() ? -1 : stack.peek();
            int curArea = (height.length - j - 1) * height[i];
            maxArea = Math.max(maxArea, curArea);
        }
        return maxArea;
    }
}
