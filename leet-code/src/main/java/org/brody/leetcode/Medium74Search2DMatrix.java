package org.brody.leetcode;

import java.util.Arrays;

/**
 * <p>
 * <a href="https://leetcode.cn/problems/search-a-2d-matrix/description/">74. 搜索二维矩阵</a>
 * <p>
 * 给你一个满足下述两条属性的 m x n 整数矩阵：
 * <p>
 * 每行中的整数从左到右按非严格递增顺序排列。
 * <p>
 * 每行的第一个整数大于前一行的最后一个整数。
 * <p>
 * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/10/05/mat.jpg" style="width: 700px; height: 252px;" title="">
 * <p>
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * <p>
 * 输出：true
 * <p>
 * 示例 2：
 * <p>
 * <img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/11/25/mat2.jpg" style="width: 700px; height: 252px;" title="">
 * <p>
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * <p>
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * <p>
 * n == matrix[i].length
 * <p>
 * 1 <= m, n <= 100
 * <p>
 * -104 <= matrix[i][j], target <= 104
 *
 * @author CYF
 */
public class Medium74Search2DMatrix {

    public static void main(String[] args) {
        Medium74Search2DMatrix solution = new Medium74Search2DMatrix();
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 13;
        System.out.println(solution.searchMatrix(matrix, target));
    }

    /**
     * 将矩阵看作是一个一维数组，通过二分查找来进行搜索。mid 计算方式是将一维索引映射回二维矩阵中的行和列。
     * <p>
     * 在每一步迭代中，比较中间元素与目标值的大小，缩小搜索范围。
     * <p>
     * 这种方法的时间复杂度为 O(log(m * n))，空间复杂度为 O(1)。
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0, right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = matrix[mid / cols][mid % cols];

            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
