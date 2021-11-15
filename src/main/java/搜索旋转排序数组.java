/**
 * Created by jintao.bai on 2020/5/29 10:11
 */
public class 搜索旋转排序数组 {
    /*取mid，其中一部分必然有序
     * 如果*/
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >>> 1);
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[mid] < nums[r]) {
                //说明(mid,r)是有序区间
                if (target > nums[mid] && target < nums[r]) {
                    //target位于有序区间内
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                //说明(l,mid)是有序
                if (target > nums[l] && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return -1;
    }
}
