import java.util.Arrays;

/**
 * Created by jintao.bai on 2020/5/26 17:10
 */
public class 寻找重复数 {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == nums[i]) {
                return i;
            }
        }
        return -1;
    }

    public void me(int i) {
    }

    public void me(float j) {
    }

    public void me(int i, int j) {
    }
}
