package leetcode.leetcode2018.math;

public class 位1的个数 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int sum = 0;
        for(int i = 0; i < 32 ; i ++){
            if((n & 1) == 1)
                sum++;
            n = n >> 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        long l = (long) 65536 * (-65536);
        System.out.println(l);
    }
}
