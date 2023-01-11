package org.brody.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/check-if-number-has-equal-digit-count-and-digit-value/">2283. 判断一个数的数字计数是否等于数位的值.</a>
 * <p>
 * 给你一个下标从 0 开始长度为 n 的字符串 num ，它只包含数字。
 * <p>
 * 如果对于 每个 0 <= i < n 的下标 i ，都满足数位 i 在 num 中出现了 num[i] 次，那么请你返回 true ，否则返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = "1210"
 * <p>
 * 输出：true
 * <p>
 * 解释：
 * num[0] = '1' 。数字 0 在 num 中出现了一次。
 * <p>
 * num[1] = '2' 。数字 1 在 num 中出现了两次。
 * <p>
 * num[2] = '1' 。数字 2 在 num 中出现了一次。
 * <p>
 * num[3] = '0' 。数字 3 在 num 中出现了零次。
 * <p>
 * "1210" 满足题目要求条件，所以返回 true 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：num = "030"
 * <p>
 * 输出：false
 * <p>
 * 解释：
 * num[0] = '0' 。数字 0 应该出现 0 次，但是在 num 中出现了一次。
 * <p>
 * num[1] = '3' 。数字 1 应该出现 3 次，但是在 num 中出现了零次。
 * <p>
 * num[2] = '0' 。数字 2 在 num 中出现了 0 次。
 * <p>
 * 下标 0 和 1 都违反了题目要求，所以返回 false 。
 * <p>
 * 提示：
 * <p>
 * n == num.length
 * <p>
 * 1 <= n <= 10
 * <p>
 * num 只包含数字。
 *
 * @author Brody
 */
public class Easy2283CheckIfNumberHasEqualDigitCountAndDigitValue {

    public static void main(String[] args) {
        Easy2283CheckIfNumberHasEqualDigitCountAndDigitValue solution = new Easy2283CheckIfNumberHasEqualDigitCountAndDigitValue();
        System.out.println(solution.digitCount("1210"));
    }

    public boolean digitCount(String num) {
        // 首先对数字进行遍历统计，存储下来之后，开始判断是否符合
        int[] arr = new int[10];
        for (int i = 0; i < num.length(); i++) {
            arr[num.charAt(i) - '0']++;
        }
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < num.length(); i++) {
            if (arr[i] != num.charAt(i) - '0') {
                return false;
            }
        }
        return true;
    }
}
