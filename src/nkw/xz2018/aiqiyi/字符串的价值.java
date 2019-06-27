package nkw.xz2018.aiqiyi;

import data_struct.array.Array;

import java.util.*;

/**
 * @author: fangcong
 * @date: 2019/6/27
 */
public class 字符串的价值 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int k = scanner.nextInt();
        if(k >= s.length()){
            System.out.println(0);
            return;
        }
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i ++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int n = map.size();
        int[] arr = new int[n];
        int index = 0;
        Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            arr[index++] = iterator.next().getValue();
        }
        Arrays.sort(arr);
        for(int i = 0; i < k; i ++){
            Arrays.sort(arr);
            arr[n - 1] -= 1;
        }
        int result = 0;
        for(int i = 0; i < n; i ++){
            result += arr[i] * arr[i];
        }
        System.out.println(result);
    }
}
