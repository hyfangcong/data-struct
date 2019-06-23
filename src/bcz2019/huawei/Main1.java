package bcz2019.huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                int n = scanner.nextInt();
                String[] arr = new String[n];
                for(int i = 0 ; i < n ; i ++){
                    arr[i] = scanner.next();
                }

                List<String> ss = new ArrayList<>();
                for(int i = 0; i < n; i ++){
                    int j = 0;
                    for( ; (j + 1 ) * 8 < arr[i].length(); j ++ ){
                        String s = arr[i].substring(j * 8, (j +1) * 8);
                        ss.add(s);
                    }

            int k = 8 - (arr[i].length() - j * 8);
            if(k != 8){
                String s = arr[i].substring(j * 8, arr[i].length());
                while( k-- > 0){
                    s += "0";
                }
                ss.add(s);
            }
        }

        Collections.sort(ss);
        for(int i = 0 ; i < ss.size() ; i++){
            System.out.print(ss.get(i) + " ");
        }
    }
}
