package nkw.xz2018.aiqiyi;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author: fangcong
 * @date: 2019/6/28
 */
public class 幸运子序列 {

    public static void main(String[] args) {
        solution2();
    }

    /**
     * 分析：一个数x想要参与异或，那么x必须是连续子序列的最大值或者次大值。
     * 那么x只能和从它左边开始到第一个大于它之间的数进行异或。
     *
     * 因此使用单调栈
     */

    public static void solution2(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for(int i = 0 ; i < n; i ++){
            int x = scanner.nextInt();
            while(!stack.isEmpty() && stack.peek() <= x){
                res = Math.max(res, x ^ stack.pop());
            }
            if(!stack.isEmpty()){
                res = Math.max(res, x ^ stack.peek());
            }
            stack.push(x);
        }
        System.out.println(res);
    }

    /**
     * 暴力解法
     */
    public static void solution() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int max, lessMax;
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            max = arr[i];
            lessMax = Integer.MIN_VALUE;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > max) {
                    lessMax = max;
                    max = arr[j];
                } else if (arr[j] > lessMax) {
                    lessMax = arr[j];
                }
                res = Math.max(res, max ^ lessMax);
            }
        }
        System.out.println(res);
    }
}

