package org.brody.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * <a href="https://leetcode.cn/problems/subsets/description/">78. 子集</a>
 * <p>
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * <p>
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * <p>
 * 输出：[[],[0]]
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10
 * <p>
 * -10 <= nums[i] <= 10
 * <p>
 * nums 中的所有元素 互不相同
 *
 * @author CYF
 */
public class Medium78Subsets {

    public static void main(String[] args) {
        Medium78Subsets solution = new Medium78Subsets();
        int[] nums = {1, 2, 3};
        System.out.println(solution.subsets(nums));
    }

    /**
     * 这个问题可以使用回溯算法来解决。
     * <p>
     * 在回溯过程中，我们逐步构建子集，每次选择一个元素加入当前子集或者不选择它，直到达到数组的末尾。
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentSubset = new ArrayList<>();
        backtrack(result, currentSubset, nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentSubset, int[] nums, int start) {
        result.add(new ArrayList<>(currentSubset));
        for (int i = start; i < nums.length; i++) {
            currentSubset.add(nums[i]);
            backtrack(result, currentSubset, nums, i + 1);
            currentSubset.remove(currentSubset.size() - 1);
        }
    }

}
