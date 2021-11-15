/**
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 
 * 判断你是否能够到达最后一个下标。
 * 
 * nums = [2,3,1,1,4]
 * 
 * 输出：true
 * 
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 
 */
public class 跳跃游戏 {
    public static boolean canJump(int[] nums) {
        // 广度优先 不满足空间复杂度
        // if (nums.length == 1) {
        // return true;
        // }
        // Queue<Integer> queue = new ArrayDeque<>(nums.length);
        // int target = nums.length - 1;
        // queue.add(0);
        // while (!queue.isEmpty()) {
        // for (int i = queue.size(); i > 0; i--) {
        // Integer index = queue.poll();
        // if (index == target) {
        // return true;
        // }
        // int count = nums[index];
        // while (count > 0) {
        // if (index + count == target) {
        // return true;
        // }
        // if (index + count < target) {
        // queue.add(index + count);
        // }
        // --count;
        // }
        // }
        // }
        // return false;

        // 贪心，维护最远能到达的位置
        int arrivable = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= arrivable) {
                arrivable = Math.max(arrivable, i + nums[i]);
                if (arrivable >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
