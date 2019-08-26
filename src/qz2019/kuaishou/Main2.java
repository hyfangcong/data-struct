package qz2019.kuaishou;

/**
 * @author: fangcong
 * @date: 2019/8/25
 */
import java.util.*;

public class Main2 {
    public static void main(String[] args){
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final int[] arr = new int[n];
        boolean[] visit = new boolean[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
            visit[i] = helper(arr[i]);
        }
        for (boolean b : visit) {
            System.out.println(b);
        }
    }

    private static boolean helper(int val) {
        int sum = getSum(val);
        HashSet<Integer> set = new HashSet<>();
        set.add(val);
        while(sum != 1){
            final boolean hasAdd = set.contains(sum);
            if(hasAdd){
                return false;
            }
            set.add(sum);
            sum = getSum(sum);
        }
        return true;
    }

    private static int getSum(int val) {
        String str = val + "";
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            int value = Integer.parseInt(str.charAt(i) + "");
            sum += value * value;
        }
        return sum;
    }

}