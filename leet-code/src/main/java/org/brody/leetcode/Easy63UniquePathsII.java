package org.brody.leetcode;

/**
 * <p>
 * <a href="https://leetcode.cn/problems/unique-paths-ii/description/">63. 不同路径 II</a>
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * <p>
 * 示例 1：
 * <p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/11/04/robot1.jpg" style="width: 700px; height: 252px;" title="">
 * <p>
 * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * <p>
 * 输出：2
 * <p>
 * 解释：3x3 网格的正中间有一个障碍物。
 * <p>
 * 从左上角到右下角一共有 2 条不同的路径：
 * <p>
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * <p>
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * <p>
 * 示例 2：
 * <p>
 * * <img alt="" src="https://assets.leetcode.com/uploads/2020/11/04/robot2.jpg" style="width: 700px; height: 252px;" title="">
 * <p>
 * 输入：obstacleGrid = [[0,1],[0,0]]
 * <p>
 * 输出：1
 * <p>
 * 提示：
 * <p>
 * m == obstacleGrid.length
 * <p>
 * n == obstacleGrid[i].length
 * <p>
 * 1 <= m, n <= 100
 * <p>
 * obstacleGrid[i][j] 为 0 或 1
 *
 * @author CYF
 */
public class Easy63UniquePathsII {

    public static void main(String[] args) {
        Easy63UniquePathsII solution = new Easy63UniquePathsII();

    }

    /**
     * 一看就知道是动态规划的问题
     * <p>
     * 动态规划最重要的两项：
     * <p>
     * 1.状态定义，设f(m,n)为走到当前这一格的路径数，那么f(0,0)=0
     * <p>
     * 2.状态转移方程，当前这一格只能由左方和上方过来，所以f(m,n)=f(m-1,n)+f(m,n-1)
     * <p>
     * 特别的，因为有障碍的存在，所以如果a[m,n]=1，则f(m,n)=0
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid[0].length;
        int[] f = new int[m];

        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int[] nums : obstacleGrid) {
            for (int j = 0; j < m; ++j) {
                if (nums[j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && nums[j - 1] == 0) {
                    f[j] += f[j - 1];
                }
            }
        }

        return f[m - 1];
    }

}
