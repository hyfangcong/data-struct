package util;

/**
 * @author: fangcong
 * @date: 2019/9/10
 */
public class Test {
    public static void main(String[] args) {
        Print print = new Print();
        Thread odd = new OddThread(print,10);
        Thread even = new EvenThread(print, 10);
        odd.start();
        even.start();
    }



    

    static class OddThread extends Thread{
        private Print print;
        private int n;
        public OddThread(Print print, int n){
            this.print = print;
            this.n = n;
        }

        @Override
        public void run(){
            for(int i = 0; i < n;  i++){
                try {
                    print.printOdd();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class EvenThread extends Thread{
        private Print print;
        private int n;
        public EvenThread(Print print, int n){
            this.print = print;
            this.n = n;
        }

        @Override
        public void run(){
            for(int i = 0; i < n;  i++){
                try{
                    print.printEven();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }


}
