package org.brody.leetcode;

/**
 * <p>
 * <a href="https://leetcode.cn/problems/find-the-array-concatenation-value/">2562. 找出数组的串联值</a>
 * <p>
 * 给你一个下标从 0 开始的整数数组 nums 。
 * <p>
 * 现定义两个数字的 串联 是由这两个数值串联起来形成的新数字。
 * <p>
 * 例如，15 和 49 的串联是 1549 。
 * <p>
 * nums 的 串联值 最初等于 0 。执行下述操作直到 nums 变为空：
 * <p>
 * 如果 nums 中存在不止一个数字，分别选中 nums 中的第一个元素和最后一个元素，将二者串联得到的值加到 nums 的 串联值 上，然后从 nums 中删除第一个和最后一个元素。
 * <p>
 * 如果仅存在一个元素，则将该元素的值加到 nums 的串联值上，然后删除这个元素。
 * <p>
 * 返回执行完所有操作后 nums 的串联值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [7,52,2,4]
 * <p>
 * 输出：596
 * <p>
 * 解释：在执行任一步操作前，nums 为 [7,52,2,4] ，串联值为 0 。
 * <p>
 * - 在第一步操作中：
 * <p>
 * 我们选中第一个元素 7 和最后一个元素 4 。
 * <p>
 * 二者的串联是 74 ，将其加到串联值上，所以串联值等于 74 。
 * <p>
 * 接着我们从 nums 中移除这两个元素，所以 nums 变为 [52,2] 。
 * <p>
 * - 在第二步操作中：
 * <p>
 * 我们选中第一个元素 52 和最后一个元素 2 。
 * <p>
 * 二者的串联是 522 ，将其加到串联值上，所以串联值等于 596 。
 * <p>
 * 接着我们从 nums 中移除这两个元素，所以 nums 变为空。
 * <p>
 * 由于串联值等于 596 ，所以答案就是 596 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [5,14,13,8,12]
 * <p>
 * 输出：673
 * <p>
 * 解释：在执行任一步操作前，nums 为 [5,14,13,8,12] ，串联值为 0 。
 * <p>
 * - 在第一步操作中：
 * <p>
 * 我们选中第一个元素 5 和最后一个元素 12 。
 * <p>
 * 二者的串联是 512 ，将其加到串联值上，所以串联值等于 512 。
 * <p>
 * 接着我们从 nums 中移除这两个元素，所以 nums 变为 [14,13,8] 。
 * <p>
 * - 在第二步操作中：
 * <p>
 * 我们选中第一个元素 14 和最后一个元素 8 。
 * <p>
 * 二者的串联是 148 ，将其加到串联值上，所以串联值等于 660 。
 * <p>
 * 接着我们从 nums 中移除这两个元素，所以 nums 变为 [13] 。
 * <p>
 * - 在第三步操作中：
 * <p>
 * nums 只有一个元素，所以我们选中 13 并将其加到串联值上，所以串联值等于 673 。
 * <p>
 * 接着我们从 nums 中移除这个元素，所以 nums 变为空。
 * <p>
 * 由于串联值等于 673 ，所以答案就是 673 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * <p>
 * 1 <= nums[i] <= 104
 *
 * @author CYF
 */
public class Easy2562FindTheArrayConcatenationValue {

    public long findTheArrayConcVal(int[] nums) {
        if (nums.length == 0) {
            return 0L;
        }
        long res = 0;
        int pre = 0;
        int post = nums.length - 1;
        while (pre <= post) {
            if (pre < post) {
                res += (long) (nums[pre] * Math.pow(10, numLength(nums[post])) + nums[post]);
            } else {
                res += nums[pre];
            }
            pre++;
            post--;
        }
        return res;
    }

    private int numLength(int num) {
        int count = 0;
        while (num > 0) {
            num /= 10;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {7, 52, 2, 4};
        Easy2562FindTheArrayConcatenationValue solution = new Easy2562FindTheArrayConcatenationValue();
        System.out.println(solution.findTheArrayConcVal(nums));
    }
}
