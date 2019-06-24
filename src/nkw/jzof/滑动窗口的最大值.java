package nkw.jzof;

import java.util.ArrayList;

/**
 * @author: fangcong
 * @date: 2019/6/24
 */
public class 滑动窗口的最大值 {
    public static void main(String[] args) {
        滑动窗口的最大值 instance = new 滑动窗口的最大值();
        int[] num = {2, 3, 4, 2, 6, 2, 5, 1};
        ArrayList<Integer> res = instance.maxInWindows(num, 3);
        System.out.println(res.size());
    }

    public ArrayList<Integer> maxInWindows(int[] num, int size) {

        ArrayList<Integer> res = new ArrayList<>();
        if (size == 0 || size > num.length)
            return res;
        int max;
        max = findMax(num, 0, size - 1);
        res.add(max);
        for (int i = 1; i + size <= num.length; i++) {
            if (num[i + size - 1] >= max) {
                max = num[i + size - 1];
                res.add(max);
            } else if (num[i - 1] == max) {
                max = findMax(num, i, i + size - 1);
                res.add(max);
            } else
                res.add(max);
        }
        return res;
    }

    private int findMax(int[] arr, int start, int end) {
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            max = Math.max(arr[i], max);
        }
        return max;
    }
}
