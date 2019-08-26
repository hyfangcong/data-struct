package nkw.xz2018.meituandianping;

import java.util.*;

/**
 * @author: fangcong
 * @date: 2019/8/16
 */
public class 超链接 {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 0 ; i < n ; i++){
            set.add(scanner.next());
        }
        int m = scanner.nextInt();
        for(int i = 0 ; i < m; i ++){
            String s = scanner.next();
            if(set.contains(s)){
                set.remove(s);
            }
        }
        ArrayList<String> res = new ArrayList<>();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            res.add(iterator.next());
        }
        Collections.sort(res);
        iterator = res.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
