package nkw.xz2018.meituandianping;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/17
 */
public class 题目列表 {
    static class Pair{
        String name;
        int rank;
        public Pair(String name, int rank){
            this.name = name;
            this.rank = rank;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Pair[] arr = new Pair[n];
        for(int i = 0; i < n ; i++){
            String name = scanner.next();
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            int rank;
            if(y / x <= 0.3){
                rank = 5;
            }else if(y / x <= 0.6){
                rank = 4;
            }else
                rank = 3;
            arr[i] = new Pair(name,rank);
        }
        Arrays.sort(arr, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        for(Pair pair : arr){
            System.out.print(pair.name + " " + pair.rank);
            System.out.println();
        }
    }
}
