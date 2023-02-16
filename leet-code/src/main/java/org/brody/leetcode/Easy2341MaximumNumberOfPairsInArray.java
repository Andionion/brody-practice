package org.brody.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/maximum-number-of-pairs-in-array/">2341. 数组能形成多少数对</a>
 * <p>
 * 给你一个下标从 0 开始的整数数组 nums 。在一步操作中，你可以执行以下步骤：
 * <p>
 * 从 nums 选出 两个 相等的 整数
 * <p>
 * 从 nums 中移除这两个整数，形成一个 数对
 * <p>
 * 请你在 nums 上多次执行此操作直到无法继续执行。
 * <p>
 * 返回一个下标从 0 开始、长度为 2 的整数数组 answer 作为答案，其中 answer[0] 是形成的数对数目，answer[1] 是对 nums 尽可能执行上述操作后剩下的整数数目。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,2,1,3,2,2]
 * <p>
 * 输出：[3,1]
 * <p>
 * 解释：
 * nums[0] 和 nums[3] 形成一个数对，并从 nums 中移除，nums = [3,2,3,2,2] 。
 * <p>
 * nums[0] 和 nums[2] 形成一个数对，并从 nums 中移除，nums = [2,2,2] 。
 * <p>
 * nums[0] 和 nums[1] 形成一个数对，并从 nums 中移除，nums = [2] 。
 * <p>
 * 无法形成更多数对。总共形成 3 个数对，nums 中剩下 1 个数字。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,1]
 * <p>
 * 输出：[1,0]
 * <p>
 * 解释：nums[0] 和 nums[1] 形成一个数对，并从 nums 中移除，nums = [] 。
 * <p>
 * 无法形成更多数对。总共形成 1 个数对，nums 中剩下 0 个数字。
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * <p>
 * 输出：[0,1]
 * <p>
 * 解释：无法形成数对，nums 中剩下 1 个数字。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * <p>
 * 0 <= nums[i] <= 100
 *
 * @author Brody
 */
public class Easy2341MaximumNumberOfPairsInArray {

    public static void main(String[] args) {
        Easy2341MaximumNumberOfPairsInArray solution = new Easy2341MaximumNumberOfPairsInArray();
        int[] nums = {1, 3, 2, 1, 3, 2, 2};
        System.out.println(Arrays.toString(solution.numberOfPairs(nums)));
    }

    /**
     * 简单粗暴地方法，只针对这一题好用，因为有限制条件
     *
     * @param nums
     * @return
     */
    public int[] numberOfPairs(int[] nums) {
        int[] dict = new int[101];
        int[] res = new int[2];
        for (int num : nums) {
            dict[num]++;
        }
        for (int num : dict) {
            res[0] += num / 2;
            res[1] += num % 2;
        }
        return res;
    }

    /**
     * 官方解法，巧用Boolean的翻转作为哈希表
     *
     * @param nums
     * @return
     */
/*    public int[] numberOfPairs(int[] nums) {
        int[] res = new int[2];
        Map<Integer, Boolean> numMap = new HashMap<>(nums.length);
        for (int num : nums) {
            numMap.put(num, !numMap.getOrDefault(num, true));
            if (numMap.get(num)) {
                res[0]++;
            }
        }
        res[1] = nums.length - res[0] * 2;
        return res;
    }*/

    /**
     * 双指针法，实际并不节省时间，还不如简单粗暴的办法
     *
     * @param nums
     * @return
     */
/*    public int[] numberOfPairs(int[] nums) {
        if (nums.length == 0) {
            return new int[]{0, 0};
        }
        // 先对数组进行排序，然后开始使用双指针进行探测
        int[] res = new int[2];
        Arrays.sort(nums);
        int pre = 0;
        int index = 0;
        while (index++ <= nums.length - 1) {
            if (index == nums.length || nums[index] != nums[pre]) {
                res[0] += (index - pre) / 2;
                res[1] += (index - pre) % 2;
                pre = index;
            }
        }
        return res;
    }*/
}
