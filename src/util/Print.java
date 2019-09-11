package util;

/**
 * @author: fangcong
 * @date: 2019/9/10
 */
public class Print {
    private int i = -1;
    //flag=true even      flag=false odd
    private boolean flag = true;

    public synchronized void printOdd() throws InterruptedException {
        if(flag){
            wait();
        }else {
            i+=1;
            System.out.println(Thread.currentThread().getName()+":"+i);
            flag = true;
            notify();
        }
    }

    public synchronized void printEven() throws InterruptedException {
        if(!flag){
            wait();
        }else{
            i+=1;
            System.out.println(Thread.currentThread().getName()+":" + i);
            flag=false;
            notify();
        }
    }
}
