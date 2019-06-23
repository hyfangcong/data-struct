package nkw.jzof;

/**
 * @author: fangcong
 * @date: 2019/6/23
 */
public class 表示数值的字符串 {
    public static void main(String[] args) {
        System.out.println(isWord("aAdfdfgDFDFjfofjwoeifjwejgoeijLJFIOEJFOIEJFOWJFEODG"));
    }

    public static boolean isNumeric(char[] str){
        String string = String.valueOf(str);
        return string.matches("[\\+\\-]?\\d*(\\.\\d+)?([Ee][\\+\\-]?\\d+)?");
    }

    public static boolean isWord(String s){
        return s.matches("[a-zA-Z]+");
    }
}
