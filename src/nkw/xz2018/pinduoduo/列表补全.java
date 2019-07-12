package nkw.xz2018.pinduoduo;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/7/2
 */
public class 列表补全 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int offset = scanner.nextInt();
            int n = scanner.nextInt();
            int l1 = scanner.nextInt();
            int l2 = scanner.nextInt();
            int start1, start2, end1, end2;
            if(offset >= l1 + l2){
                start1 = l1;
                end1 = l1;
                start2 = l2;
                end2 = l2;
            }else if(offset >= l1){
                start1 = l1;
                end1 = l1;
                start2 = offset - l1;
                end2 = start2 + n >= l2 ? l2 : start2 + n;
            }else{
                start1 = offset;
                if(n >= l1 - offset){
                    end1 = l1;
                    start2 = 0;
                    end2 = n - (l1 - offset);
                }else{
                    end1 = offset + n;
                    start2 = 0;
                    end2 = 0;
                }
            }
            System.out.println(start1+" "+end1+" "+start2+" "+end2);
        }
    }
}
