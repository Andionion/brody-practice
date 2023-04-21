package org.brody.leetcode;

/**
 * <a href="https://leetcode.cn/problems/smallest-even-multiple/">2413. 最小偶倍数</a>
 * <p>
 * 给你一个正整数 n ，返回 2 和 n 的最小公倍数（正整数）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 5
 * <p>
 * 输出：10
 * <p>
 * 解释：5 和 2 的最小公倍数是 10 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 6
 * <p>
 * 输出：6
 * <p>
 * 解释：6 和 2 的最小公倍数是 6 。注意数字会是它自身的倍数。
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 150
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/smallest-even-multiple
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Brody
 */
public class Easy2413SmallestEvenMultiple {

    public static void main(String[] args) {
        Easy2413SmallestEvenMultiple solution = new Easy2413SmallestEvenMultiple();
        int n = 6;
        int x = 16;
        System.out.println(solution.smallestEvenMultiple(n, x));
    }

    /**
     * 最小公倍数为两个数的乘积除以两个数字的最大公约数
     *
     * @param n
     * @return
     */
    public int smallestEvenMultiple(int n, int x) {
        return x * n / greatestCommonDivisor(n, x);
    }

    /**
     * 最小公倍数为两个数的乘积除以两个数字的最大公约数
     *
     * @param n
     * @return
     */
    public int smallestEvenMultiple(int n) {
        return 2 * n / greatestCommonDivisor(2, n);
    }

    /**
     * 计算最大公约数，使用辗转相除法
     * <p>
     * 先用较大的数字除以较小的数字，得到余数
     * <p>
     * 如果余数不为0，让较大的数字等于较小的数字，让较小的数字等于余数
     * <p>
     * 如果余数为0，则此时较小的数字即为最大公约数
     *
     * @param a
     * @param b
     * @return
     */
    public int greatestCommonDivisor(int a, int b) {
        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }
        return a;
    }
}
