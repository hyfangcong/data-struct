package bytedance2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while(true){
            String s = scanner.nextLine();
            if(s.length() == 0)
                break;
            list.add(s);
        }
        String[] ss = list.get(0).split(" ");
        int row = list.size();
        int col = ss.length;
        String[][] arr = new String[row][col];
        for(int i = 0; i < row ; i ++){
            String[] tt = list.get(i).split(" ");
            for(int j = 0 ; j < tt.length; j ++){
                arr[i][j] = tt[j];
            }
        }

        int count = 0;
        for(int i = 0 ; i < arr.length; i ++){
            for(int j = 0; j < arr[0].length; j ++){
                boolean flag = false;
                if(arr[i][j].equals("2")){
                    if(i - 1 >= 0 && arr[i - 1][j].equals("1")){
                        arr[i - 1][j] = "2";
                        flag = true;
                    }

                    if(i + 1 < arr.length && arr[i + 1][j].equals("1")){
                        arr[i + 1][j] = "2";
                        flag = true;
                    }

                    if(j - 1 >= 0 && arr[i][j - 1].equals("1")){
                        arr[i][j - 1] = "2";
                        flag = true;
                    }

                    if(j + 1 < arr[0].length && arr[i][j + 1].equals("1")){
                        arr[i][j + 1] = "2";
                        flag = true;
                    }

                    if(flag)
                        count++;
                }
            }
        }

        for(int i = 0 ; i < arr.length; i ++){
            for(int j = 0 ; j < arr[0].length ; j ++){
                if(arr[i][j].equals("1")){
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(count);

    }
}
