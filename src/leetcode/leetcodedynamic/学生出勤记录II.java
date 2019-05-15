package leetcode.leetcodedynamic;

/**
 * @author: fangcong
 * @date: 2019/5/14
 */
public class 学生出勤记录II {
    public static void main(String[] args) {
        System.out.println(checkRecord(100));
    }

    /**
     * p:    序列中没有a，最后一个是P
     * ap:   序列中有a， 最后一个是p
     * l:    序列中没有a， 最后一个是l
     * ll:   序列中没有a， 最后连续连个都是l
     * al:   序列中有a， 最后一个是l
     * all:  序列中有a， 最后连续两个都是l
     * a:    序列中有a，最后一个是a
     */
    public static int checkRecord(int n) {
        long[] p = new long[2];
        long[] ap = new long[2];
        long[] l = new long[2];
        long[] ll = new long[2];
        long[] al = new long[2];
        long[] all = new long[2];
        long[] a = new long[2];
        p[0] = l[0] = a[0] = 1;

        int M = (int)1e9 + 7;
        int cur = 0;
        int last = 0;
        for(int i = 1 ; i < n ; i++){
            cur = i % 2;
            last = (i - 1) % 2;
            p[cur] = (p[last] + l[last] + ll[last]) % M;
            ap[cur] = (ap[last] + al[last] + all[last] + a[last]) % M;
            l[cur] = p[last] % M;
            ll[cur] = l[last] % M ;
            al[cur] = (ap[last]  + a[last]) % M;
            all[cur] = al[last] % M;
            a[cur] = p[cur];
        }
        return (int)((p[cur] + ap[cur] + l[cur] + ll[cur] + al[cur] + all[cur] + a[cur]) % M);
    }
}
