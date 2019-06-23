import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class TTTT {
    public static void main(String[] args) {
        String str =
                "q,e#r\\p";
        String[] arr = str.split("#|,");
        System.out.println(arr[0]);
        System.out.print(str.split("\\*").length);
    }
}
