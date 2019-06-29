package nkw.xz2018.bytedance;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/6/28
 */
public class 球队打平 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        while(len > 0){
            len--;
            long n = scanner.nextLong();
            long k = scanner.nextLong();
            long d1 = scanner.nextLong();
            long d2 = scanner.nextLong();

            long left;
            long tmp = k - d1 - d1 - d2; //球队1< 球队2，球队2<球队3
            if(tmp >= 0 && tmp % 3 == 0) //球队1的得分有解是大前提
            {
                left = (n - k) - (d1 + d2 + d2);
                if(left >= 0 && left % 3 == 0)//剩下的场次不小于need，并且可以均分3场。
                {
                    System.out.println("yes");
                    continue;
                }
            }

            tmp = k - d1 - d1 + d2; //球队1< 球队2，球队2>球队3
            if(tmp >= 0 && tmp % 3 == 0)
            {
                left = (n - k) - (d1 + d2);
                if(left >= 0 && left % 3 == 0)
                {
                    System.out.println("yes");
                    continue;
                }
            }

            tmp = k + d1 + d1 + d2;//球队1> 球队2，球队2>球队3
            if(tmp >= 0 && tmp % 3 == 0)
            {
                left = (n - k) - (d1 + d1 + d2);
                if(left >= 0 && left % 3 == 0)
                {
                    System.out.println("yes");
                    continue;
                }
            }

            tmp = k + d1 + d1 - d2;//球队1>球队2，球队2<球队3
            if(tmp >= 0 && tmp % 3 == 0)
            {
                if(d1 >= d2)
                {
                    left = (n - k) - (d1 + d1 - d2);
                }
                else
                {
                    left = (n - k) - (d2 + d2 - d1);
                }
                if(left >= 0 && left % 3 == 0)
                {
                    System.out.println("yes");
                    continue;
                }
            }

            System.out.println("no");
        }
    }
}
