package bytedance;

import java.util.*;

public class 珠串 {
    private static Map<Integer,List<Integer>> map;
    private static int num;
    private static int step;

    public static void main(String[] args){
        init();
        process();
    }

    private static void init(){
        Scanner scanner = new Scanner(System.in);
        map = new HashMap<>();
        num = scanner.nextInt();
        step = scanner.nextInt();
        int color = scanner.nextInt();
        for(int i = 0; i < num; i ++){
            int n = scanner.nextInt();
            for(int j = 0; j < n; j++){
                int k = scanner.nextInt();
                if(!map.containsKey(k)){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(k, list);
                }else{
                    List<Integer> list = map.get(k);
                    list.add(i);
                    map.put(k,list);
                }
            }
        }
    }

    private static void process(){
        int sum = 0;
        for(Map.Entry<Integer,List<Integer>> entry : map.entrySet()){
            List<Integer> list = entry.getValue();
            if(list != null && list.size() != 1){
                if((num + list.get(0) - list.get(list.size() - 1) < step)){
                    sum++;
                    continue;
                }

                for(int i = 0; i < list.size() - 1; i++){
                    if(list.get(i + 1) - list.get(i) < step){
                        sum++;
                        break;
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
