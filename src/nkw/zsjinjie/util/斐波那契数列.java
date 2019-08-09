package nkw.zsjinjie.util;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/9
 */
public class 斐波那契数列 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
//            System.out.println(feibo(scanner.nextInt()));
            System.out.println(cowNum(scanner.nextInt()));
        }
    }

    public static int feibo(int n){
        if(n == 1 || n == 2){
            return 1;
        }
        int f1 = 1, f2 = 1, f3 = 0;
        while(n-3 >= 0){
            f3 = f1+f2;
            f1 = f2;
            f2 = f3;
            n--;
        }
        return f3;
    }

    /**
     * 假设农场中成熟的母牛每年只会生1头小母牛，并且永远不会死。第一年农场有1只成熟的母牛，
     * 从第二年开始，母牛开始生小母牛。每只小母牛3年之后成熟又可以生小母牛。给定整数N，求 出N年后牛的数量。
     */
    public static int cowNum(int n){
        int old = 1, first = 0, second = 0, third = 0;
        if(n == 1)
            return 1;
        for(int i = 2; i <= n ; i ++){
            old = old + third;
            third = second;
            second = first;
            first = old;
        }
        return old + first + second + third;
    }
}
