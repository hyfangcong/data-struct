import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class TTTT {
    String value;


    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int[] arr = {};
        arr = nums;
        System.out.println(arr.length);
        System.out.println(arr == nums);

        Vector<Integer> v1 = new Vector<>();
        Vector<Integer> v2 = new Vector<>();
        v1.add(4);
        v1.add(6);
        v2.add(5);
        Vector<Integer> v = v1.equals(v2) ? v1 : v2;
        System.out.println(v.get(0));
    }
}
