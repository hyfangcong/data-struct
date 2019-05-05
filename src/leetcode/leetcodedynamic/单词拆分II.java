package leetcode.leetcodedynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: fangcong
 * @date: 2019/5/4
 */
public class 单词拆分II {
    /**
     * 字符串s利用wordDict拆分为句子，可以将原问题拆分为子问题：
     *
     * s[0...n] = s.sub(0...m) + s[m...n]； (s.sub(0...m)字符串为wordDict中的任意一个单词)
     *
     * 基本子问题为：s为空，这时就得到了一个句子；  或者以s开头，在wordDict中找不到对应的单词(不满足，舍弃)。
     *
     * 用wordlist来记录中间结果，然后进行递归回溯。
     *
     */

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        List<String> wordList = new ArrayList<>();
        if(wordBreak_check(s, wordDict)){
            add(res, wordList, s, wordDict);
        }
        return res;
    }

    public void add(List<String> res, List<String> wordList, String s, List<String> wordDict){
        for(String word : wordDict){
            if(s.startsWith(word)){
                if(s.length() == word.length()){
                    StringBuilder stringBuilder = new StringBuilder();
                    for(String item : wordList){
                        stringBuilder.append(item).append(" ");
                    }
                    stringBuilder.append(word);
                    res.add(stringBuilder.toString());
                }else{
                    wordList.add(word);
                    add(res, wordList, s.substring(word.length()), wordDict);
                    //回溯
                    //这里不需要判断wordList是否为空，一个if判断已经保证了wordList在这里始终不为空。
                    wordList.remove(wordList.size() - 1);
                }
            }
        }
    }

    public boolean wordBreak_check(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        int maxLen = Integer.MIN_VALUE;
        for(String item : wordDict)
            maxLen = maxLen > item.length() ? maxLen : item.length();

        for(int i = 1 ; i <= n; i++){
            /**
             * j的取值范围可以优化，不用每次都从0开始取值，j = max(0, i - maxLen); maxLen是wordDict中单词的最大长度
             */
            for(int j = Math.max(0, i - maxLen); j < i ; j ++){
                if(dp[j] && wordDict.contains(s.substring(j, i)))
                    dp[i] = true;
            }
        }
        return dp[n];
    }
}
