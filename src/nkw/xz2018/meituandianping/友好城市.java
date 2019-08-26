package nkw.xz2018.meituandianping;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/16
 */
public class 友好城市{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] graph = new int[n+1][n+1];
        for(int i = 1; i <= n ; i++){
            for(int j = 1; j <= n; j ++){
                graph[i][j] = scanner.nextInt();
            }
        }

        int k = scanner.nextInt();
        int[] cities = new int[k*2];
        for(int i = 0 ; i < k*2; i++){
            cities[i] = scanner.nextInt();
        }

        floyd(graph, n);
        dfs(graph, cities, 0, k, 0);
        System.out.println(res);
    }

    static int res = Integer.MAX_VALUE;
    public static void floyd(int[][] graph, int n){
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(graph[i][k] != -1 && graph[k][j] != -1
                            && (graph[i][j] == -1 || graph[i][j] > graph[i][k] + graph[k][j])){
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }
    }

    /**
     * 回溯法：
     * 1.基本思想：在包含问题的所有解的解空间树中，按照深度优先搜索的策略，从根节点出发深度探索解空间树，
     *            当探索到某一点时，判断该节点是否包含问题的解，如果包含则从该节点继续探索下去，否则，则其逐层
     *            向其祖先节点回溯。
     *
     * 2.使用回溯法的一般步骤
     *      1）针对所给问题，确定问题的解空间
     *      2）确定节点的扩展搜索规则
     *      3）以深度优先的策略探索解空间，并在搜索过程中用减枝函数避免无效搜索
     *
     * @param graph
     * @param cities
     * @param index
     * @param k
     * @param dist
     */
    public static void dfs(int[][] graph, int[] cities, int index, int k, int dist){
        if(index == 2*k){
            res = Math.min(res, dist);
            return;
        }
        for(int i = index+1; i < 2*k; i ++){
            /**
             * 占用资源
             */
            //swap(index+1, i)
            int tmp = cities[index+1];
            cities[index+1] = cities[i];
            cities[i] = tmp;
            if(graph[cities[index]][cities[index+1]] != -1){
                dfs(graph, cities, index+2, k, dist+graph[cities[index]][cities[index+1]]);
            }
            /**
             * 释放资源
             */
            tmp = cities[index+1];
            cities[index+1] = cities[i];
            cities[i] = tmp;
        }
    }
}