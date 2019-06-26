package nkw.xz2018.pinduoduo;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/6/24
 */
public class 大整数相乘 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num1 = scanner.next();
        String num2 = scanner.next();
        int[] res = new int[num1.length() + num2.length()];
        for(int i = num1.length() - 1; i >= 0 ; i--){
            int x = num1.charAt(i) - '0';
            for(int j = num2.length() - 1; j >= 0; j --){
                int y = num2.charAt(j) - '0';
                /**
                 * 高低位
                 */
                res[i + j] += (res[i + j + 1] + x * y) / 10;
                res[i + j + 1] = (res[i + j + 1] + x * y) % 10;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < res.length ; i ++){
            if(i == 0 && res[i] == 0)
                continue;
            stringBuilder.append(res[i]);
        }
        System.out.println(stringBuilder.toString());
    }
}
