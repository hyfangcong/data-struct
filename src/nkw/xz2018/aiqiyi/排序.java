package nkw.xz2018.aiqiyi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/6/27
 */
public class 排序 {
//    static class TreeNode{
//        int index;
//        int value;
//
//        public TreeNode(int index, int value){
//            this.index = index;
//            this.value = value;
//        }
//    }
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        TreeNode[] arr = new TreeNode[n];
//        for(int i = 0; i < n ; i ++){
//            arr[i] = new TreeNode(i, scanner.nextInt());
//        }
//
//        /**
//         * sort使用的快速排序，快速排序是非稳定的排序
//         * 因此不能用于用于比较索引
//         */
//       Arrays.sort(arr, new Comparator<TreeNode>() {
//           @Override
//           public int compare(TreeNode o1, TreeNode o2) {
//               return o1.value - o2.value;
//           }
//       });
//
//
//
//        int sum = 0;
//        for(int i = 0; i < n ; i ++){
//            if(arr[i].index != i)
//                sum++;
//        }
//        System.out.println(sum);
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] arrSorted = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            int cur = sc.nextInt();
            arr[i] = cur;
            arrSorted[i] = cur;
        }
        Arrays.sort(arrSorted);
        for (int i = 0; i < n; i++) {
            if (arr[i] != arrSorted[i]) {
                count++;
            }
        }
        System.out.println(count);
    }
}
