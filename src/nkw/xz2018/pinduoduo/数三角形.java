package nkw.xz2018.pinduoduo;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/7/6
 */
public class 数三角形 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double[] x = new double[n];
        double[] y = new double[n];
        for(int i = 0 ; i < n ; i ++){
            x[i] = scanner.nextDouble();
            y[i] = scanner.nextDouble();
        }
        int count = 0;
        for(int i = 0 ; i < n - 2; i ++){
            for(int j = i + 1; j < n - 1; j ++){
                for(int k = j + 1; k < n; k ++){
                    if(!inLine(x[i], y[i], x[j],y[j], x[k],y[k])){
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }

    public static boolean inLine(double x1, double y1, double x2, double y2, double x3, double y3){
        if(x1 == x2)
            return x2 == x3;
        else if(x1 == x3)
            return x1 == x2;
        else{
            return (y1 - y2) / (x1 - x2) == (y2 - y3) / (x2 - x3);
        }
    }
}
