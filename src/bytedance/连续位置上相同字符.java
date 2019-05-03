package bytedance;

import java.util.*;

public class 连续位置上相同字符 {
    private static Map<Character,List<Integer>> map;
    private static int step;

    public static void main(String[] args) {
        init();
        process();
    }

    private static void init(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        step = scanner.nextInt();

        map = new HashMap<>();
        for(int i = 0; i < str.length(); i ++){
            if(!map.containsKey(str.charAt(i))){
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(str.charAt(i), list);
            }else{
                List<Integer> list = map.get(str.charAt(i));
                list.add(i);
                map.put(str.charAt(i), list);
            }
        }
    }

    private static void process(){
        List<Integer> len = new ArrayList<>(0);
        for(Map.Entry<Character,List<Integer>>entry : map.entrySet()){
            List<Integer> list = entry.getValue();
            int left = 0, right = list.size() - 1;
            boolean isContent = false;
            while(left < right){
                int t  = list.get(right) - list.get(left) - (right - left);
                if(t <= step){
                    len.add(right - left + 1);
                    isContent = true;
                    break;
                }
                if(left + 1 < right){
                    t = list.get(right) - list.get(left + 1) - (right - left - 1);
                    if(t <= step){
                        len.add(right - left);
                        isContent = true;
                        break;
                    }
                    t = list.get(right - 1) - list.get(left) - (right - left - 1);
                    if(t <= step){
                        len.add(right - left);
                        isContent = true;
                        break;
                    }
                }
                left++;
                right--;
            }
            if (!isContent){
                len.add(1);
            }
        }

        int max = len.get(0);
        for(int i = 1; i < len.size(); i++){
            if(len.get(i) > max)
                max = len.get(i);
        }
        System.out.println(max);
    }
}
