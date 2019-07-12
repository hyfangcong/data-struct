package nkw.xz2018.jingdong;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/7/12
 */
public class 疯狂序列 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long target = scanner.nextLong();
        int i = 1;
        do{
            /**
             * 能用减法的代替乘法的时侯，就不要使用乘法
             *
             * 能够缩小数据规模的时候，就尽量缩小数据规模，减少计算
             */
           target -= i;
           i++;
        }while(target > 0);
        System.out.println(i-1);
    }
}
