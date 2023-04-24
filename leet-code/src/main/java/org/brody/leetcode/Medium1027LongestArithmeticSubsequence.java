package org.brody.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/longest-arithmetic-subsequence/">1027. 最长等差数列</a>
 * <p>
 * 给你一个整数数组 nums，返回 nums 中最长等差子序列的长度。
 * <p>
 * 回想一下，nums 的子序列是一个列表 nums[i1], nums[i2], ..., nums[ik] ，且 0 <= i1 < i2 < ... < ik <= nums.length - 1。并且如果 seq[i+1] - seq[i]( 0 <= i < seq.length - 1) 的值都相同，那么序列 seq 是等差的。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,6,9,12]
 * <p>
 * 输出：4
 * <p>
 * 解释：
 * <p>
 * 整个数组是公差为 3 的等差数列。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [9,4,7,2,10]
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * <p>
 * 最长的等差子序列是 [4,7,10]。
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [20,1,15,3,10,5,8]
 * <p>
 * 输出：4
 * <p>
 * 解释：
 * <p>
 * 最长的等差子序列是 [20,15,10,5]。
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 1000
 * <p>
 * 0 <= nums[i] <= 500
 *
 * @author Brody
 */
public class Medium1027LongestArithmeticSubsequence {

    public static void main(String[] args) {
        Medium1027LongestArithmeticSubsequence solution = new Medium1027LongestArithmeticSubsequence();
        int[] nums = {20, 1, 15, 3, 10, 5, 8};
        System.out.println(solution.longestArithSeqLength(nums));
    }


    /**
     * 我们定义 f[i][j] 表示以 nums[i] 结尾且公差为 j 的等差数列的最大长度。
     * <p>
     * 初始时 f[i][j]=1，即每个元素自身都是一个长度为 1 的等差数列。
     * <p>
     * 由于公差可能为负数，且最大差值为 500，因此，我们可以将统一将公差加上 500，这样公差的范围就变成了 [0,1000]
     * <p>
     * 考虑 f[i]，我们可以枚举 nums[i] 的前一个元素 nums[k]，那么公差 j=nums[i]−nums[k]+500，此时有 f[i][j]=max(f[i][j],f[k][j]+1)，
     * <p>
     * 然后我们更新答案 ans=max(ans,f[i][j])
     * <p>
     * 最后返回答案即可。
     * <p>
     * 如果初始时 f[i][j]=0，那么我们需要在最后返回答案时加上 1。
     * <p>
     * 作者：ylb
     * 链接：<a href="https://leetcode.cn/problems/longest-arithmetic-subsequence/solutions/2239444/python3javacgotypescript-yi-ti-yi-jie-do-h9lz/">作者：ylb</a>
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int[][] f = new int[n][1001];
        for (int i = 1; i < n; ++i) {
            for (int k = 0; k < i; ++k) {
                int j = nums[i] - nums[k] + 500;
                f[i][j] = Math.max(f[i][j], f[k][j] + 1);
                ans = Math.max(ans, f[i][j]);
            }
        }
        return ans + 1;
    }
}
