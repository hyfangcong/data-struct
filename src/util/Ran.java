package util;

import java.util.Random;

/**
 * @author: fangcong
 * @date: 2019/9/13
 */
public class Ran {
    public static void main(String[] args) {
        Random random = new Random();
        for(int i = 0; i < 30; i ++){
            System.out.println(random.nextInt(1000));
        }
    }
}
