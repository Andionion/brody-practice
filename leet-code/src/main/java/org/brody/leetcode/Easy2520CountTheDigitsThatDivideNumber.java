package org.brody.leetcode;

/**
 * <p>
 * <a href="https://leetcode.cn/problems/count-the-digits-that-divide-a-number/">2520. 统计能整除数字的位数</a>
 * <p>
 * 给你一个整数 num ，返回 num 中能整除 num 的数位的数目。
 * <p>
 * 如果满足 nums % val == 0 ，则认为整数 val 可以整除 nums 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 7
 * <p>
 * 输出：1
 * <p>
 * 解释：7 被自己整除，因此答案是 1 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：num = 121
 * <p>
 * 输出：2
 * <p>
 * 解释：121 可以被 1 整除，但无法被 2 整除。由于 1 出现两次，所以返回 2 。
 * <p>
 * 示例 3：
 * <p>
 * 输入：num = 1248
 * <p>
 * 输出：4
 * <p>
 * 解释：1248 可以被它每一位上的数字整除，因此答案是 4 。
 * <p>
 * 提示：
 * <p>
 * 1 <= num <= 109
 * <p>
 * num 的数位中不含 0
 *
 * @author CYF
 */
public class Easy2520CountTheDigitsThatDivideNumber {

    public int countDigits(int num) {
        int res = 0;
        // 使用取模的方式
        int copyNum = num;
        while (copyNum != 0) {
            if (num % (copyNum % 10) == 0) {
                res++;
            }
            copyNum /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        int num = 153;
        Easy2520CountTheDigitsThatDivideNumber solution = new Easy2520CountTheDigitsThatDivideNumber();
        System.out.println(solution.countDigits(num));
    }
}
