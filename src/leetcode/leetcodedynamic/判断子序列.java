package leetcode.leetcodedynamic;

/**
 * @author: fangcong
 * @date: 2019/5/7
 */
public class 判断子序列 {
    public boolean isSubsequence(String s, String t) {
       char[] ss = s.toCharArray();
       char[] tt = t.toCharArray();
       int index = 0;

        /**
         * 以母串作为循环对象
         */
        for(char c : tt){
           if(ss[index] == c){
               index++;
               if(index == ss.length)
                   return true;
           }
       }
       return false;
    }

    /**
     * 以子序列作为循环对象
     */
    public boolean isSubsequence2(String s, String t) {
        int index = -1;
        //这里可以提前结束
        for (char c : s.toCharArray()){
            index = t.indexOf(c, index+1);
            if (index == -1) return false;
        }
        return true;
    }
}
