package leetcode.leetcodedynamic;

/**
 * @author: fangcong
 * @date: 2019/5/6
 */
public class 比特位计数 {
    //暴力解法
    public static int[] countBits(int num) {
        int[] result = new int[num + 1];
        for(int i = 0 ; i <= num ; i++){
            int count = 0 ;
            for(int j = 0; j < 32 ; j ++){
                int tmp = i;
                if(((tmp >> j ) & 1) == 1)
                    count++;
            }
            result[i] = count;
        }
        return result;
    }

    /**
     *  将整数 - 1 与其本身做位与运算，相当于将其最右边的 1 变成 0
     *
     * 代码中 res[i] 为 i 中 1 的个数，也就是 i & (i - 1) 中 1 的个数再 + 1。
     *
     * 等式是成立了，但是为什么可以拿来做赋值操作呢？ 我们可以看到，如果整数最右边的 1 变成了 0，无论如何，它都是减少的。 即，我们是拿前面的数来算后面的数，题目中要求为 1-num，而 1 前面的数是 0，具有 **0 个 1**。
     *
     * 而最开始的时候数组初始化为 0，正确性实际上是由数组的初始化值保证的。
     */
    //位运算
    public int[] countBits2(int num) {
        int[] res = new int[num + 1];
        for(int i = 1 ; i <= num ; i ++){
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int i = 2;
        System.out.println(i & ( i - 1));
    }
}
