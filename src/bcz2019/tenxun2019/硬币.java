package bcz2019.tenxun2019;

import java.util.Scanner;

public class 硬币{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int coin = scanner.nextInt();
        int money = scanner.nextInt();
        int sum = money / coin + 1;
        System.out.println(sum);

    }
}
