import java.io.Serializable;

/**
 * @author: fangcong
 * @date: 2019/8/9
 */
public class A implements Serializable {
    String x;
    String y;
    public A(String x, String y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return "x = " + x + " y = " + y;
    }
}
