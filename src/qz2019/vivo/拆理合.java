package qz2019.vivo;

/**
 * @author: fangcong
 * @date: 2019/9/11
 */
public class 拆理合 {
    public static void main(String[] args) {

    }

    private static int solution(String str){
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int i = 0;  i< str.length(); i ++){
            if(str.charAt(i) == '0')
                break;
            if(str.charAt(i) == '(')
                sum++;
            else if(str.charAt(i) == ')')
                sum--;
        }
        return sum;
    }
}
