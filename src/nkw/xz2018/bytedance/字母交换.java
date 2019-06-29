package nkw.xz2018.bytedance;

import java.util.*;

/**
 * @author: fangcong
 * @date: 2019/6/29
 */
public class 字母交换 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.next().toCharArray();
        int m = scanner.nextInt();
        System.out.println(solution2(chars,m));
    }


    /**
     * 对数据进行处理
     *
     * 思考：选择在每次考虑时真正需要用到的数据，从这个角度出发，可以减少数据的规模。’【='
     * {@link 用户喜好}有异曲同工之妙
     * @param chars
     * @param m
     * @return
     */
    public static int solution2(char[] chars, int m){
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < chars.length ; i ++){
            List list = map.getOrDefault(chars[i] - 'a', new ArrayList<>());
            list.add(i);
            map.put(chars[i] - 'a', list);
        }

        int res = 0;
        //对所有字母，求在至多m次交换后所能形成最长相同且连续的字串的长度
        for(int i = 0; i < 26; i++){
            res = Math.max(res, cal(map.getOrDefault(i, new ArrayList<>()), m));
        }
        return res;
    }

    private static int cal(List<Integer> p, int m) {
        int[][] dp = new int[p.size()][p.size()];
        for(int i = 0; i < p.size()-1 ; i++){
            dp[i][i + 1] = p.get(i + 1) - p.get(i) - 1;
        }

        for(int len = 2; len < p.size(); len++){
            for(int i = 0; i < p.size() - len; i ++){
                int j = i + len;
                dp[i][j] = dp[i + 1][j - 1] + (p.get(j) - p.get(i) - (j - i));
            }
        }

        int max = 0;
        for(int i = 0 ; i < p.size(); i ++){
            for(int j = i; j < p.size(); j++){
                if(dp[i][j] <= m){
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }

    /**
     * 很直白，以每个字符为中心向两边延伸。 超时
     * @param chars
     * @param m
     * @return
     */
    public static int solution1(char[] chars, int m){
        int n = chars.length;
        int len;
        int sum;
        int left;
        int right;
        int k;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i ++){
            len = 1;
            sum = 1;
            k = m;
            left = right = 0;
            while(len-left-1 <= k || len-right-1<=k){
                if(len-left-1 <= k && i - len >= 0 && chars[i-len] == chars[i]){
                    sum++;
                    k -= len - left -1;
                    left++;
                }

                if(len-right-1 <= k && i + len < n && chars[i + len] == chars[i]){
                    sum++;
                    k -= len - right -1;
                    right++;
                }
                len++;
            }
            max = max > sum ? max : sum;
        }
        return max;
    }
}
