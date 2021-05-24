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
    public static void main(String[] args) {
        int[] array = new int[] { 8, 2, 4, 4, 4, 9, 5, 2, 5, 8, 8, 0, 8, 6, 9, 1, 1, 6, 3, 5, 1, 2, 6, 6, 0, 4, 8, 6, 0,
                3, 2, 8, 7, 6, 5, 1, 7, 0, 3, 4, 8, 3, 5, 9, 0, 4, 0, 1, 0, 5, 9, 2, 0, 7, 0, 2, 1, 0, 8, 2, 5, 1, 2, 3,
                9, 7, 4, 7, 0, 0, 1, 8, 5, 6, 7, 5, 1, 9, 9, 3, 5, 0, 7, 5 };
        System.out.println();
    }

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
