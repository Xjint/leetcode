package 动态规划系列;

/**
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 */
public class 最长重复子数组 {

    /**
     * dp[i][j]表示以i,j结尾的A，B的最长数字
     */
    public int findLength(int[] A, int[] B) {
        int lenA = A.length;
        int lenB = B.length;
        int[][] dp = new int[lenA + 1][lenB + 1];
        int count = 0;
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
            dp[0][i] = 0;
        }
        for (int i = 1; i <= lenA; i++) {
            for (int j = 1; j <= lenB; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                count = Math.max(count, dp[i][j]);
            }
        }
        return count;
    }
}