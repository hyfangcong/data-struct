package nkw.jzof;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author: fangcong
 * @date: 2019/6/24
 */
public class 数据流中的中位数 {
    ArrayList<Integer> list = new ArrayList<>();
    public void Insert(Integer num) {
        list.add(num);
    }


    public Double GetMedian() {
        Collections.sort(list);
        if(list.size() % 2 == 0){
            return (list.get(list.size() / 2) + list.get(list.size() / 2 - 1))/ 2.0;
        }else{
            return (double)list.get(list.size() / 2);
        }
    }
}
