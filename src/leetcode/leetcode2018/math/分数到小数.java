package leetcode.leetcode2018.math;

import java.util.ArrayList;
import java.util.List;

public class 分数到小数 {
    public static void main(String[] args) {
        System.out.println(fractionToDecimal(-1
                ,-2147483648));
//        StringBuilder sb = new StringBuilder();
//        sb.append(1);
//        sb.setCharAt(sb.length() - 1, 'u');
//        System.out.println(sb.toString());
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        List<Long> list = new ArrayList<>();
        boolean flag = (long)numerator * (long)denominator < 0;
        long newNumerator = Math.abs((long)numerator);
        long newdDenominator = Math.abs((long)denominator);

        //整数部分
        long part1 = newNumerator / newdDenominator;
        String sb = "";
        long reaminder = newNumerator % newdDenominator;
        while(true){
            if(list.contains(reaminder)){
                int index = list.indexOf(reaminder);
                if(index >= 1){
                    sb = sb.substring(0, index) +
                            "(" + sb.substring(index, sb.length()) + ")";
                }else{
                    sb = "(" + sb + ")";
                }

                break;
            }else if(reaminder == 0)
                break;
            else{
                list.add(reaminder);
                sb += (reaminder * 10 / newdDenominator);
                reaminder = reaminder * 10 % newdDenominator;
            }
        }
        sb = sb.length() == 0 ? part1 + "" : part1 + "." + sb;
        return flag ? "-" + sb : sb;
    }
}
