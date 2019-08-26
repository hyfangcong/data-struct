package nkw.xz2018.meituandianping;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/15
 */
public class 双购物袋 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int[] volume = new int[n+1];
        int[] value = new int[n+1];
        int[] dpA = new int[A+1];
        int[] dpB = new int[B+1];
        int[] ansA = new int[n+2];
        int[] ansB = new int[n+2];
        for(int i = 1; i <= n; i ++){
            volume[i] = scanner.nextInt();
            value[i] = scanner.nextInt();
        }

        //从前向后求A袋子的最大价值
        for(int i = 1; i <= n; i++){
            for(int j = A; j >= volume[i]; j--){
                dpA[j] = Math.max(dpA[j], dpA[j-volume[i]] + value[i]);
            }
            ansA[i] = dpA[A];
        }

        //从后向前求B袋子的最大价值
        for(int i = n; i >= 1; i--){
            for(int j = B; j >= volume[i]; j--){
                dpB[j] = Math.max(dpB[j], dpB[j-volume[i]] + value[i]);
            }
            ansB[i] = dpB[B];
        }

        int ans = 0;
        for(int i = 0 ; i <= n ; i++){
            ans = Math.max(ans, ansA[i] + ansB[i+1]);
        }
        System.out.println(ans);
    }
}
