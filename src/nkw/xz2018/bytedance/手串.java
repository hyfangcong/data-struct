package nkw.xz2018.bytedance;

import java.util.*;

/**
 * @author: fangcong
 * @date: 2019/6/30
 */

/**
 * 每次考虑的时候只需要考虑一种颜色。因此以颜色x为key，x出现的位置为value构建map可以减少数据规模。
 *
 * 思考：每次考虑的时候只选取真正需要的数据，可以减少数据规模。
 * {@link 用户喜好}
 * {@link 字母交换}
 */
public class 手串 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int c = scanner.nextInt();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n ; i++){
            int k = scanner.nextInt();
            for(int j = 0; j < k ; j ++){
                int x = scanner.nextInt();
                List<Integer> list = map.getOrDefault(x, new ArrayList<>());
                list.add(i);
                map.put(x, list);
            }
        }
        int sum = 0;
        Iterator<Map.Entry<Integer, List<Integer>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, List<Integer>> next = iterator.next();
            List<Integer> list = next.getValue();
            if(list.size() < 2)
                continue;
            for(int i = 0 ; i < list.size(); i ++){
                if(i == list.size() - 1){
                    int dest = 1 + Math.min(list.get(i) - list.get(0), (list.get(0) - list.get(i) + n) % n);
                    if(dest <= m){
                        sum++;
                    }
                }else{
                    if(list.get(i + 1) - list.get(i) + 1 <= m){
                        sum++;
                        break;
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
