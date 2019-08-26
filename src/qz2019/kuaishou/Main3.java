package qz2019.kuaishou;

/**
 * @author: fangcong
 * @date: 2019/8/25
 */
import java.util.*;

public class Main3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        System.out.println(helper(str1, str2));
    }

    private static String helper(String str1, String str2) {
        String[] arr1 = str1.split(" ");
        String[] arr2 = str2.split(" ");
        ArrayList<String> res = new ArrayList<>();
        List<String> list1 = new ArrayList<String>(Arrays.asList(arr1));
        List<String> list2 = new ArrayList<String>(Arrays.asList(arr2));
        while(list1.size() > 3){
            Collections.addAll(res, list1.get(0), list1.get(1), list1.get(2), list1.get(3));
            list1 = list1.subList(4, list1.size());
            if(list2.size() > 0){
                Collections.addAll(res, list2.get(0));
                list2 = list2.subList(1, list2.size());
            }
        }

        for (int i = 0; i < list1.size(); i++) {
            Collections.addAll(res, list1.get(i));
        }

        for (int i = 0; i < list2.size(); i++) {
            Collections.addAll(res, list2.get(i));
        }
        StringBuilder sb = new StringBuilder();
        for (String re : res) {
            sb.append(re + " ");
        }
        return sb.toString();
    }
}