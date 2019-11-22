package qz2019.didi;

        import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/9/19
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] sum = new int[n+1];
        for(int i = 1; i <= n; i++){
            sum[i] = sum[i-1] + scanner.nextInt();
        }
        int min = Integer.MAX_VALUE;
        for(int i = m; i <= n; i ++){
            for(int j = i - m; j >= 0; j --){
                min = Math.min(min, sum[i] - sum[j]);
            }
        }
        System.out.println(min);
    }
}
