import java.lang.invoke.MethodType;
import java.lang.reflect.Method;

/**
 * @author: fangcong
 * @date: 2019/9/6
 */
public class OutClass {
    private String name = "out";
    class innerClass{
        private String name = "in";
        public void print(){
            String name = "in++";
            System.out.println("waibulei:" + OutClass.this.name);
        }
    }

    public static void main(String[] args) {
//        OutClass outClass = new OutClass();
//        outClass.new innerClass().print();
        String s = "aaaba";
        System.out.println(s.replace('a','b'));
        Method method;
    }
}
