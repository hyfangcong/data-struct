package tenxun2;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();

        char[] arr = s.toCharArray();

        boolean flag = false;
        while(!flag){
            boolean temp = false;
            for(int i = 0 ; i < arr.length ; ){
                while(i < arr.length && arr[i] == '9')
                    i++;
                int preIndex = i;
                i++;
                while(i < arr.length && arr[i] == '9')
                    i++;

                int posIndex = i;

                if(preIndex < arr.length && posIndex < arr.length){
                    if(arr[preIndex] + arr[posIndex] == 97){
                        arr[preIndex] = '9';
                        arr[posIndex] = '9';
                        temp = true;
                    }
                }

            }
            if(!temp)
                flag = true;
        }

        int sum = 0;
        for(int i = 0 ; i < arr.length ; i ++){
            if(arr[i] != '9')
                sum++;
        }

        System.out.println(sum);
    }
}
