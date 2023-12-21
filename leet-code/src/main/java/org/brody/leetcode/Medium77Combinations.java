package org.brody.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * <a href="https://leetcode.cn/problems/combinations/">77. 组合</a>
 * <p>
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <p>
 * 你可以按 任何顺序 返回答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4, k = 2
 * <p>
 * 输出：
 * [[2,4],[3,4],[2,3],[1,2],[1,3],[1,4]]
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 1, k = 1
 * <p>
 * 输出：[[1]]
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 20
 * 1 <= k <= n
 *
 * @author CYF
 */
public class Medium77Combinations {

    public static void main(String[] args) {
        Medium77Combinations solution = new Medium77Combinations();
        int n = 10;
        int k = 3;
        System.out.println(solution.combine(n, k));
    }

    /**
     * 这个问题可以通过回溯算法来解决。回溯算法通常用于在搜索问题中找到所有可能的解
     * <p>
     * combine 方法用于初始化回溯，调用 backtrack 方法进行递归搜索。
     * <p>
     * backtrack 方法采用深度优先搜索的策略，在每一步都选择一个数加入当前组合，然后递归调用自身
     * <p>
     * 当组合长度达到 k 时，将当前组合加入结果集
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();
        backtrack(result, currentCombination, n, k, 1);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> currentCombination, int n, int k, int start) {
        if (k == 0) {
            // 当 k 达到 0 时，将当前组合加入结果集
            result.add(new ArrayList<>(currentCombination));
            return;
        }
        for (int i = start; i <= n; i++) {
            currentCombination.add(i);
            backtrack(result, currentCombination, n, k - 1, i + 1);
            // 这行代码是为了在回溯的过程中撤销对当前组合的选择。在深度优先搜索中，当我们从一条路径回溯到上一层时，需要撤销当前层的选择，以便继续搜索其他可能的选择。
            currentCombination.remove(currentCombination.size() - 1);
        }
    }

}
