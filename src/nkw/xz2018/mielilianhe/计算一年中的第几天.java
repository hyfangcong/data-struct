package nkw.xz2018.mielilianhe;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/7/1
 */
public class 计算一年中的第几天 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int y = scanner.nextInt();
            int m = scanner.nextInt();
            int d = scanner.nextInt();
            int sum = 0;
            for(int i = 1; i < m ; i ++){
                if(i == 1 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12)
                    sum += 31;
                else if(i == 2){
                    if(isLeapYear(y))
                        sum += 29;
                    else
                        sum += 28;
                }else
                    sum += 30;
            }
            sum += d + 1;
            System.out.println(sum);
        }
    }

    public static boolean isLeapYear(int year){
        if(year % 100 == 0){
            return year % 400 == 0;
        }else
            return year % 4 == 0;
    }
}
