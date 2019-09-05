package qz2019.shunfeng;

import java.util.*;

/**
 * @author: fangcong
 * @date: 2019/8/29
 */
public class Main4 {
    static Map<Integer, Set<Integer>> languageMap = new HashMap<>();
    static Map<Integer,Set<Integer>> personMap = new HashMap<>();
    static Map<Integer,Boolean> used = new HashMap<>();
    static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        for(int i=0;i<n;i++){
            personMap.put(i+1,new HashSet<>());
            used.put(i+1,false);
        }
        for(int i=0;i<m;i++){
            languageMap.put(i+1,new HashSet<>());
        }
        for(int i=0;i<k;i++){
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            languageMap.get(v).add(u);
            personMap.get(u).add(v);
        }
        for(int i=1;i<=n;i++){
            dfs(i,i);
        }
        System.out.println(count-1);
    }
    private static void dfs(int i,int j){
        if(used.get(i)){
            return;
        }
        if(j == i)
            count++;
        used.put(i,true);
        for(Integer integer: personMap.get(i)){
            for(Integer integer1: languageMap.get(integer)){
                dfs(integer1,j);
            }
        }
    }
}