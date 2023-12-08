package org.brody.leetcode;

import java.util.Arrays;

/**
 * <p>
 * <a href="https://leetcode.cn/problems/set-matrix-zeroes/description/">73. 矩阵置零</a>
 * <p>
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * <p>
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 * <p>
 * 示例 2：
 * <p>
 * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * <p>
 * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * <p>
 * n == matrix[0].length
 * <p>
 * 1 <= m, n <= 200
 * <p>
 * -231 <= matrix[i][j] <= 231 - 1
 * <p>
 * 进阶：
 * <p>
 * 一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * <p>
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * <p>
 * 你能想出一个仅使用常量空间的解决方案吗？
 *
 * @author CYF
 */
public class Medium73SetMatrixZeroes {

    public static void main(String[] args) {
        Medium73SetMatrixZeroes solution = new Medium73SetMatrixZeroes();
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        solution.setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    /**
     * 我们可以用两个标记数组分别记录每一行和每一列是否有零出现。
     * <p>
     * 具体地，我们首先遍历该数组一次，如果某个元素为 000，那么就将该元素所在的行和列所对应标记数组的位置置为 true\text{true}true。
     * <p>
     * 最后我们再次遍历该数组，用标记数组更新原数组即可。
     *
     * @param matrix
     * @return
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        // 双重循环实际上固定了行或者列，例如第1行，然后是1 - n列
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
