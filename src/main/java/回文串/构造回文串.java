package 回文串;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jintao.bai on 2020/5/29 11:48
 */
public class 构造回文串 {
    //给定一个字符串 返回能构造出的最大回文串的长度
    public int longestPalindrome(String s) {
        //偶数个数的字符可以构造
        //如果有奇数个的字符的话 +1
        int oddCount = 0;
        Set<Character> evenSet = new HashSet<>();
        for (char c : s.toCharArray()) {
            //如果set里有这个字符 说明这个字符目前有两个
            if (evenSet.contains(c)) {
                oddCount += 2;
                evenSet.remove(c);
            } else {
                evenSet.add(c);
            }
        }
        return evenSet.isEmpty() ? oddCount : oddCount + 1;
    }

    public static void main(String[] args) {
        System.out.println(new 构造回文串().longestPalindrome("abccccdd"));
    }
}
