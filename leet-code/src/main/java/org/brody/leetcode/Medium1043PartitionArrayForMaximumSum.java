package org.brody.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/partition-array-for-maximum-sum/description/">1043. 分隔数组以得到最大和</a>
 * <p>
 * 给你一个整数数组 arr，请你将该数组分隔为长度 最多 为 k 的一些（连续）子数组。分隔完成后，每个子数组的中的所有值都会变为该子数组中的最大值。
 * <p>
 * 返回将数组分隔变换后能够得到的元素最大和。本题所用到的测试用例会确保答案是一个 32 位整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,15,7,9,2,5,10], k = 3
 * <p>
 * 输出：84
 * <p>
 * 解释：数组变为 [15,15,15,9,10,10,10]
 * <p>
 * 示例 2：
 * <p>
 * 输入：arr = [1,4,1,5,7,3,6,1,9,9,3], k = 4
 * <p>
 * 输出：83
 * <p>
 * 示例 3：
 * <p>
 * 输入：arr = [1], k = 1
 * <p>
 * 输出：1
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 500
 * <p>
 * 0 <= arr[i] <= 109
 * <p>
 * 1 <= k <= arr.length
 *
 * @author Brody
 */
public class Medium1043PartitionArrayForMaximumSum {

    public static void main(String[] args) {
        Medium1043PartitionArrayForMaximumSum solution = new Medium1043PartitionArrayForMaximumSum();
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {

    }
}
