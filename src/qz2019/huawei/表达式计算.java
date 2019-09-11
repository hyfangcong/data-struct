package qz2019.huawei;

import java.util.*;

/**
 * @author: fangcong
 * @date: 2019/9/7
 */
public class 表达式计算 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr  = scanner.next().split(";|,");
        Map<String, List<String>[]> map = new HashMap<>();
        for(int i = 0; i < arr.length; i ++){
            String s = arr[i];
            String[] tmp = s.split("=|\\+|-|\\*|/");
            String[] tt = new String[tmp.length-1];
            System.arraycopy(tmp,1,tt, 0, tt.length);
            List<String> opr = new ArrayList<>(Arrays.asList(tt));
            List<String> opt = new ArrayList<>();
            for(int j = 0; j < s.length(); j++){
                if(s.charAt(j) == '+' || s.charAt(j) == '-'
                || s.charAt(j) == '*' || s.charAt(j) == '/'){
                    opt.add(s.charAt(j)+"");
                }
            }
            List<String>[] value = new ArrayList[2];
            value[0] = opr;
            value[1] = opt;
            map.put(tmp[0], value);
        }

        Map<String, Integer> ans = new HashMap<>();
        int total = map.size();
        while(total > 0){
            for(Map.Entry<String, List<String>[]> entry : map.entrySet()){
                if(!ans.containsKey(entry.getKey())){
                    List<String>[] value = entry.getValue();
                    if(value[0].size() == 1){
                        ans.put(entry.getKey(), Integer.valueOf(value[0].get(0)));
                        total--;
                    }else{
                        List<String> opr = value[0];
                        List<String> opt = value[1];
                        int[] a = new int[opr.size()];
                        boolean can = true;
                        for(int i = 0; i < a.length; i ++){
                            String tmp = opr.get(i);
                            if(tmp.charAt(0) == '{'){
                                a[i] = Integer.valueOf(tmp.substring(1,tmp.length()-1));
                            }else{
                                if(ans.containsKey(tmp)){
                                    a[i] = ans.get(tmp);
                                }else{
                                    can = false;
                                    break;
                                }
                            }
                        }
                        if(can){
                            int res = f(a, opt);
                        }
                    }
                }
            }
        }
    }

    private static int f(int[] opr, List<String> opt){
        Stack<Integer> s1 = new Stack<>();
        Stack<String> s2 = new Stack<>();
        for(int i = 0; i < opt.size(); i ++){
            if(s2.isEmpty() || getLevel(opt.get(i)) > getLevel(s2.peek())){
                s2.push(opt.get(i));
            }else{
                String op = s2.pop();
//                int second =
            }
        }
        return 0;
    }


    private static int calculate(String op, int first, int second) {
        switch (op){
            case "+":
                return first + second;
            case "-":
                return first - second;
            case "*":
                return first * second;
            case "/":
                return first / second;
            default:
                return 0;
        }
    }

    private static int getLevel(String c){
        switch (c){
            case "*":
            case "/":
                return '2';
            case "+":
            case "-":
                return '1';
            case "(":
                return 0;
            case"#":
                return -1;
            default:
                return -1;
        }
    }
}
