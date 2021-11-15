package 剑指offer系列;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * 
 * 输入: [0,1,3] 输出: 2
 * 
 * 输入: [0,1,2,3,4,5,6,7,9] 输出: 8
 */
public class 零到n中的数字 {
    public static int missingNumber(int[] nums) {
        /**
         * 长度n-1 每个数字都在0到n-1且唯一
         * 
         * 0 1 2 ... n-2
         * 
         * 正常情况下nums[i] = i,直到某位不存在，比如0 1 2 4 ，nums[3] < 3
         * 
         */
        int left = 0, right = nums.length - 1, mid = left;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[] { 0, 2 }));
    }

}
