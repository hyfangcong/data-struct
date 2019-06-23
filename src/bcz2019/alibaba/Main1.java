package bcz2019.alibaba;

import java.util.*;

public class Main1 {

    static int reward = 0;
    static String calculate(int m, int k) {
        String res = "";
        res += number(m, k) + ",";
        res += bornYear(m) + ",";
        res += reward ;
        return res;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split(",");
        int m = Integer.valueOf(line[0]);
        int k = Integer.valueOf(line[1]);;
        System.out.println(calculate(m, k));
    }

    public static String number(int m, int k){
        int[] memory = new int[m + 1];
        memory[1] = 2;
        memory[2] = 3;
        memory[3] = 4;

        for(int i = 4; i <= m ; i ++){
            memory[i] = memory[i - 2] + memory[i - 3];
        }

        //计算谁中奖
        List<Node> list = new ArrayList<>();
        list.add(new Node(1, "1"));
        for(int i = 1; i <= m ; i ++){
            StringBuilder sb = new StringBuilder(memory[i]);
            list.add(new Node(i, sb.reverse().toString()));
        }

        //用于对象间的比较，可以使用比较器
        Collections.sort(list, Comparator.comparing(Node::getValue));
        reward = list.get(list.size() - k).index;
        return memory[m] + "";
    }

    public static String bornYear(int m){
        int p1 = 1, p2 = 0, p3 = 1;
        int year = 2019;
        int sum = 2;
        while(sum < m){
            p3 += p2;
            p2 = p1;
            p1 = p3;
            sum = p1 + p2 + p3;
            year++;
        }
        return year + "";
    }

    static class Node{
        int index;
        String value;
        public Node(int index, String value){
            this.index = index;
            this.value = value;
        }


        public String getValue() {
            return value;
        }
    }
}
