package qz2019.huawei;

import java.util.*;

/**
 * @author: fangcong
 * @date: 2019/9/4
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] arr = new String[n];
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLine();
        }
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            String[] tmp = arr[i].split("=|\\+| ");
            String key = tmp[0];
            List<String> value = new ArrayList<>();
            for (int j = 1; j < tmp.length; j++) {
                value.add(tmp[j]);
            }
            map.put(key, value);
        }

        String[] ans = arr[n - 1].replaceAll("\\d+", "").split("=|\\+| ");
    }
}
