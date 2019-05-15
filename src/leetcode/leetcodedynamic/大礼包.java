package leetcode.leetcodedynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: fangcong
 * @date: 2019/5/14
 */
public class 大礼包 {
    /**
     * 暴力解法(dfs) + 减枝
     *
     * 分为3步：
     * 1. 每种物品都单独购买，需要money1
     * 2. 用大礼包进行替换， 需要money2
     * 3. 取最小值min(money1, money2)
     *
     * 减枝：
     *     1. 当礼包中的物品的数量  >  所需物品的数量， 要进行减枝
     *     2. 为了避免像，礼包1，2 和 礼包2， 1这种情况重复计算两次，可以使用pos来指向当前的位置
     *        允许获取的礼包的索引只能大于等于pos（这种减枝比较隐蔽）
     */

    public static void main(String[] args) {
        大礼包 tt = new 大礼包();
        List<Integer> price = Arrays.asList(2,5);
        List<List<Integer>> special = new ArrayList<>();
        special.add(Arrays.asList(3, 0 , 5));
        special.add(Arrays.asList(1, 2, 10));
        List<Integer> needs = Arrays.asList(3, 2);
        System.out.println(tt.shoppingOffers(price, special, needs));
    }

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return shoppingOffers(price,special, needs, 0);
    }

    private int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int pos){
        int local_min = directParchase(price, needs);
        for(int i = pos; i < special.size() ; i ++){
            List<Integer> tmp = new ArrayList<>();
            List<Integer> offer = special.get(i);
            for(int j = 0 ; j < needs.size(); j ++){
                if(offer.get(j) > needs.get(j)){
                    tmp = null;
                    break;
                }
                tmp.add(needs.get(j) - offer.get(j));
            }
            if(tmp != null){
                local_min = Math.min(local_min, offer.get(offer.size() - 1) + shoppingOffers(price, special, tmp, i));
            }
        }
        return local_min;
    }

    private int directParchase(List<Integer>price, List<Integer> needs){
        int sum = 0;
        for(int i = 0 ; i < needs.size() ; i ++){
            sum += price.get(i) * needs.get(i);
        }
        return sum;
    }
}
