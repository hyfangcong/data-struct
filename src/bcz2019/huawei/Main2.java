package huawei;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        char[] chars = s.toCharArray();
        String res = fun(chars,0);
    }

    public static String fun(char[] arr, int index){
        String s = "";
        while(index < arr.length){
            if(arr[index] == ')' || arr[index] == ']' || arr[index] == '}') {
                return s;
            }

            if(index < arr.length && arr[index] >= '0' && arr[index] <= '9'){

                String num = "";
                while(index < arr.length && arr[index] >= '0' && arr[index] <= '9'){
                    num += arr[index++];
                }

                int k = Integer.parseInt(num);
                String temp = fun(arr, index);
                while(k > 0){
                    s += temp;
                    k--;
                }

                while(index < arr.length){
                    if(arr[index] == ')'){
                        break;
                    }else if(arr[index] == ']'){
                        break;
                    }else if(arr[index] == '}'){
                        break;
                    }
                    else{
                        index++;
                    }
                }
                index++;

    }else {
        if(arr[index] != '(' && arr[index] != '[' && arr[index] != '{'){
            s += arr[index];
        }
        index++;
    }
}

        return s;
    }
}
