import java.util.*;

/**
 * @author: fangcong
 * @date: 2019/8/25
 */
public class Main {
    static class Node{
        int x , y, z;
        public Node(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n  = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = in.nextInt();
        }
        HashMap<Integer,Integer> frequency = new HashMap<>();
        HashMap<Integer,Integer>firstIndex = new HashMap<>();
        for(int i = 0; i < n; i ++){
            if(frequency.containsKey(arr[i])){
                frequency.put(arr[i], frequency.get(arr[i])+1);
            }else{
                firstIndex.put(arr[i], i);
                frequency.put(arr[i], 1);
            }
        }
        ArrayList<Node> ans = new ArrayList<>();
        Iterator<Map.Entry<Integer, Integer>> iterator = frequency.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer,Integer> entry = iterator.next();
            int x = entry.getKey();
            int y = entry.getValue();
            int z = firstIndex.get(x);
            ans.add(new Node(x,y,z));
        }
        Collections.sort(ans, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.y != o2.y){
                    return o2.y-o1.y;
                }
                return o1.z - o2.z;
            }
        });

        for(Node node : ans){
            int y = node.y;
            while(y > 0){
                System.out.print(node.x+" ");
                y--;
            }
        }
    }
}
