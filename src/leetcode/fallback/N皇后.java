package leetcode.fallback;

import java.util.ArrayList;
import java.util.List;

public class N皇后 {

    private static List<List<String>> res;
    private static boolean[] col;
    private static boolean[] diagonal1;
    private static boolean[] diagonal2;
    private static List<Integer> place;

    private static List<String> generateBoard(int n, List<Integer> list){
        List<String> res = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            String temp = "";
            int col = list.get(i);
            for(int j = 0 ; j < n ; j ++){
                if(j == col)
                    temp += "Q";
                else
                    temp += ".";
            }
            res.add(temp);
        }
        return res;
    }

    private static void dfs(int n, int index){
        if (index == n){
            //把这个结果集存储起来
            res.add(generateBoard(n, place));
            return;
        }

        for(int j = 0; j < n ; j ++){
            if(!col[j] && !diagonal1[index + j] &&!diagonal2[index - j + n - 1]){
                place.add(j);
                col[j] = true;
                diagonal1[index + j] = true;
                diagonal2[index - j + n - 1] = true;
                dfs(n, index + 1);
                place.remove(place.size() - 1);
                col[j] = false;
                diagonal1[index + j] = false;
                diagonal2[index - j + n - 1] = false;
            }
        }

    }

    public static List<List<String>> solveNQueens(int n) {
        col = new boolean[n];
        diagonal1 = new boolean[n * 2 - 1];
        diagonal2 = new boolean[n * 2 - 1];
        place = new ArrayList<>();
        res = new ArrayList<>();
        dfs(n, 0);
        return res;
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        solveNQueens(15);
        System.out.println(res.size());
        System.out.println((System.nanoTime() - start) / 1000000000);
//        for(int i = 0 ; i < res.size(); i ++){
//            List<String> temp = res.get(i);
//            for(int j = 0; j < temp.size() ; j ++){
//                System.out.println(temp.get(j));
//            }
//            System.out.println();
//        }
    }
}
