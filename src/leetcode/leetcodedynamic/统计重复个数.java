package leetcode.leetcodedynamic;

/**
 * @author: fangcong
 * @date: 2019/5/9
 */
public class 统计重复个数 {

    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        char[] ss1 = s1.toCharArray();
        char[] ss2 = s2.toCharArray();

        /**
         * index2为ss2的索引， num1当前使用了ss1的个数， num2当前匹配的ss2的个数
         */
        int index2 = 0 , num1 = 0, num2 = 0;
        while(num1 < n1){
            for(int i = 0 ; i < ss1.length ; i ++){
                if(ss1[i] == ss2[index2]){
                    if(index2 == ss2.length - 1) {
                        index2 = 0;
                        num2 ++;
                    }else
                        index2 ++;
                }
            }
            num1++;
        }
        return num2 / n2;
    }
}
