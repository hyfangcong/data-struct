package leetcode.leetcode2018.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class 两个数组的交集 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{ 1,2,2,1};
        int[] nums2 = new int[]{2,2};
        int[] res = (new 两个数组的交集()).intersect(nums1,nums2);
        for(int i = 0; i < res.length; i++){
            System.out.println(res[i]);
        }
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map1 = new TreeMap<>();
        Map<Integer,Integer> map2 = new TreeMap<>();
        for(int i = 0; i < nums1.length; i++){
            if(!map1.containsKey(nums1[i])){
                map1.put(nums1[i], 1);
            }else{
                map1.put(nums1[i],map1.get(nums1[i]) + 1);
            }
        }

        for(int i = 0; i < nums2.length; i++){
            if(!map2.containsKey(nums2[i])){
                map2.put(nums2[i], 1);
            }else{
                map2.put(nums2[i], map2.get(nums2[i]) + 1);
            }
        }

        List<Integer> res = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : map1.entrySet()){
            if(map2.containsKey(entry.getKey())){
                int temp = Math.min(entry.getValue(),map2.get(entry.getKey()));
                while(temp != 0){
                    res.add(entry.getKey());
                    temp--;
                }
            }
        }

        int[] ret = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            ret[i] = res.get(i);
        }
        return ret;
    }
}
