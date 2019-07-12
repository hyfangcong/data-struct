package river;

/**
 * @author: fangcong
 * @date: 2019/7/10
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 在大小为n的数组中取出m个数，要求取出的数保持在原数组中的顺序，并且每个数被选取的概率相等
 */

public class n中取m个数等概率 {

    /**
     * 1.knuth-shuffle洗牌算法
     *
     * 每个元素被选取的概率都是m/n
     *
     * 对于位置i上的元素：第一次选中的概率为 1/n, 第二次选中的概率为 (n-1/n) * (1/n-1) = 1/n,
     * 第三次选中的概率为 (n-1/n) * (n-2/n-1) * (1/n-2) = 1/n .... 因此每个元素被选取的概率为m/n
     */
    public void knuthShuffle(int[] arr, int n, int m){
        /**
         * 这里选取的元素是乱序的，还需要进行排序。可以新建一个Node保存其位置信息，然后按照位置进行排序
         */
        List<Integer> result = new ArrayList<>();
        for(int i = n-1; i >= n - m ; i --){
            int select = (int)(Math.random() * i);
            result.add(arr[select]);
            swap(arr, select, i);
        }
    }

    public void swap(int[]arr, int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 蓄水池算法：当n的大小不确定的时候，或者说数组是动态生成的时候。
     *
     * 证明待完成
     */


}
