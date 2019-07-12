package nkw.xz2018.pinduoduo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/7/12
 */
public class 小熊吃糖 {
    static class Bear{
        int level;
        int hungry;
        int index;

        public Bear(int level, int hungry, int index){
            this.level = level;
            this.hungry = hungry;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer> hungry = new ArrayList<>();
        for(int i = 0 ; i < m ; i ++){
            hungry.add(scanner.nextInt());
        }
        Bear[] ber = new Bear[n];
        for(int i = 0 ; i < n ; i ++){
            ber[i] = new Bear(scanner.nextInt(), scanner.nextInt(), i);
        }

        Collections.sort(hungry);
        Arrays.sort(ber, ((o1, o2) -> o2.level - o1.level));
        for(int i = 0 ; i < n ; i ++){
            if(hungry.isEmpty())
                break;
            int target = ber[i].hungry;
            while(target > 0 && !hungry.isEmpty()){
                int index = binarySearch(hungry, target, 0, hungry.size() - 1);
                if(index == -1)
                    break;
                else{
                    target -= hungry.get(index);
                    hungry.remove(index);
                }
            }
            ber[i].hungry = target;
        }

        Arrays.sort(ber, (o1, o2) -> o1.index - o2.index);
        for(int i = 0 ; i < n ;i ++){
            System.out.println(ber[i].hungry);
        }
    }

    private static int binarySearch(ArrayList<Integer> hungry, int target, int left, int right) {
        if(left > right)
            return right;
        int mid = left + (right - left) / 2;
        if(hungry.get(mid) == target){
            return mid;
        }else if(hungry.get(mid) > target){
           return binarySearch(hungry, target, left, mid - 1);
        }else{
            return binarySearch(hungry, target, mid + 1, right);
        }
    }
}
