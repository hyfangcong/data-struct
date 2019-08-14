import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/10
 */
public class 举重 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        int sum = 0;
        int left = 0, right = 1;
        for(; right < n ; ){
            if(arr[right]*0.9 > arr[left]){
                left++;
            }else{
                sum += right-left;
                right++;
            }
        }
        System.out.println(sum);
    }
}
