package leetcode.leetcodedynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: fangcong
 * @date: 2019/5/16
 */
public class StickersSpellWord {

    public static void main(String[] args) {
        StickersSpellWord ss = new StickersSpellWord();
        String[] stickers = {"with", "example", "science"};
        System.out.println(ss.minStickers(stickers, "thehat"));
    }
    public int minStickers(String[] stickers, String target) {
        Map<String, Integer> dp = new HashMap<>();
        int n = stickers.length;
        int[][] mp = new int[n][26];
        for(int i = 0 ; i < n ; i++){
            String s = stickers[i];
            for(int j = 0 ; j < s.length(); j ++){
                mp[i][s.charAt(j)-'a'] ++;
            }
        }
        dp.put("", 0);
        int res = helper(target, mp, dp);
        return res;
    }

    /**
     * 原问题转化成子问题：
     *       原问题：拼接target最少需要多少剪纸
     *       子问题：拼接target - 其中一个剪纸后为target2，需要多少剪纸
     *       基本问题： target == "" , 需要0个剪纸。
     * 递归（暴力搜索） + 记忆化（减枝） /  完全背包
     */
    private int helper(String target, int[][] mp, Map<String, Integer> dp){
        if(dp.get(target) != null)   //减枝
            return dp.get(target);

        int[] tar = new int[26];
        for(int i = 0 ; i < target.length() ;i ++){
            tar[target.charAt(i) - 'a'] ++;
        }

        int res = Integer.MAX_VALUE;     //因为要求最小值，初始化res = Integer.MAX_VALUE
        for(int i = 0 ;i < mp.length ; i++){
           if(mp[i][target.charAt(0) - 'a'] == 0)  //优化点：当贴纸中没有target的字符时，不用比较target.length次
               continue;

           StringBuilder sb = new StringBuilder();
           for(int j = 0 ; j < 26 ; j++){
               if(tar[j] > 0){
                   for(int k = 0 ; k < Math.max(0, tar[j] - mp[i][j]); k ++){
                       sb.append((char)(j + 'a'));
                   }
               }
           }
           String s = sb.toString();
            int tmp = helper(s,mp, dp);
            if(tmp != -1){
                res = Math.min(res, tmp + 1);
            }
        }
        dp.put(target, res == Integer.MAX_VALUE ? -1 : res);
        return dp.get(target);
    }
}
