package leetcode.leetcodedynamic;

import java.util.*;

/**
 * @author: fangcong
 * @date: 2019/5/8
 */
public class 青蛙过河 {

    /**
     * 超时,同样的算法c++可以通过
     */
    public static boolean canCross(int[] stones) {
        int n = stones.length;
        if(n < 2)
            return true;
        Map<Integer, HashSet<Integer>> dest = new HashMap<>();
        for(int i = 0 ; i < n ; i ++){
            dest.put(i, new HashSet<>());
        }

        dest.get(0).add(0);
        for(int i = 1 ; i < n ; i ++){
            for(int j = i - 1 ; j >= 0 ; j --){
                    int d = stones[i] - stones[j];
                    for(Integer item : dest.get(j)){
                        if(d == item - 1 || d == item || d == item + 1){
                            dest.get(i).add(d);
                            break;
                        }
                    }
            }
        }
        return !dest.get(n - 1).isEmpty();
    }

    /**
     *
     */
    public boolean canCross2(int[] stones) {
        if(stones.length ==0) return false;
        Map<Integer,Set<Integer>> m = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            m.put(stones[i],new HashSet<>());
        }
        m.get(0).add(0);
        for (int i = 0; i < stones.length; i++) {
            for (Integer now : m.get(stones[i])) {
                for (int j = now-1; j <= now+1; j++) {
                    if(j>0 && m.containsKey(stones[i] + j)){
                        m.get(stones[i] + j).add(j);
                    }
                }
            }
        }
        return !m.get(stones[stones.length-1]).isEmpty();
    }


    public static void main(String[] args) {
        int[] stones = {0,1,2,3,4,8,9,11};
        System.out.println(canCross(stones));
    }
}
