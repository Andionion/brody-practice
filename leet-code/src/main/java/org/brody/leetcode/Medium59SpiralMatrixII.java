package org.brody.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/spiral-matrix-ii/description/">59. 螺旋矩阵 II</a>
 * <p>
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * <p>
 * 示例 1：
 * <p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/11/13/spiraln.jpg" style="width: 700px; height: 252px;" title="">
 * <p>
 * 输入：n = 3
 * <p>
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 1
 * <p>
 * 输出：[[1]]
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 20
 *
 * @author Brody
 */
public class Medium59SpiralMatrixII {

    public static void main(String[] args) {
        Medium59SpiralMatrixII solution = new Medium59SpiralMatrixII();
        int n = 5;
        System.out.println(Arrays.deepToString(solution.generateMatrix(n)));
    }

    /**
     * 设定左右上下边界，按照顺序，从左到右，从上到下，从右到左，从下到上顺序填入值
     * <p>
     * 每次到达边界后，边界收缩，这一步非常重要，
     * <p>
     * 例如从左到右结束后需要收缩上边界，从上到下结束后需要收缩右边界，从右到左结束后需要收缩下边界，从下到上需要收缩左边界
     * <p>
     * 使用num<=tar做为循环结束条件
     *
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        // 设定上下左右边界
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        // 计算目标值
        int tar = n * n;
        // 设定矩阵数字初始值
        int num = 1;
        while (num <= tar) {
            // 从左到右
            for (int i = left; i <= right; i++) {
                res[top][i] = num++;
            }
            top++;
            // 从上到下
            for (int i = top; i <= bottom; i++) {
                res[i][right] = num++;
            }
            right--;
            // 从右到左
            for (int i = right; i >= left; i--) {
                res[bottom][i] = num++;
            }
            bottom--;
            // 从下到上
            for (int i = bottom; i >= top; i--) {
                res[i][left] = num++;
            }
            left++;
        }
        return res;
    }
}
