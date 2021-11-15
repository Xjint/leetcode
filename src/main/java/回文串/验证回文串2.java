package 回文串;

/**
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * @author baijintao
 * @date 2021/10/13 11:15 下午
 */
public class 验证回文串2 {

  public boolean validPalindrome(String s) {
    int i = 0, j = s.length() - 1;
    while (i < j) {
      if (s.charAt(i) != s.charAt(j)) {
        return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
      }
    }
    return true;
  }

  private boolean isPalindrome(String s, int i, int j) {
    while (i < j) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
    }
    return true;
  }
}
