package leetcode.leetcodedynamic;

/**
 * @author: fangcong
 * @date: 2019/5/11
 */
public class 超级洗衣机 {

    public static void main(String[] args) {
        int[] arr = {5,13,6,6,5};
        System.out.println(findMinMoves(arr));
    }

    /**
     * 将每个洗衣机中的衣服数量相等可以转化为：差值数组中每一项都变为0，差值数组为 diff[i] = machines[i] - target
     *
     * 在把差值数组每一项变为0的操作中，只需要求出其中所需移动衣服最多的洗衣机，就是最少的移动次数。
     *
     * 当diff[i] < 0 时，可以从左右两边的洗衣机获取衣服，取左右中的最大值；
     * 当diff[i] > 0 时，需要把洗衣机的衣服向左右转移，此时移动次数等于diff[i]
     *
     * 我们从左向右依次把差值数组中的每一项变为0：用balance记录当前洗衣机上所要经过的流量。
     * balance += diff[i];
     * balance < 0 说明需要左移，balance > 0 说明需要右移。
     * 那么该洗衣机上的最大操作数为： max(diff[i], Math.abs(balance))
     */
    public static int findMinMoves(int[] machines) {
        int sum = 0;
        for(int num : machines)
            sum += num;
        if(sum % machines.length != 0)
            return -1;

        int target = sum / machines.length;
        int res = 0, balance = 0;
        for(int i = 0 ; i < machines.length; i ++){
            balance += machines[i] - target;
            res = Math.max(res, Math.max(machines[i] - target, Math.abs(balance)));
        }
        return res;
    }
}
