package nkw.xz2018.bytedance;

import java.util.*;

/**
 * @author: fangcong
 * @date: 2019/6/30
 */
public class 任务完成计划 {
    static class Idea {
        int pmId;
        int postTime;
        int priority;
        int cost;
        int order;

        public Idea(int pmId, int postTime, int priority, int cost, int order) {
            this.pmId = pmId;
            this.postTime = postTime;
            this.priority = priority;
            this.cost = cost;
            this.order = order;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int q = scanner.nextInt();
        ArrayList<Idea> ideas = new ArrayList<>();  //所有的idea
        int[] finishTime = new int[q];   //每个idea的完成时间
        int[] programTime = new int[q];  //程序员是否空闲
        ArrayList<Idea>[] pmIdea = new ArrayList[q];//每个pm在某个时刻所拥有的未完成的idea
        for(int i = 0; i < q; i ++){
            pmIdea[i] = new ArrayList<>();
        }
        for (int i = 0; i < q; i++) {
            ideas.add(new Idea(scanner.nextInt()-1, scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), i));
        }

        //按照idea提出的时间进行排序
        ideas.sort((idea1, idea2) -> {
            return idea1.postTime - idea2.postTime;
        });

        int nowTime = 1, count = 0, last = 0; //nowTime为当前时间， count已经完成idea数量，last下一次添加任务的起始点
        while (count < q) {
            for (int i = last; i < q; i++) {
                if (ideas.get(i).postTime == nowTime) {
                    //这个idea对应的pm添加，并按照pm的排序规则进行排序
                    pmIdea[ideas.get(i).pmId].add(ideas.get(i));
                    pmIdea[ideas.get(i).pmId].sort((idea1, idea2) -> {
                        if (idea1.priority != idea2.priority)
                            return idea1.priority - idea2.priority;
                        else if (idea1.cost != idea2.cost)
                            return idea1.cost - idea2.cost;
                        return idea1.postTime - idea2.postTime;
                    });
                    if(i == q-1)
                        last = q;
                }else{
                    last = i;
                    break;
                }
            }

            /**
             * 选取每个pm最想完成的idea。程序员只会在这个列表中选取idea
             * 同一时刻，一个pm最多只会有一个idea
             */
            ArrayList<Idea> pmPro = new ArrayList<>();
            for(int i = 0; i < n; i ++){
                if(!pmIdea[i].isEmpty())
                    pmPro.add(pmIdea[i].get(0));
            }

            /**
             * 程序员从pmPro中选取idea，并完成
             */
            for(int i = 0; i < m; i ++){
                //程序员i有空，并且此时有idea
                if(programTime[i] <= nowTime && !pmPro.isEmpty()){
                    //按照程序员的规则来排序
                    pmPro.sort((idea1, idea2) -> {
                        if(idea1.cost != idea2.cost)
                            return idea1.cost - idea2.cost;
                        return idea1.pmId - idea2.pmId;
                    });

                    programTime[i] = nowTime + pmPro.get(0).cost;
                    finishTime[pmPro.get(0).order] = programTime[i];
                    pmIdea[pmPro.get(0).pmId].remove(0);
                    //如果pmIdea[pmId]不为空，就将它的下一个idea加入到pmPro中
                    if(!pmIdea[pmPro.get(0).pmId].isEmpty()){
                        pmPro.add(pmIdea[pmPro.get(0).pmId].get(0));
                    }
                    pmPro.remove(0);
                    count++;
                }
            }
            nowTime++;
        }
        for(int i = 0; i < q; i ++)
            System.out.println(finishTime[i]);
    }
}
