package util;

/**
 * @author: fangcong
 * @date: 2019/9/16
 */
public class TT {
    public static void main(String[] args) {
        TT tt = new TT();
        System.out.println("和是：" + tt.add(9,34));
    }

    public int add(int a, int b){
        try{
            return a+b;
        }catch(Exception e){
            System.out.println("Catch语句块");
        }finally {
            System.out.println("finally语句块");
        }
        return 0;
    }
}
