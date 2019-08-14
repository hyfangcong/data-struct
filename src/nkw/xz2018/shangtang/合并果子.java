package nkw.xz2018.shangtang;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/14
 */

/**
 * 求出所有点中到到其他点的加权距离最小的那个点，称之为最优点
 *
 * 加权距离公式为： wi * (|xi-xj| + |yi - yj|)
 *
 * 思路：x与y坐标是独立的，分别找出x和y的最优点（虚拟最优点）。
 *
 * 然后对集合中的点和（x，y）计算距离进行排序。因此最优点必定在这个排序后的数组中的前面
 */
public class 合并果子 {
    static class Point{
        long x,y,w;
        public Point(int x, int y, int w){
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Point[] arr = new Point[n];
        long total = 0;
        for(int i = 0; i < n ; i++){
            arr[i] = new Point(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
            total += arr[i].w;
        }

        Arrays.sort(arr, Comparator.comparingInt(m -> (int)m.x));
        long x = find(arr, total).x;
        Arrays.sort(arr, Comparator.comparingInt(m -> (int)m.y));
        long y = find(arr, total).y;
        Arrays.sort(arr, Comparator.comparingInt(m -> (int)(Math.abs(m.x - x) + Math.abs(m.y - y))));

        long ans = Long.MAX_VALUE;
        long sum;
        for(int i = 0; i < Math.min(50, n); i++){
            sum = 0;
            for(Point item : arr){
                sum += item.w * (Math.abs(item.x - arr[i].x) + Math.abs(item.y - arr[i].y));
            }
            ans = Math.min(ans, sum);
        }
        System.out.println(ans);
    }


    public static Point find(Point[] arr, long total){
        long half = total >> 1;
        long count = 0;
        for(Point i : arr){
            count += i.w;
            if(count >= half){
                return i;
            }
        }
        return arr[arr.length-1];
    }
}
