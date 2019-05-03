import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class TTTT {
    String value;


    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap();
        map.put(null, null);
        map.putIfAbsent(null, "fff");
        map.putIfAbsent(null,"ddd");
        map.put(null, "rrrr");


        Set<String> set = new HashSet<>();
        set.add(null);
        System.out.println(set.iterator().next());


        //二分搜索树中的元素才是有序的


        ConcurrentHashMap<String, String> cor = new ConcurrentHashMap<>();
        cor.put(null,null);
        System.out.println(cor.get(null));
        System.out.println(map.get(null));
    }
}
