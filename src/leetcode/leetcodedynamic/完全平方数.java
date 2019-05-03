package leetcode.leetcodedynamic;

public class 完全平方数 {
    private static int[] memo;
    private static int tryNumSquares(int n) {
        if (n == 0)
            return 0;

        if(memo[n] != 0)
            return memo[n];
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= Math.sqrt(n); i ++){
            min = Math.min(tryNumSquares(n - i * i), min);
        }
        memo[n] = min + 1;
        return memo[n];
    }

    public static int numSquares(int n){
        memo = new int[n + 1];
        return tryNumSquares(n);
    }

    public static int numSquares2(int n){
        int[] memory = new int[n + 1];
        memory[1] = 1;
        for(int i = 1; i <= n ; i ++){
            int min = Integer.MAX_VALUE;
            for(int j = 1 ; j * j <= i; j++){
                min = Math.min(min, memory[i - j * j]);
            }
            memory[i] = min + 1;
        }
        return memory[n];
    }

    public static void main(String[] args) {
//        System.out.println(numSquares2(12));
        System.out.println(Long.MAX_VALUE);
    }
}
