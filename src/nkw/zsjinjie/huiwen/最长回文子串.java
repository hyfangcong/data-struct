package nkw.zsjinjie.huiwen;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/1
 */

/**
 * 最长回文子串
 * manacher算法，时间复杂度为O（N）
 *
 *
 */
public class 最长回文子串 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            System.out.println(manacher(scanner.next()));
        }
    }

    public static char[] manacherString(String s){
        int len = s.length();
        char[] charArr = s.toCharArray();
        //在字符串前后及中间加入'#'，用于同意处理偶回文
        char[] res = new char[len * 2 + 1];
        int ind = 0;
        for(int i = 0; i < res.length; i ++){
            res[i] = (i & 1) == 0 ? '#' : charArr[ind++];
        }
        return res;
    }

    public static String manacher(String s){
        if(s == null || s.length() == 0){
            return "";
        }

        char[] charArr = manacherString(s);
        int len = charArr.length;
        //c表示最右回文的回文中心， r表示最右回文的右边界的位置
        int c = -1, r = -1;
        //arr记录每个字符的长回文半径
        int[] arr = new int[len];
        for(int i = 0 ; i < len; i ++){
            if(i > r){
                //暴力扩展
                int tmp = 1;
                while(i-tmp >= 0 && i+tmp < len && charArr[i-tmp] == charArr[i+tmp]){
                    tmp++;
                }
                //更新最右回文的右边界，同时更新最右回文的中心
                r = i + tmp - 1;
                c = i;
                arr[i] = tmp - 1;
            }else{
                int dist = 2*c-i - arr[2*c-i] - (c - arr[c]);
                if(dist > 0){ //i关于c的对称点i`的回文半径在c的回文半径内部
                    arr[i] = arr[2*c-i];
                }else if(dist < 0){
                    arr[i] = r - i;
                }else{
                    int tmp = r-i+1;
                    while(i-tmp >= 0 && i+tmp < len && charArr[i-tmp] == charArr[i+tmp]){
                        tmp++;
                    }
                    if(tmp > r-i+1){ //超出当前的回文右边界，更新c和r
                        r = i + tmp - 1;
                        c = i;
                    }
                    arr[i] = tmp - 1;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        int index = -1;
        for(int i = 0 ;  i < len; i ++){
            if(arr[i] > max){
                max = arr[i];
                index = i;
            }
        }

        /**
         * java中复制一个数组中的元素的时候，[from,to)是一个前闭后开的区间
         *
         * 复制的长度为len = to - from
         */
        String res = new String(charArr, Math.max(index - max, 0), 2*max+1).replaceAll("#","");
        return res;
    }
}
