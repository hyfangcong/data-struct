package leetcode.leetcode2018.math;

public class 颠倒二进制位 {

    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            sb.append(n & 1);
            n = n >> 1;
        }
        sb = sb.reverse();
        for(int i = 0 ; i < 32 ; i ++){
            System.out.println(sb.charAt(i));
        }
        int reverseN = 0;
        int temp = 1;
        for(int i = 0 ; i < 32 ; i ++){
            reverseN += (sb.charAt(i) - '0') * temp;
            temp *= 2;
        }
        return reverseN;
    }
    public static void main(String[] args) {
        System.out.println();
        System.out.println(reverseBits(43261596));

    }
}
