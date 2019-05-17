package leetcode.leetcodedynamic;

/**
 * @author: fangcong
 * @date: 2019/5/17
 */
public class MinimumSwapsMakeSequencesIncreasing {
    /**
     * swapRecode和fixRecode表示数组合法的情况下，第i位交换和不交换所需的最少操作数。
     *
     * index               0    1    2    3    4
     * A                   1    3    5    4    9
     * B                   1    2    3    7    10
     * swapRecord          1    1    2    1    2
     * fixRecord           0    0    0    2    1
     *
     * 由于当前位置只和上一步有关，因此不需要使用数组来记录。
     *
     */
    public int minSwap(int[] A, int[] B) {
      int swapRecode = 1, fixRecode = 0;
      for(int i = 1 ; i < A.length ; i++){
          if(A[i - 1] >= B[i] || B[i - 1] >= A[i]){
              //this case, if swap i ,you should swap i - 1, so swapRecode[i] = swapRecode[i - 1] + 1；
              swapRecode++;
          }else if(A[i - 1] >= A[i] || B[i - 1] >= B[i]){
              int tmp = swapRecode;
              swapRecode = fixRecode + 1;
              fixRecode = tmp;
          }else{
              int min = Math.min(swapRecode, fixRecode);
              fixRecode = min;
              swapRecode = min +1;
          }
      }
      return Math.min(swapRecode, fixRecode);
    }
}
