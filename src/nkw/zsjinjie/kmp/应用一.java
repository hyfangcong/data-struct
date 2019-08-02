package nkw.zsjinjie.kmp;

/**
 * @author: fangcong
 * @date: 2019/8/1
 */

import nkw.zsjinjie.dandiaozhan.最大子矩阵;

import java.util.Scanner;

/**
 * 已知一个字符串s，现在在s的后面添加字符，要求形成的新字符串T，T中包含两个起始位置不同的原字符串s，并且T最短
 *
 * s: abcabc
 * T1: abcabcabc
 * T2: abcabcabcabc
 *
 * 其实就是求s的前缀后缀的最长匹配
 */
public class 应用一 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        字符串匹配 bean = new 字符串匹配();
        while(scanner.hasNext()){
            String s = scanner.next();
            String newString = s + "a"; //+的后面可以是任意值
            int[] next = bean.getNext(newString);
            String res = s + s.substring(next[next.length-1]);
            System.out.println(res);
            System.out.println(next[next.length-1]);
        }

    }
}
