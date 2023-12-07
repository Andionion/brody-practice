package org.brody.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>
 * <a href="https://leetcode.cn/problems/edit-distance/description/">72. 编辑距离</a>
 * <p>
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * <p>
 * 删除一个字符
 * <p>
 * 替换一个字符
 * <p>
 * 示例 1：
 * <p>
 * 输入：word1 = "horse", word2 = "ros"
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * <p>
 * rorse -> rose (删除 'r')
 * <p>
 * rose -> ros (删除 'e')
 * <p>
 * 示例 2：
 * <p>
 * 输入：word1 = "intention", word2 = "execution"
 * <p>
 * 输出：5
 * <p>
 * 解释：
 * <p>
 * intention -> inention (删除 't')
 * <p>
 * inention -> enention (将 'i' 替换为 'e')
 * <p>
 * enention -> exention (将 'n' 替换为 'x')
 * <p>
 * exention -> exection (将 'n' 替换为 'c')
 * <p>
 * exection -> execution (插入 'u')
 * <p>
 * 提示：
 * <p>
 * 0 <= word1.length, word2.length <= 500
 * word1 和 word2 由小写英文字母组成
 *
 * @author CYF
 */
public class Medium72EditDistance {

    public static void main(String[] args) {
        Medium72EditDistance solution = new Medium72EditDistance();

    }

    /**
     * 动态规划：
     * dp[i][j] 代表 word1 到 i 位置转换成 word2 到 j 位置需要最少步数
     * <p>
     * 所以，
     * <p>
     * 当 word1[i] == word2[j]，dp[i][j] = dp[i-1][j-1]；
     * <p>
     * 当 word1[i] != word2[j]，dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
     * <p>
     * 其中，dp[i-1][j-1] 表示替换操作，dp[i-1][j] 表示删除操作，dp[i][j-1] 表示插入操作。
     * <p>
     * 注意，针对第一行，第一列要单独考虑，我们引入 '' 下图所示：
     * <p>
     * {:align=center}
     * <p>
     * 第一行，是 word1 为空变成 word2 最少步数，就是插入操作
     * <p>
     * 第一列，是 word2 为空，需要的最少步数，就是删除操作
     * <p>
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        // 第一行
        for (int j = 1; j <= n2; j++) dp[0][j] = dp[0][j - 1] + 1;
        // 第一列
        for (int i = 1; i <= n1; i++) dp[i][0] = dp[i - 1][0] + 1;

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
            }
        }
        return dp[n1][n2];
    }
}
