package leetcode.leetcodedynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: fangcong
 * @date: 2019/5/9
 */
public class 我能赢吗 {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(maxChoosableInteger >= desiredTotal)
            return true;
        if(maxChoosableInteger * (maxChoosableInteger + 1) / 2  < desiredTotal)
            return false;

        Map<Integer, Boolean> map = new HashMap<>();
        return win(maxChoosableInteger, desiredTotal, 0, map);
    }

    /**
     * //由于maxChoosableInteger 不会大于 20，所以可以使用一个int型的各个位标记是否使用
     *     //myMap[used]用于标记在使用used（二进制各个位真值代表某个元素是否已经使用，
     *     比如used = “1101”代表使用了1，3，4）情况本次挑选是否能赢
     */
    private boolean win (int len , int nowTarget, int choosed , Map<Integer, Boolean> map){
        if(map.containsKey(choosed))
            return map.get(choosed);

        for(int i = 0 ; i < len ; i ++){
            int cur = 1 << i;
            if((cur & choosed) == 0){
                if(i + 1 >= nowTarget || !win(len, nowTarget - (i + 1), cur | choosed, map)){
                    map.put(choosed, true);
                    return true;
                }
            }
        }
        map.put(choosed, false);
        return false;
    }
}
