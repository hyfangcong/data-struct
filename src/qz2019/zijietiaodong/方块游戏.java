package qz2019.zijietiaodong;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/9/8
 */
public class 方块游戏 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int q = scanner.nextInt();
        String[] ss = new String[n+1];
        for(int i = 1 ; i <= n;  i++){
            ss[i] = scanner.next();
        }
        for(int i = 0; i < q;  i++){
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            String[] tmp = new String[n+1];
            System.arraycopy(ss,0, tmp, 0, ss.length);
            System.out.println(f(tmp, l, r));
        }
    }

    private static int f(String[] ss, int l, int r){
        int n = ss.length;
        boolean[] destoryed = new boolean[n+1];
        int direction = 1;
        int score = 0;
        String pre = "";
        int preIndex = -1;
        for(int i = l; i <= r; ){
            if(i < l || i > r){
                break;
            }
            if("<".equals(ss[i])){
                direction = -1;
                if(pre.equals("<") || pre.equals(">")){
                    destoryed[preIndex] = true;
                }
                pre = "<";
                preIndex = i;
            }else if(">".equals(ss[i])){
                direction = 1;
                if(pre.equals("<") || pre.equals(">")){
                    destoryed[preIndex] = true;
                }
                pre = ">";
                preIndex = i;
            }else{
                pre = "";
                int num = Integer.valueOf(ss[i]);
                if(num == 0){
                    destoryed[i] = true;
                }else{
                    score += num;
                    ss[i] = num-1 + "";
                }
            }
            i+=direction;
            while(i>= l && i <= r && destoryed[i]){
                i += direction;
            }
        }
        return score;
    }
}
