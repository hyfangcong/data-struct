package leetcode;

import java.util.*;

public class 三数之和 {
    /**
     *
     * 时间超时
     */
//    private static Map<String,List<Integer>> towSum(int[] nums, int index, int target){
//        Map<String, List<Integer>> res = new HashMap<>();
//        Set<Integer> set = new HashSet<>();
//        for(int i = index; i < nums.length; i++){
//            int find = - (target + nums[i]);
//            if(set.contains(find)){
//                List<Integer> list = new ArrayList<>(Arrays.asList(target, nums[i], find));
//                Collections.sort(list);
//                res.putIfAbsent(list.toString(), list);
//            }
//            set.add(nums[i]);
//        }
//        return res;
//    }
//
//    public static List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        Map<String, List<Integer>> filter = new HashMap<>();
//       Arrays.sort(nums);
//        for(int i = 0 ; i < nums.length; i++)
//            filter.putAll(towSum(nums, i + 1, nums[i]));
//
//        for(Map.Entry<String, List<Integer>> entry : filter.entrySet())
//            res.add(entry.getValue());
//        return res;
//    }


    //控制循环变量
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1, k = nums.length - 1; j < k;) {
                int temp_sum = nums[j] + nums[k];
                if (temp_sum + nums[i] < 0) {
                    j++;
                } else if (temp_sum + nums[i] > 0)
                    k--;
                else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    //去重
                    while(j + 1 < k && nums[j] == nums[j + 1]){
                        j++;
                    }
                    j++;

                    //去重
                    while (k - 1 > j && nums[k] == nums[k - 1])
                        k--;
                    k--;
                }
                //去重
                while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
        return res;
    }

    //题目中要求找到所有符合条件的且不重复的三元组，如果使用查找表，查找表中要存放：key：a+b， value：arr,(arr[0]=a,arr[1]=b)
    //并且还要对arr进行去重操作。找到对应的key后还要遍历value。
    //如果只是判断存在，可以用查找表。
    private static List<List<Integer>>threeSum2(int[] nums){
        return new ArrayList<>();
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,-1,-1,0};
        List<List<Integer>> res = threeSum(nums);
        for(int i =0 ; i < res.size(); i ++){
            List<Integer> list = res.get(i);
            for(Integer item : list)
                System.out.print(item);
            System.out.println();

        }
    }
}
