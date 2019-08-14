import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/9
 */
public class Main22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int time = scanner.nextInt();
        for(int i = 0; i < time ; i ++){
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            char[][] matrix = new char[m][n];
            int ans = 0;
            for(int j = 0; j < m; j ++){
                matrix[j] = Arrays.copyOf(scanner.next().toCharArray(),n);
            }
            String target = scanner.next();
            for(int j = 0; j < m ; j ++){
                for(int k = 0; k < n; k++){
                    ans += isWord(matrix, j, k, target);
                }
            }
            System.out.println(ans);
        }
    }

    public static int isWord(char[][] matrix, int row, int col, String target){
        int m = matrix.length;
        int n = matrix[0].length;
        int index = 0;
        int ans = 0;
        int row1 = row, col1 = col;
        while(true){
            if(index == target.length()){
                ans++;
                break;
            }
            if(row1 + index < m && matrix[row1+index][col1] == target.charAt(index)){
                index++;
            }else{
                break;
            }
        }

        index = 0;
        row1 = row;
        col1 = col;
        while (true){
            if(index == target.length()){
                ans++;
                break;
            }
            if(col1+index < n && matrix[row1][col1+index] == target.charAt(index)){
                index++;
            }else
                break;
        }

        index = 0;
        row1 = row;
        col1 = col;
        while (true){
            if(index == target.length()){
                ans++;
                break;
            }
            if(row1+index < m && col1+index<n && matrix[row1+index][col1+index] == target.charAt(index)){
                index++;
            }else
                break;
        }
        return ans;
    }
}
