package nkw.xz2018.jingdong;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/7/12
 */
public class 数据分页说明 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i ++){
            arr[i] = scanner.nextInt();
        }
        int page = scanner.nextInt();
        int size = scanner.nextInt();

        int index = page * size;
        if(index >= n){
            System.out.println("超出分页范围");
        }else{
            for(int i = index,  j = 0; i < n && j < size; i++, j ++){
                System.out.println(arr[i]);
            }
        }
    }
}
