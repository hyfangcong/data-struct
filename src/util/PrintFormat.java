package util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author: fangcong
 * @date: 2019/8/14
 */
public class PrintFormat {
    public static void main(String[] args) {
        double d1 = 2.0 / 3 ;
        BigDecimal bigDecimal = new BigDecimal(d1);
        System.out.println(bigDecimal.setScale(5, RoundingMode.HALF_DOWN));
        System.out.printf("%.5f", d1);
    }
}
