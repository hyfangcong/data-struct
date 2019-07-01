package nkw.xz2018.weipinhui;

import java.util.*;

/**
 * @author: fangcong
 * @date: 2019/7/1
 */

/***
 *
 */
public class 数独 {
    static int[] rowValid;  //行是否有重复数字
    static int[] colValid;  //列是否有重复数字
    static int[][] smallValid; //小九宫格是否有重复数字
    static int[][] res;    //存储最终结果
    static int[][] arr;
    public static void main(String[] args) {
        res = new int[9][9];
        arr = new int[9][9];
        rowValid = new int[9];
        colValid = new int[9];
        smallValid = new int[3][3];

        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < 9; i ++){
            for(int j = 0; j < 9 ; j ++){
                int x = scanner.nextInt();
                rowValid[i] = rowValid[i] | (1 << x);
                colValid[j] = colValid[j] | (1 << x);
                smallValid[i/3][j/3] = smallValid[i/3][j/3] | (1 << x);
                res[i][j] = x;
                arr[i][j] = x;
            }
        }
        dfs(0,0);
    }

    public static void dfs(int row, int col){
        if(row == 9){
            //得到结果，立即打印（或者转存）。
            for(int i = 0; i < 9; i ++){
                for(int j = 0; j < 9; j ++){
                    if(j == 8){
                        System.out.println(res[i][j]);
                    }else{
                        System.out.print(res[i][j] + " ");
                    }
                }
            }
            //return之后就会进行回溯了，到程序退出的时候，rowValid colValid smallValid的状态和初始状态一致
            return;
        }

        /**
         * 递归推进的方向：从左向右，从上向下
         */
        if(col < 9){
            if(arr[row][col] != 0){
                dfs(row, col + 1);
            }else {

                //每个单元格的可能更选取的数值范围
                for(int i = 1; i <= 9; i ++){
                    if((rowValid[row] & (1 << i)) == 0 && (colValid[col] & (1 << i)) == 0
                            && (smallValid[row/3][col/3] & (1 << i)) == 0){
                        changeStatus(row, col, i, true);
                        res[row][col] = i;
                        dfs(row, col + 1);
                        changeStatus(row, col, i, false);
                    }
                }
            }
        }else
            dfs(row+1, 0);
    }

    //flag == true添加状态， flag == false 取消状态
    public static void changeStatus(int row, int col, int num, boolean flag){
        if(flag){
            rowValid[row] = rowValid[row] | (1 << num);
            colValid[col] = colValid[col] | (1 << num);
            smallValid[row/3][col/3] = smallValid[row/3][col/3] | (1 << num);
        }else{
            rowValid[row] = rowValid[row] & (0xffff ^ (1 << num));
            colValid[col] = colValid[col] & (0xffff ^ (1 << num));
            smallValid[row/3][col/3] = smallValid[row/3][col/3] & (0xffff ^ (1 << num));
        }
    }
}
