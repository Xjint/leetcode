package 回文串;

/**
 * Created by jintao.bai on 2020/5/30 15:57
 */
public class 验证回文串 {
    //左右指针 相向运动直至相交
    public boolean isPalindrome(String s) {
        if (s == null || s.equals("")) {
            return true;
        }
        int l = 0, r = s.length() - 1;
        s = s.toLowerCase();
        while (l <= r) {
            char cl = s.charAt(l);
            char cr = s.charAt(r);
            //跳过非字母数字、空格这些
            if (!Character.isLetterOrDigit(cl) || cl == ' ') {
                ++l;
                continue;
            }
            if (!Character.isLetterOrDigit(cr) || cr == ' ') {
                --r;
                continue;
            }
            if (cl != cr) {
                return false;
            }
            ++l;
            --r;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new 验证回文串().isPalindrome("A man, a plan, a canal: Panama"));
    }
}
