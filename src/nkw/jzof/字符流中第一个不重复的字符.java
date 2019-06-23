package nkw.jzof;

import java.util.Arrays;

/**
 * @author: fangcong
 * @date: 2019/6/23
 */

/**
 * 字符的种类有限，可以用一个长度为256的数组，来表示所有的字符
 *
 * 用不同的值来表示字符是否重复出现和出现的先后次序
 *
 * arr[?] == -1 表示（char)?没有出现过
 * arr[?] == -2 表示 （char)?至少出现2次
 * arr[?] >= 0 表示（char）?出现过一次，并且该字符在字符流中的位置为arr[?]
 */
public class 字符流中第一个不重复的字符 {
   int[] arr = new int[256];
   int index;

   public 字符流中第一个不重复的字符(){
       Arrays.fill(arr, -1);
       index = 0;
   }

    public void Insert(char ch)
    {
        if(arr[ch] == -1)
            arr[ch] = index;
        else if(arr[ch] >= 0)
            arr[ch] = -2;
        index++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char ch = '\0';
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 256; i ++){
            if(arr[i] >=0 && arr[i] < min){
                ch = (char)i;
                min = arr[i];
            }
        }
        if(ch == '\0')
            return '#';
        else
            return ch;
    }
}
