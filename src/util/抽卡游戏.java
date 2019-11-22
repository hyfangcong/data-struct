package util;

import java.util.*;

/**
 * @author: fangcong
 * @date: 2019/9/21
 */
public class 抽卡游戏 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t > 0){
            t--;
            int n = scanner.nextInt();
            f(n);
        }
    }

    private static void f(int n){
        Set<String> set = new HashSet<>();
        List<Integer> list = getPrime(n);
        list.add(1);
        int m = list.size();
        int sum = 0;
        for(int i = 2; i <= n; i ++){
            for(int j = 0; j < list.size(); j++){
                if(list.get(j) == 2){
                    if(list.get(j) != i && i % 2 != 0){
                        String s = Math.min(list.get(j), i) + "*" + Math.max(list.get(j), i);
                        if(!set.contains(s)){
                            sum += list.get(j) * i;
                            set.add(s);
                        }
                    }
                }else{
                    if(list.get(j) != i){
                        String s = Math.min(list.get(j), i) + "*" + Math.max(list.get(j), i);
                        if(!set.contains(s)){
                            sum += list.get(j) * i;
                            set.add(s);
                        }
                    }
                }
            }
        }


        int fenmu = n*(n-1) / 2;
        int fenzi =  sum;
        if(fenzi % fenmu == 0)
            System.out.println(fenzi/fenmu);
        else{
            int max = gcd(fenzi, fenmu);
            System.out.println(fenzi/max + "/" + fenmu/max);
        }
    }


    private static int gcd(int m, int n){
        while (m != n) {
            if (m > n)
                m -= n;
            else
                n -= m;
        }
        return m;
    }
    private static List<Integer> getPrime(int n){
        List<Integer> list = new ArrayList<>();
        list.add(2);
        for(int i = 3; i <= n ; i++){
            if(helper(list, i)){
                list.add(i);
            }
        }
        return list;
    }

    private static boolean helper(List<Integer> list, int a){
        for(Integer e : list){
            if(a % e == 0)
                return false;
        }
        return true;
    }
}
