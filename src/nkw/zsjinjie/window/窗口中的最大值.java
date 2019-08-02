package nkw.zsjinjie.window;

/**
 * @author: fangcong
 * @date: 2019/8/1
 */

import java.util.LinkedList;

/**
 * 固定窗口中的最大值
 *
 * 已知一个数组arr，和一个窗口的大小为k，窗口依次向右滑动，把窗口中的最大值依次记录到数组中
 *
 * 使用双端队列，时间复杂度为O（N）因为每个元素最多只会进出双端队列1次
 */
public class 窗口中的最大值 {
    public static void main(String[] args) {
        int[] arr = {2,4,1,5,3,1,2};

        int[] res = maxInWindow(arr, 3);
        for(int item : res){
            System.out.print(item + " ");
        }
    }


    public static int[] maxInWindow(int[] arr, int k){
        int[] res = new int[arr.length - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();

        //初始化双端队列
        for(int i = 0 ; i < k-1; i++){
            if(queue.isEmpty()){
                queue.addLast(i);
            }else{
                while(!queue.isEmpty() && arr[queue.getLast()] <= arr[i]){
                    queue.removeLast();
                }
                queue.addLast(i);
            }
        }

        //开始记录窗口中的最大值
        int index = 0;
        for(int i = k-1; i < arr.length; i++){
           while(!queue.isEmpty() && arr[queue.getLast()] <= arr[i]){
               queue.removeLast();
           }
           queue.addLast(i);
           if(i - queue.getFirst() == k){
               queue.removeFirst();
           }
           res[index++] = arr[queue.getFirst()];
        }
        return res;
    }
}
