package bcz2019.tenxun2019;

import java.util.Scanner;

public class 奇妙的数列 {
    private void init(){
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        int res = 0;
        for(int i = 0 ; i < q ; i ++){
            int left = scanner.nextInt() - 1;
            int right = scanner.nextInt();

            if(right % 2 == 0 && left % 2 == 0){
                res = right/2 - left/2;
            }else if(right % 2 == 0 && left % 2 != 0){
                res =  right/2 + (left/2 + 1);
            }else if(right % 2 != 0 && left % 2 == 0){
                res = -(right /2 + 1) - left / 2;
            }else
                res = -(right / 2 + 1) + (left / 2 +1);

            System.out.println(res);
        }
    }

    public static void main(String[] args) {
        (new 奇妙的数列()).init();
    }
}
