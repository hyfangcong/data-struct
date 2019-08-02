package nkw.xz2018.wangyi;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/7/15
 */
public class 缩写 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0 ; i < strings.length; i ++){
            stringBuilder.append(strings[i].charAt(0));
        }
        System.out.println(stringBuilder.toString());
    }
}
