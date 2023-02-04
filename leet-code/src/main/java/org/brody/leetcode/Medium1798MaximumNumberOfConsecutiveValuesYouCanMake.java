package org.brody.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/maximum-number-of-consecutive-values-you-can-make/">1798. 你能构造出连续值的最大数目</a>
 * <p>
 * 给你一个长度为 n 的整数数组 coins ，它代表你拥有的 n 个硬币。第 i 个硬币的值为 coins[i] 。如果你从这些硬币中选出一部分硬币，它们的和为 x ，那么称，你可以 构造 出 x 。
 * <p>
 * 请返回从 0 开始（包括 0 ），你最多能构造出多少个连续整数。
 * <p>
 * 你可能有多个相同值的硬币。
 * <p>
 * 示例 1：
 * <p>
 * 输入：coins = [1,3]
 * <p>
 * 输出：2
 * <p>
 * 解释：你可以得到以下这些值：
 * <p>
 * - 0：什么都不取 []
 * <p>
 * - 1：取 [1]
 * <p>
 * 从 0 开始，你可以构造出 2 个连续整数。
 * <p>
 * 示例 2：
 * <p>
 * 输入：coins = [1,1,1,4]
 * <p>
 * 输出：8
 * <p>
 * 解释：你可以得到以下这些值：
 * <p>
 * - 0：什么都不取 []
 * <p>
 * - 1：取 [1]
 * <p>
 * - 2：取 [1,1]
 * <p>
 * - 3：取 [1,1,1]
 * <p>
 * - 4：取 [4]
 * <p>
 * - 5：取 [4,1]
 * <p>
 * - 6：取 [4,1,1]
 * <p>
 * - 7：取 [4,1,1,1]
 * <p>
 * 从 0 开始，你可以构造出 8 个连续整数。
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [1,4,10,3,1]
 * <p>
 * 输出：20
 * <p>
 * 提示：
 * <p>
 * coins.length == n
 * <p>
 * 1 <= n <= 4 * 104
 * <p>
 * 1 <= coins[i] <= 4 * 104
 *
 * @author Brody
 */
public class Medium1798MaximumNumberOfConsecutiveValuesYouCanMake {

    public static void main(String[] args) {
        Medium1798MaximumNumberOfConsecutiveValuesYouCanMake solution = new Medium1798MaximumNumberOfConsecutiveValuesYouCanMake();
        int[] coins = {1, 1, 1, 4};
        System.out.printf("结果：%s", solution.getMaximumConsecutive(coins));
    }

    public int getMaximumConsecutive(int[] coins) {
        // 首先序列化为有序数组
        Arrays.sort(coins);
        // 当下标为n的数据，大于r时，意味着这之后的数据均不可用
        // 至少有1个连续整数就是0
        int r = 1;
        for (int coin : coins) {
            if (coin > r) {
                break;
            }
            r += coin;
        }
        return r;
    }
}
