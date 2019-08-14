import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/10
 */
public class 请求队列 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i < n; i ++){
            arr[i] = scanner.nextInt();
        }
        int p = 0, sum = 0, curMax = arr[0];
        for(int i = 1; i < n; ){
            while (i < n && arr[i] > arr[i-1]){
                p = i;
                i++;
            }
            if(i == n){
                System.out.println(sum);
                return;
            }else{
                while (i < n && arr[i] < arr[i-1]){
                    i++;
                }
                if(i == n){
                    System.out.println(sum);
                    return;
                }else{
                    if(i -p == 1){
                        curMax++;
                        sum++;
                        arr[i] = curMax;
                        p=i;
                    }else{
                        int tmp = Math.max(curMax + 1, arr[i] + 1 - (i - p - 2));
                        for(int j = p+1; j < i; j++){
                            sum += (tmp - arr[j]);
                            tmp++;
                        }
                        p = i-1;
                        curMax = tmp-1;
                        arr[i - 1] = curMax;
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
