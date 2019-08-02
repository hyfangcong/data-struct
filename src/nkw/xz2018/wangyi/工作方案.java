package nkw.xz2018.wangyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/7/18
 */
public class 工作方案 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        int[] work = new int[3];
        work[0] = scanner.nextInt();
        work[1] = scanner.nextInt();
        work[2] = scanner.nextInt();
        int[][] cnk = new int[51][51];
        int mod = 1000000007;

        /**
         * c(n,m) = c(n-1, m-1) + c(n-1, m)
         * 动态规划求解c(n,m)
         */
        for(int i = 0; i < 51; i ++){
            cnk[i][0] = 1;
            for(int j = 1; j <=i; j ++){
                cnk[i][j] = (cnk[i-1][j-1] + cnk[i-1][j]) % mod;
            }
        }

        Arrays.sort(work);
        int rest = s - work[2];
        long count = 0;
        for(int i = 0 ; i <= rest; i ++){
            /**
             * rest:剩余需要完成的工作，可以由work[0]和work1[1]共同来完成
             *
             * i：代表work[1]完成rest中的工作量，它的取值范围可能是0-rest
             * 并且需要满足下面的判断条件，i <= work[1] && rest - i <= work[0]
             */
            if(i <= work[1] && rest - i <= work[0]){
                long tmp  = cnk[work[2]][work[1] - i] % mod;
                tmp = (tmp * cnk[rest][i]) % mod;
                tmp = (tmp * cnk[s-(rest-i)][work[0]-(rest-i)]) % mod;
                count = (count + tmp) % mod;
            }
        }
        count = (count * cnk[s][work[2]]) % mod;
        System.out.println(count);

    }
}
