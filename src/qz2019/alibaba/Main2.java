package qz2019.alibaba;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/30
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int k = scanner.nextInt();
        int index = getLuckBoy(s);
        int max = getLong(s,k, index);
        System.out.println(index +" "+ max);
    }

    private static int getLong(String s, int k, int first) {
        int n = s.length();
        int ans = 0;
        int j = 0;
        int tmp = 0;
        for(int i = first; j < n; i++, j++){
            if(s.charAt((i % n)) == 'g'){
                tmp++;
                if(tmp > k){
                    ans =  j - k;
                    break;
                }
            }
        }
        if(j == n){
            ans = n - tmp;
        }

        tmp = 0;
        j = 0;
        int ans2 = 0;
        for(int i = first; j < n; i--,j++){
            if(s.charAt((i + n) % n) == 'g'){
                tmp++;
                if(tmp > k){
                    ans2 = j - k;
                    break;
                }
            }
        }
        if(j == n){
            ans2 = n - tmp;
        }
        return ans > ans2 ? ans : ans2;
    }

    private static int getLuckBoy(String s) {
        int n = s.length();
        int max = 0, first = -1;
        for(int i = 0; i < n; i ++){
            if(s.charAt(i) == 'b'){
                int tmp = 0;
                if(i!=0 && s.charAt((i-1+n) % n) == 'g')
                    tmp++;
                if(s.charAt((i+1) % n) == 'g')
                    tmp++;
                if(tmp > max){
                    max = tmp;
                    first = i;
                }
            }
        }
        return first;
    }
}
