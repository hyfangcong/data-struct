package nkw.zsjinjie.util;

/**
 * @author: fangcong
 * @date: 2019/8/6
 */

/**
 * 解法为递归思想。假设有A,B,C三个塔，A塔有N块圆盘，目标是把全部的圆盘移到C塔。
 *
 * 那么先把A塔顶部的N-1块圆盘移到B塔，再把A塔剩下的大盘移到C塔
 * 最后把B塔的N-1块圆盘移到C。依次递归。
 *
 */
public class 汉罗塔 {
    public static void main(String[] args) {
        System.out.println(hannoi(3,'a', 'b', 'c'));
    }

    public static int hannoi(int n, char from, char buffer, char to){
        if(n == 0){
            return 0;
        }
        int sum = hannoi(n-1, from, to, buffer);
        sum += 1;
        System.out.println("move disk " + n + " from " + from + " to " + to );
        sum += hannoi(n-1, buffer, from, to);
        return sum;
    }
}
