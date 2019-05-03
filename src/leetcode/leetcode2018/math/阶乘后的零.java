package leetcode.leetcode2018.math;

public class 阶乘后的零 {
    //找出n中有多少个数字是5的倍数
    public int trailingZeroes(int n) {
        return n < 5 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}
