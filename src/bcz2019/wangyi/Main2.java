package bcz2019.wangyi;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String[] arr = s.split(",");
        char[] aarr = arr[0].toCharArray();
        char[] barr = arr[1].toCharArray();

        fun(aarr, barr, 0, 0);
        System.out.println(sum);

    }


    static int sum = Integer.MAX_VALUE;
    public static void fun(char[] a, char[] b, int index, int num){

        boolean flag = false;

        if(index == a.length ){
            sum = Math.min(sum, num);
        }else{
            int x = Math.abs(a[index] - b[index]);

            if(x == 0){
                num++;
                 fun(a, b, ++index, num);
            }else if(x == 1){

                num++;

                fun(a, b, ++index,num);

                for(int i = index + 1; i < a.length; i ++){
                    if(a[i] == b[index]){
                        a[i] = a[index];
                        a[index] = b[index];
                        flag = true;
                    }
                }

                if(flag){
                     fun(a, b, ++index, num);

                }


            }else {
                for(int i = index + 1; i < a.length; i ++){
                    if(a[i] == b[index]){
                        a[i] = a[index];
                        a[index] = b[index];
                        flag = true;
                    }
                }

                if(flag){
                    num++;
                }else{
                    num += 2;
                }
               fun(a,b ,++index,num);
            }
        }
    }
}
