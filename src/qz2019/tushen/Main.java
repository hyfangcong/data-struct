package qz2019.tushen;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/9/13
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 0 ; i < n ; i++){
            String a = scanner.next();
            String b = scanner.next();
            f1(a,b);
        }
    }

    private static void f1(String a, String b){
        int ans = 0;
        int n = a.length();
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i ++){
            if(a.charAt(i) != b.charAt(i)){
                ans++;
                list.add(i);
            }
        }
        int[] arr = new int[list.size()];
        for(int i = 0 ; i < arr.length;  i ++){
            arr[i] = list.get(i);
        }
        boolean flag = f2(arr, 0, a.toCharArray(), b.toCharArray());
        if(flag){
            System.out.println(ans);
        }else{
            System.out.println(-1);
        }
    }

    private static boolean f2(int[] arr, int index, char[] a, char[] b){
        if(index == arr.length)
            return true;
        for(int i = index; i < arr.length; i ++){
            swap(arr, index, i);
             char tmp = a[arr[i]];
            a[arr[i]] = b[arr[i]];
            String s = new String(a);
            if(isPrime(Integer.valueOf(s))){
                f2(arr, i+1, a, b);
            }
            a[arr[i]] = tmp;
        }
        return false;
    }

    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static boolean isPrime(int num) {
        if (num <= 3) {
            return num > 1;
        }
        // 不在6的倍数两侧的一定不是质数
        if (num % 6 != 1 && num % 6 != 5) {
            return false;
        }
        int sqrt = (int) Math.sqrt(num);
        for (int i = 5; i <= sqrt; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
