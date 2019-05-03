package tenxun2019;

import java.util.*;

public class 气球游戏 {

    public static void main(String[] args) {
        (new 气球游戏()).init();
    }
    private void init(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int min = Integer.MAX_VALUE;
        Map<Integer,Integer> color = new HashMap<>();
        for(int i = 1 ; i <= n ; i ++){
            if(color.size() < m){
                color.put(scanner.nextInt(),i);
            }else{
                int temp = foundMin(color);
                if(temp < min)
                    min = temp;
                color.put(scanner.nextInt(),i);
            }
        }
        if(color.size() >= m){
            int temp = foundMin(color);
            if (temp < min)
                min = temp;
            System.out.println(min + 1);
        }else{
            System.out.println(-1);
        }
    }

    private int foundMin(Map<Integer,Integer> map){
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer>entry : map.entrySet()){
            list.add(entry.getValue());
        }
        Collections.sort(list);
        return list.get(list.size() - 1) - list.get(0);
    }
}
