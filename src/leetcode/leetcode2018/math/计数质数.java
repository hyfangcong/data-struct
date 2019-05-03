package leetcode.leetcode2018.math;

import java.util.Arrays;

public class 计数质数 {

    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }
    public static int countPrimes(int n) {
        if (n <= 2)
            return 0;

        boolean[] flag = new boolean[n + 1];
        for (int i = 2; i <= Math.sqrt(n); i++) {
            while(i <= Math.sqrt(n) && flag[i])
                i++;

            for(int j = i * i; j < n ; j += i)
                flag[j] = true;

        }

        int sum = 0;
        for(int i = 2 ; i < flag.length - 1 ; i ++){
            if(!flag[i])
                sum++;
        }
        return sum;
    }
}
