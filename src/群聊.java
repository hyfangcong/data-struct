import java.util.*;

/**
 * @author: fangcong
 * @date: 2019/8/21
 */
public class 群聊 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String target = scanner.next();
        int m = scanner.nextInt();
        ArrayList<String[]> list = new ArrayList<>();
        for(int i = 0 ; i < m; i ++){
            list.add(scanner.next().split(","));
        }
        HashMap<String,HashSet<Integer>> hashMap = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        LinkedList<Integer> queue = new LinkedList<>();
        int index = 0;
        for(String[] arr : list){
            for(String s : arr){
                Set<Integer> tmp = hashMap.get(s);
                if(tmp == null){
                    HashSet<Integer> cur = new HashSet<>();
                    cur.add(index);
                    hashMap.put(s, cur);
                }else{
                    HashSet<Integer> cur = hashMap.get(s);
                    cur.add(index);
                    hashMap.put(s,cur);

                }
                if(s.equals(target)){
                    if(!set.contains(index)){
                        queue.addLast(index);
                        set.add(index);
                    }
                }
            }
            index++;
        }


        while(!queue.isEmpty()){
            int i = queue.poll();
            if(set.contains(i)){
                continue;
            }else{
                for(String s : list.get(i)){
                    HashSet<Integer> tmp = hashMap.get(s);
                    Iterator<Integer> iterator = tmp.iterator();
                    while (iterator.hasNext()){
                        int p = iterator.next();
                        if(!set.contains(p)){
                            set.add(p);
                            queue.offer(p);
                        }
                    }
                }
            }
        }

        Set<String> ans = new HashSet<>();
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            for(String s : list.get(iterator.next())){
                ans.add(s);
            }
        }
        System.out.println(ans.size());
    }
}
