package qz2019.pingduoduo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/9/1
 */
public class Main31 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i = 0; i < t; i ++){
            String a = scanner.next();
            String b = scanner.next();
            int n = a.length();
            LinkedList<Integer> queue = new LinkedList<>();
            ArrayList<Character> opt = new ArrayList<>();
            ArrayList<String> ans = new ArrayList<>();
            dfs(a,b, n, 0, queue, opt, ans);
            Collections.sort(ans);
            System.out.println('{');
            for(int k = 0 ; k < ans.size(); k ++){
                String tmp = ans.get(k);
                for(int j = 0; j < tmp.length(); j++){
                    if(j == tmp.length()-1){
                        System.out.println(tmp.charAt(j));
                    }else{
                        System.out.print(tmp.charAt(j)+" ");
                    }
                }
            }
            System.out.println('}');
        }
    }

    public static void dfs(String a, String b, int n, int index, LinkedList<Integer> queue, ArrayList<Character> opt,
                           ArrayList<String> ans){
        if(index == n){
            String tmp = "";
            for(int i = 0 ; i < queue.size(); i ++){
                tmp += queue.get(i);
            }
            if(tmp.equals(b)){
                String tt = "";
                for(int p = 0; p < opt.size(); p++){
                    tt+= opt.get(p);
                    if(tt.length() == n){
                        ans.add(tt);

                    }
                }
            }
            return;
        }

            //d
            opt.add('d');
            dfs(a, b, n, index+1, queue, opt, ans);
            opt.remove(opt.size()-1);

            //l
            queue.addFirst(Integer.valueOf(a.charAt(index)+""));
            opt.add('l');
            dfs(a,b,n,index+1, queue, opt, ans);
            queue.removeFirst();
            opt.remove(opt.size()-1);

            //r
            queue.addLast(Integer.valueOf(a.charAt(index)+""));
            opt.add('r');
            dfs(a, b, n, index+1, queue, opt, ans);
            queue.removeLast();
            opt.remove(opt.size()-1);
    }
}
