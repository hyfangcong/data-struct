package qz2019.aiqiyi;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/9/8
 */
public class 排列计数 {
    static int ans = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n-1];
        boolean[] used = new boolean[n+1];
        for(int i = 0; i < a.length; i ++){
            a[i] = scanner.nextInt();
        }
        for(int i = 1; i <= n; i ++){
            used[i] = true;
            f2(a, used, 1, n, i);
            used[i] = false;
        }
        System.out.println(ans);
    }

    public static void f2(int[] a, boolean[] used, int index, int n, int pre){
        if(index == n){
            ans++;
            return;
        }
        if(a[index-1] == 0){
            for(int num = pre+1; num <= n; num++){
                if(!used[num]){
                    used[num] = true;
                    f2(a, used, index+1, n, num);
                    used[num] = false;
                }
            }
        }
        if(a[index-1] == 1){
            for(int num = 1; num < pre; num++){
                if(!used[num]){
                    used[num] = true;
                    f2(a, used, index+1, n, num);
                    used[num] = false;
                }
            }
        }
    }

    public static void f(int[] a, boolean[] used, int index, int n, int pre){
        if(index == n){
            ans++;
            return;
        }
        for(int num = 1; num <= n; num ++){
            if(!used[num]){
                if(a[index - 1] == 0 && pre < num){
                    used[num] = true;
                    f(a, used, index+1, n, num);
                    used[num] = false;
                }

                if(a[index-1] == 1 && pre > num){
                    used[num] = true;
                    f(a, used, index+1, n, num);
                    used[num] = false;
                }
            }
        }
    }
}
