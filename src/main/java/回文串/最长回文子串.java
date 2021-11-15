package 回文串;

/**
 * Created by jintao.bai on 2020/5/30 16:12
 * <p>
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */
public class 最长回文子串 {
    public String longestPalindrome(String s) {
        String res = "";
        String tmp;
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (isPalindrome(tmp = s.substring(i, j)) && (j - i) > res.length()) {
                    res = tmp;
                }
            }
        }
        return res;
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.equals("")) {
            return true;
        }
        int l = 0, r = s.length() - 1;
        s = s.toLowerCase();
        while (l <= r) {
            char cl = s.charAt(l);
            char cr = s.charAt(r);
            // 跳过非字母数字、空格这些
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
}
