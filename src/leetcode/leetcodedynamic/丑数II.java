package leetcode.leetcodedynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: fangcong
 * @date: 2019/5/5
 */
public class 丑数II {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber2(2));
    }

    /**
     *
     * 超时
     */
    public static int nthUglyNumber(int n) {
        if(n == 1)
            return 1;
        Map<Integer, Boolean> checkMap = new HashMap<>();
        checkMap.put(1,true);
        int count = 1, m = 2;
        while(true){
            if(m % 2 == 0 && checkMap.get(m / 2))
                checkMap.put(m, true);
            else if(m % 3 == 0 && checkMap.get(m / 3))
                checkMap.put(m ,true);
            else if(m % 5 == 0 && checkMap.get(m / 5))
                checkMap.put(m , true);
            else
                checkMap.put(m, false);

            if(checkMap.get(m) && ++count == n){
                return m;
            }
            m++;
        }
    }

    /**
     * 三指针法
     */
    public static int nthUglyNumber2(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for(int i = 1; i < n; i ++){
            ugly[i] = min(ugly[p2] * 2, ugly[p3] * 3, ugly[p5] * 5);

            if(ugly[p2] * 2 == ugly[i])
                p2++;
            if(ugly[p3] * 3 == ugly[i])
                p3++;
            if(ugly[p5] * 5 == ugly[i])
                p5++;
        }
        return ugly[n - 1];

    }

    private static int min(int a, int b, int c){
        int min = Math.min(a, b);
        return min < c ? min : c;
    }
}
