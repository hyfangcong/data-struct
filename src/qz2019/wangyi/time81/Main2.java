package qz2019.wangyi.time81;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/11
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int i = 0; i < T; i++){
            int m = scanner.nextInt();
            int t = scanner.nextInt();
            int m1 = scanner.nextInt();
            int t1 = scanner.nextInt();
            int m2 = scanner.nextInt();
            int t2 = scanner.nextInt();
            boolean push = true, pop = true;
            int cur = 0;
            for(int j = 1; j <= t; j++){
                if(push && pop){
                    int tmp = m1 - m2;
                    if(tmp > 0){
                        cur = Math.min(m, cur+tmp);
                    }else{
                        cur = Math.max(0, cur+tmp);
                    }
                }else if(push && !pop){
                    cur = Math.min(m, cur+m1);
                }else if(!push && pop){
                    cur = Math.max(0, cur-m2);
                }

                if(j % t1 == 0){
                    push = !push;
                }
                if(j % t2 == 0){
                    pop = !pop;
                }
            }
            System.out.println(cur);
        }
    }
}
