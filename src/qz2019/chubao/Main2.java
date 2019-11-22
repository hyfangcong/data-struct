package qz2019.chubao;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/9/22
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String[] opr = s.split("\\+|\\-|\\/");
        int[] nums = new int[opr.length];
        for(int i = 0 ; i< nums.length; i ++){
            nums[i] = Integer.valueOf(opr[i]);
        }
        char[] chars = new char[2];
        int index = 0;
        boolean flag = false;
        for(int i = 0 ; i < s.length(); i ++){
            if(s.charAt(i) < '0' || s.charAt(i) > '9'){
                if(flag){
                    chars[index++] = s.charAt(i);
                    flag = false;
                }else{
                    flag = true;
                }
            }
        }
        f(nums, chars);
    }

    private static void f(int[] nums, char[] opt ){
        for(int i = 1; i < nums.length; i +=2) {
            if (nums[i] == 0) {
                System.out.println("error");
                return;
            }
        }
            if(check(opt[0]) - check(opt[1]) > 0){
                int fenzi = nums[0] * nums[3];
                int fenmu = nums[1] * nums[2];
                int tmp = fenmu;
                fenmu = fenmu * nums[5];
                int p = fenzi * nums[5];
                int q = nums[4] * tmp;
                fenzi = helper(p, q, opt[1]);
                if(fenzi == 0){
                    System.out.println(0);
                    return;
                }
                int maxgcd = gcd(Math.abs(fenzi), fenmu);
                if(fenzi < 0){
                    System.out.println("-"+fenzi/maxgcd + "/" + fenmu/ maxgcd);
                }else{
                    System.out.println(+fenzi/maxgcd + "/" + fenmu/ maxgcd);
                }
            }else if(check(opt[0]) - check(opt[1]) < 0){
                int fenzi = nums[2] * nums[5];
                int fenmu = nums[3] * nums[4];
                int tmp = fenmu;
                fenmu = fenmu * nums[1];
                int p = fenzi * nums[1];
                int q = nums[0] * tmp;
                fenzi = helper(p, q, opt[0]);
                if(fenzi == 0){
                    System.out.println(0);
                    return;
                }
                int maxgcd = gcd(Math.abs(fenzi), fenmu);
                if(fenzi < 0){
                    System.out.println("-"+fenzi/maxgcd + "/" + fenmu/ maxgcd);
                }else{
                    System.out.println(+fenzi/maxgcd + "/" + fenmu/ maxgcd);
                }
            }else{
                if(opt[0] == '/'){
                    int fenzi = nums[0] * nums[3] * nums[4];
                    int fenmu = nums[1] * nums[2] * nums[5];
                    int maxgcd = gcd(fenzi, fenmu);
                    System.out.println(fenzi/maxgcd+"/" + fenmu/maxgcd);
                }else if(opt[0] == '+' && opt[1] == '+'){
                    int fenmu = nums[1] * nums[3] * nums[5];
                    int fenzi = nums[0] * nums[3]*nums[5] + nums[2] * nums[1] * nums[5] + nums[4]*nums[1]*nums[3];
                    int maxgcd = gcd(fenzi, fenmu);
                    System.out.println(fenzi/maxgcd + "/" + fenmu / maxgcd);
                }else if(opt[0] == '-' && opt[1] == '-'){
                    int fenmu = nums[1] * nums[3] * nums[5];
                    int fenzi = nums[0] * nums[3]*nums[5] - nums[2] * nums[1] * nums[5] - nums[4]*nums[1]*nums[3];
                    if(fenzi == 0){
                        System.out.println(0);
                        return;
                    }
                    int maxgcd = gcd(Math.abs(fenzi), fenmu);
                    if(fenzi < 0){
                        System.out.println("-"+fenzi/maxgcd + "/" + fenmu/ maxgcd);
                    }else{
                        System.out.println(+fenzi/maxgcd + "/" + fenmu/ maxgcd);
                    }
                }else if(opt[0] == '-' && opt[1] == '+'){
                    int fenmu = nums[1] * nums[3] * nums[5];
                    int fenzi = nums[0] * nums[3]*nums[5] - nums[2] * nums[1] * nums[5] + nums[4]*nums[1]*nums[3];
                    if(fenzi == 0){
                        System.out.println(0);
                        return;
                    }
                    int maxgcd = gcd(Math.abs(fenzi), fenmu);
                    if(fenzi < 0){
                        System.out.println("-"+fenzi/maxgcd + "/" + fenmu/ maxgcd);
                    }else{
                        System.out.println(+fenzi/maxgcd + "/" + fenmu/ maxgcd);
                    }
                }else{
                    int fenmu = nums[1] * nums[3] * nums[5];
                    int fenzi = nums[0] * nums[3]*nums[5] + nums[2] * nums[1] * nums[5] - nums[4]*nums[1]*nums[3];
                    if(fenzi == 0){
                        System.out.println(0);
                        return;
                    }
                    int maxgcd = gcd(Math.abs(fenzi), fenmu);
                    if(fenzi < 0){
                        System.out.println("-"+fenzi/maxgcd + "/" + fenmu/ maxgcd);
                    }else{
                        System.out.println(+fenzi/maxgcd + "/" + fenmu/ maxgcd);
                    }
                }
            }
    }

    private static int gcd(int m, int n){
        while (m != n) {
            if (m > n)
                m -= n;
            else
                n -= m;
        }
        return m;
    }

    private static int helper(int p, int q, char c){
        int ans  = -1;
        switch (c){
            case '+':
                ans = p + q;
                break;
            case '-':
                ans = p - q;
                break;
        }
        return ans;
    }

    private static int check(char c){
        int a = -1;
        switch (c){
            case '+':
            case '-':
                a = 1;
                break;
            case '/':
                a = 2;
        }
        return a;
    }
}
