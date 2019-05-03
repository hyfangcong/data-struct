package leetcode.leetcodedynamic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 三角形最小路径和 {

    private static int[][] memo;
    private static int tryMinimum(int row, int index, List<List<Integer>> triangle){
        if(row == triangle.size())
            return 0;
        if(memo[row][index] != 0)
            return memo[row][index];

        if(row + 1 < triangle.size()){
            List<Integer> list = triangle.get(row + 1);
            memo[row][index]  = Math.min(tryMinimum(row + 1, index, triangle) + list.get(index),
                    tryMinimum(row + 1, index + 1, triangle) + list.get(index + 1));
        }
        return memo[row][index];
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        memo = new int[triangle.size()][triangle.size()];
        return tryMinimum(0, 0 , triangle) + triangle.get(0).get(0);
    }


    public static int minimumTotal2(List<List<Integer>> triangle){
        if(triangle == null || triangle.size() == 0)
            return 0;

        int n = triangle.size();
        int[] memory = new int[n + 1];

        for(int i = n - 1 ; i >= 0 ; i --){
            for(int j = 0; j <= i; j ++){
                memory[j] = Math.min(memory[j], memory[j + 1]) + triangle.get(i).get(j);
            }
        }
        return memory[0];
    }
    public static void main(String[] args) {
        List<List<Integer>>triangle = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        for(int i = 1; i <= 4 ; i ++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0 ; j < i ; j ++){
                list.add(scanner.nextInt());
            }
            triangle.add(list);
        }

        System.out.println(minimumTotal2(triangle));
    }
}
