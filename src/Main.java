import java.util.ArrayList;
import java.util.List;

/**
 * @author: fangcong
 * @date: 2019/8/27
 */

public class Main {
    public static void main(String[] args) {
        List<String>[] ss = new ArrayList[2];
        List<String> ls = new ArrayList<String>();
        List<Integer> li = new ArrayList<Integer>();
        System.out.println(ls.getClass() == li.getClass());
        Singleton singleton = Singleton.getInstance();
    }
}