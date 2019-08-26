package nkw.xz2018.meituandianping;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/17
 */
public class 手机号 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        HashSet<String> chinaTelecom = new HashSet<>();
        HashSet<String> chinaUnicom = new HashSet<>();
        HashSet<String> chinaMobile = new HashSet<>();
        chinaTelecom.add("133");
        chinaTelecom.add("153");
        chinaTelecom.add("180");
        chinaTelecom.add("181");
        chinaTelecom.add("189");
        chinaUnicom.add("130");
        chinaUnicom.add("131");
        chinaUnicom.add("155");
        chinaUnicom.add("185");
        chinaUnicom.add("186");
        chinaMobile.add("135");
        chinaMobile.add("136");
        chinaMobile.add("150");
        chinaMobile.add("182");
        chinaMobile.add("188");
        for(int i = 0 ; i<t; i++){
            String tmp = scanner.next();
            if(tmp.length() == 11){
                String head = tmp.substring(0,3);
                if(chinaTelecom.contains(head)){
                    System.out.println("China Telecom");
                }else if(chinaUnicom.contains(head)){
                    System.out.println("China Unicom");
                }else if(chinaMobile.contains(head)){
                    System.out.println("China Mobile Communications");
                }else{
                    System.out.println("-1");
                }
            }else{
                System.out.println("-1");
            }
        }
    }
}
