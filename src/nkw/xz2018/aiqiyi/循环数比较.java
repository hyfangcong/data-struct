package nkw.xz2018.aiqiyi;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/6/27
 */
public class 循环数比较 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String x1 = scanner.next();
        int k1 = scanner.nextInt();
        String x2 = scanner.next();
        int k2 = scanner.nextInt();

        if(x1.length() * k1 < x2.length() * k2)
            System.out.println("Less");
        else if(x1.length() * k1 > x2.length() * k2)
            System.out.println("Greater");
        else {
           StringBuilder sb1  = new StringBuilder();
           StringBuilder sb2 = new StringBuilder();
           for(int i = 0; i < k1; i++){
               sb1.append(x1);
           }
           for(int i = 0; i < k2; i ++)
               sb2.append(x2);
            String xx1 = sb1.toString();
            String xx2 = sb2.toString();
            if(xx1.compareTo(xx2) > 0)
                System.out.println("Greater");
            else if(xx1.compareTo(xx2) == 0)
                System.out.println("Equal");
            else
                System.out.println("Less");
        }
    }
}
