package qz2019.aiqiyi;

        import java.util.HashMap;
        import java.util.Map;
        import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/9/8
 */
public class 红篮球 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        float ans = f(n, m);
        System.out.printf("%.5f", ans);
    }
    static Map<String, Float> map = new HashMap<>();
    public static float f(float n, float m){
        String key = n+"#"+m;
        if(map.containsKey(key)){
            return map.get(key);
        }
        if(n == 0) return 0;
        if(m == 0) return 1;
        float p1 = n / (n+m);
        if(m == 1)
            return p1;
        if(m > 2){
            p1 += m/(m+n) * (m-1) / (m+n-1) * (m-2)/(m+n-2) * f(n, m-3);

            p1 += m/(m+n) * (m-1)/(m+n-1) * n/(m+n-2) * f(n-1, m-2);
        }else{
            p1 += m/(m+n) * (m-1)/(m+n-1) * n/(m+n-2) * f(n-1, m-2);
        }

        map.put(key,p1);
        return p1;
    }
}
