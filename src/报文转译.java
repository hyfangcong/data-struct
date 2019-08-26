import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/21
 */
public class 报文转译 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split(" ");
        int n = Integer.valueOf(arr[0]);
        ArrayList<String> res = new ArrayList<>();
        for(int i = 1; i < arr.length; i ++){
            if(arr[i].equals("A")){
                res.add("12");
                res.add("34");
            }else if(arr[i].equals("B")){
                res.add("AB");
                res.add("CD");
            }else{
                res.add(arr[i]);
            }
        }

        System.out.print(res.size() + 1 + " ");
        for(String s : res){
            System.out.print(s+" ");
        }
    }
}
