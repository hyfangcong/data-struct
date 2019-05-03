package leetcode.leetcode2018.math;

import java.util.Map;
import java.util.TreeMap;

public class 直线上最多的点数 {
   static class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    public static void main(String[] args) {
        Point[] points = new Point[]{new Point(0,0), new Point(1,65536), new Point(65536, 0)};
        System.out.println(maxPoints(points));
    }

//    private static Point[] quchong(Point[] points){
//        Map<String, Point> map = new TreeMap<>();
//        for(int i = 0 ; i < points.length ; i++){
//            String k = points[i] + "," + points[i];
//            map.put(k, points[i]);
//        }
//        Point[] newPoints = new Point[map.size()];
//        int i = 0;
//        for(String key : map.keySet()){
//            newPoints[i] = map.get(key);
//            i++;
//        }
//        return newPoints;
//    }
    public static int maxPoints(Point[] points) {
        if(points.length <= 2)
            return points.length;

        int subMax = Integer.MIN_VALUE;
        for(int i = 0 ; i < points.length - 1; i ++){
            for(int j = i + 1; j < points.length ; j++){
                int temp = 0;
                //处理重复点
                if(points[i].x == points[j].x && points[i].y == points[j].y){
                    for(int k = 0 ; k < points.length ; k ++){
                        if(k != i && k != j && points[k].x == points[i].x && points[k].y == points[i].y){
                            temp++;
                        }
                    }
                }else{
                    for(int k = 0; k < points.length; k ++){
                        if(k != i && k != j){

                            //处理重复点
                            if((points[k].x == points[i].x && points[k].y == points[i].y) ||
                                    (points[k].x == points[j].x && points[k].y == points[j].y)){
                                temp++;
                            }else{
                                long k1 = ((long)points[i].y - points[j].y) * (points[k].x - points[i].x);
                                long k2 = ((long)points[k].y - points[i].y) * (points[i].x - points[j].x);
                                if(k1 == k2)
                                    temp++;
                            }
                        }
                    }
                }
                subMax = Math.max(subMax, temp);
            }
        }
        return subMax + 2;
    }
}
