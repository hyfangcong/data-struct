package nkw.xz2018.bytedance;

import java.util.*;

/**
 * @author: fangcong
 * @date: 2019/6/29
 */
public class 用户喜好 {
    public static void main(String[] args) {
        solution2();
    }

    /**
     * 对数据进行处理。
     * 以用户喜爱值x为key建立map，可以减少每次查询时搜索的数据量
     *
     * 思考：选择在每次考虑时真正需要用到的数据，从这个角度出发，可以减少数据的规模。
     *
     * {@link 字母交换}有异曲同工之妙
     */
    public static void solution2() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int k = scanner.nextInt();
            List<Integer> list = map.getOrDefault(k, new ArrayList<>());
            list.add(i);
            map.put(k, list);
        }

        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int k = scanner.nextInt();
            List<Integer> list = map.getOrDefault(k, new ArrayList<>());
            int sum = 0;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) >= l && list.get(j) <= r)
                    sum++;
            }
            System.out.println(sum);
        }
    }


    /**
     * 暴力搜索，没有对数据进行处理
     */
    public static void solution() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = scanner.nextInt();
        }
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int k = scanner.nextInt();
            int sum = 0;
            for (int j = l; j <= r; j++) {
                if (arr[j] == k)
                    sum++;
            }
            System.out.println(sum);
        }
    }
}
