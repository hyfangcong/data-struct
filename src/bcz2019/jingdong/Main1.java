package bcz2019.jingdong;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int maxLength = 0;
        Set<String> set = new HashSet<>();
        for(int i =0 ; i < n; i ++){
            String ss = scanner.next();
            maxLength = maxLength > ss.length() ? maxLength : ss.length();
            set.add(ss);
        }
        String s = scanner.next();
        List<Node> list = new ArrayList<>();
        for(int i = 1 ; i <= maxLength; i ++){
            for(int j = 0 ; j +i <= s.length(); j ++){
                if(set.contains(s.substring(j, j + i))){
                    list.add(new Node(j, j + i - 1));
                }
            }
        }

        Collections.sort(list, Comparator.comparing(Node::getRight));

        int res = 1;
        int last = list.get(0).right;
        for(int i = 1 ; i < list.size(); i ++){
            Node node = list.get(i);
            if(node.left > last){
                res++;
                last = node.right;
            }
        }
        System.out.println(res);
    }

    static class Node{
        int left;
        int right;
        public Node(int left, int right){
            this.left = left;
            this.right = right;
        }

        public int getRight() {
            return right;
        }
    }
}
