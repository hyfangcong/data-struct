package util;

/**
 * @author: fangcong
 * @date: 2019/9/11
 */
public class FinalTest {
    public static void main(String[] args) {
        System.out.println(f());
    }

    public static int f(){
        int a = 10;
        try {
            int b = a/0;
            return a;
        }catch (Exception e){
            a = 30;
            return a;
        }finally {
            a = 20;
            return a;
        }
    }
}
