package 回文串;

import java.util.List;
import java.util.Objects;

/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * 
 * 说明：
 * 
 * 拆分时可以重复使用字典中的单词。 你可以假设字典中没有重复的单词
 */

public class 单词拆分 {
    /**
     * 第i个位置结束的单词是否满足条件，取决于
     * 
     * j = 0 >>>> i-1
     * 
     * 第j个位置结束的单词是否在 && (j,i)子串是否在列表中
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        check(s, wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    private void check(String s, List<String> wordDict) {
        if (Objects.isNull(s) || s.isEmpty() || Objects.isNull(wordDict) || wordDict.isEmpty()) {
            throw new RuntimeException();
        }
    }
}