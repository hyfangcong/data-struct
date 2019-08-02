package nkw.zsjinjie.util;

import java.util.*;

/**
 * @author: fangcong
 * @date: 2019/8/2
 */
public class 天际线问题 {
    static class Node{
        int pos;
        int h;
        public Node(int pos, int h){
            this.pos=pos;
            this.h=h;
        }
    }

    public static void main(String[] args) {
        int[][] buildings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        int[][] buildings2 = {{0,2,3},{2,5,3}};
        List<List<Integer>> res = getSkyline(buildings);
        for(List<Integer> item : res){
            System.out.print("[" + item.get(0) + "," + item.get(1) + "]");
        }
    }
    public static List<List<Integer>> getSkyline(int[][] buildings) {
        Node[] all = new Node[buildings.length*2];
        TreeMap<Integer,Integer> hMap = new TreeMap<>();
        Integer[] last = new Integer[2];
        Arrays.fill(last, 0);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0 ; i < buildings.length; i ++){
            all[2*i] = new Node(buildings[i][0], -buildings[i][2]);
            all[2*i+1] = new Node(buildings[i][1], buildings[i][2]);
        }
        Arrays.sort(all, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.pos != o2.pos){
                    return o1.pos-o2.pos;
                }
                return o1.h - o2.h;
            }
        });

        for(int i = 0 ; i < all.length; i ++){
            if(all[i].h < 0){
                hMap.put(-all[i].h, hMap.getOrDefault(-all[i].h, 0)+1);
            }else{
                if(hMap.get(all[i].h) == 1){
                    hMap.remove(all[i].h);
                }else{
                    hMap.put(all[i].h, hMap.get(all[i].h) - 1);
                }
            }
            //当前位置的最大高度
            int maxHeight = hMap.isEmpty() ? 0 : hMap.lastKey();

            //当前高度不同于上一个高度，说明是一个转折点
            if(maxHeight != last[1]){
                //更新最大高度并加入结果集
                last[0] = all[i].pos;
                last[1] = maxHeight;
                ArrayList<Integer> list = new ArrayList<>();
                list.add(last[0]);
                list.add(last[1]);
                res.add(list);
            }
        }
        return res;
    }
}
