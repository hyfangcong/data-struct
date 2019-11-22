package qz2019.vipket;

import java.util.*;

/**
 * @author: fangcong
 * @date: 2019/9/16
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> list = getPrimes(n);
        list.remove(0);
        Map<Integer,List<String>> map = new TreeMap<>();
        for(int i = 0; i < list.size(); i++){
            for(int j = 0; j <= i; j++){
                int sum = list.get(j) + list.get(i);
                if(sum <= n){
                    String s = sum+"="+list.get(j)+"+"+list.get(i);
                    List<String> value;
                    if(!map.containsKey(sum)){
                        value = new ArrayList<>();
                    }else{
                        value = map.get(sum);
                    }
                    value.add(s);
                    map.put(sum, value);
                }
            }
        }
        Iterator<List<String>> iterator = map.values().iterator();
        while (iterator.hasNext()){
            List<String> tmp = iterator.next();
            Collections.sort(tmp);
            for(String s : tmp){
                System.out.println(s);
            }
        }
    }

    private static List<Integer> getPrimes(int n) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(2);

        for (int i = 3; i <= n; i += 2) {
            if (!help(i, result)) {
                result.add(i);
            }
        }
        return result;
    }

    private static boolean help(int n, List<Integer> primes) {
        for (Integer prime : primes) {
            if (n % prime == 0) {
                return true;
            }
        }
        return false;
    }
}
