package 滑动窗口;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s
 * 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。
 */
public class 长度最小的子数组 {
    /**
     * 左右指针i,j,计算[i,j]的和,如果大于等于s,那么i右移,取count的较小值,直到和小于s,右移j
     */
    public int minSubArrayLen(int s, int[] nums) {
        int count = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= s) {
                count = Math.min(count, right - left + 1);
                sum -= nums[left++];
            }
            ++right;
        }
        return count == Integer.MAX_VALUE ? 0 : count;
    }
}