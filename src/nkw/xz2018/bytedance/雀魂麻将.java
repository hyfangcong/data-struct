package nkw.xz2018.bytedance;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/9/5
 */
public class 雀魂麻将 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] state = new int[9];
        int[] helpArr = new int[9];
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < 13; i ++){
            int num = scanner.nextInt();
            state[num-1]++;
        }
        for(int i = 0 ; i < 9; i ++){
            if(state[i] < 4){
                int num = i + 1;
                System.arraycopy(state,0,helpArr,0,9);
                helpArr[i]++;
                if(canHu(helpArr, 14, false)){
                    ans.add(num);
                }
            }
        }
        if(ans.size() == 0)
            System.out.println(0);
        else{

        }
    }

    private static boolean canHu(int[] arr, int total, boolean hasHead) {
        if(total == 0) return true;
        if(!hasHead){
            for(int i = 0 ; i < 9; i ++){
                if(arr[i] >= 2){
                    arr[i] -= 2;
                    if(canHu(arr, total - 2, true)) return true;
                    arr[i] += 2;
                }
            }
            return false;
        }else{
            for(int i = 0 ; i < 9; i ++){
                if(arr[i] > 0){
                    if(arr[i] >= 3){
                        arr[i] -= 3;
                        if(canHu(arr, total - 3, false)) return true;
                        arr[i] += 3;
                    }

                    if(i+2 < 9 && arr[i+1] > 0 && arr[i+2] > 0){
                        arr[i]--;
                        arr[i+1]--;
                        arr[i+2]--;
                        if (canHu(arr, total-3, false)) return true;
                        arr[i]++;
                        arr[i+1]++;
                        arr[i+2]++;
                    }
                }
            }
        }
        return false;
    }
}
