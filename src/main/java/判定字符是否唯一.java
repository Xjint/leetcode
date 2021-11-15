/**
 * 判定字符是否唯一
 */
public class 判定字符是否唯一 {

    /* 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。 */
    public boolean isUnique(String astr) {
        if (astr == null || astr.length() < 2) {
            return true;
        }
        int[] helper = new int[52];
        for (char c : astr.toCharArray()) {
            helper[c - 'a']++;
        }
        for (int i : helper) {
            if (i > 1) {
                return false;
            }
        }
        return true;
    }
}