package nkw.xz2018.pinduoduo;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/26
 */
public class 回合制游戏 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hp = sc.nextInt();
        int nomalAttack = sc.nextInt();
        int bufferAttack = sc.nextInt();
        if(bufferAttack <= nomalAttack*2){
            System.out.println(hp/nomalAttack + (hp/nomalAttack == 0 ? 0 : 1));
        }else{
            int tmp = hp;
            int sum = 0;
            while(tmp > nomalAttack){
                tmp -= bufferAttack;
                sum+=2;
            }
            sum += tmp > 0 ? 1 : 0;
            System.out.println(sum);
        }
    }
}
