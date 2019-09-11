package qz2019.baidu;

import java.util.*;

/**
 * @author: fangcong
 * @date: 2019/9/10
 */
public class 叶子节点删除计划 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ans = new int[n+1];
        boolean[] isVisited = new boolean[n+1];
        Map<Integer, Integer> map = new HashMap<>();
        int[] dushu = new int[n+1];
        for(int i = 1; i < n; i++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            map.put(y, x);
            dushu[x]++;
        }
        int total = n;
        int time = 1;
        while(total > 0){
            int[] tmp = new int[n+1];
            System.arraycopy(dushu,0,tmp,0,tmp.length);
            for(int i = 1; i <= n; i ++ ){
                if(tmp[i] == 0 && !isVisited[i]){
                    isVisited[i] = true;
                    total--;
                    ans[i] = time;
                    int x = 1;
                    if(map.containsKey(i))
                        x = map.get(i);
                    if(dushu[x] > 0){
                        dushu[x]--;
                    }
                }
            }
            time++;
        }
        for(int i = 1; i <= n; i ++){
            System.out.print(ans[i]+" ");
        }
    }
}
