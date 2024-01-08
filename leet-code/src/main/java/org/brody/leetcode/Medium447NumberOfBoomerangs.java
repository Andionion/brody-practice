package org.brody.leetcode;

import org.brody.leetcode.base.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/number-of-boomerangs/description/">447. 回旋镖的数量</a>
 * <p>
 * 给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。回旋镖 是由点 (i, j, k) 表示的元组 ，其中 i 和 j 之间的距离和 i 和 k 之间的欧式距离相等（需要考虑元组的顺序）。
 * <p>
 * 返回平面上所有回旋镖的数量。
 * <p>
 * 示例 1：
 * <p>
 * 输入：points = [[0,0],[1,0],[2,0]]
 * <p>
 * 输出：2
 * <p>
 * 解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 * <p>
 * 示例 2：
 * <p>
 * 输入：points = [[1,1],[2,2],[3,3]]
 * <p>
 * 输出：2
 * <p>
 * 示例 3：
 * <p>
 * 输入：points = [[1,1]]
 * <p>
 * 输出：0
 * <p>
 * 提示：
 * <p>
 * n == points.length
 * <p>
 * 1 <= n <= 500
 * <p>
 * points[i].length == 2
 * <p>
 * -104 <= xi, yi <= 104
 * <p>
 * 所有点都 互不相同
 *
 * @author Brody
 */
public class Medium447NumberOfBoomerangs {

    public static void main(String[] args) {
        Medium447NumberOfBoomerangs solution = new Medium447NumberOfBoomerangs();
        int[][] points = {{0, 0}, {1, 0}, {2, 0}, {0, 1}, {1, 1}, {2, 1}, {0, 2}, {1, 2}, {2, 2}, {3, 3}, {4, 4}, {5, 5}};

        System.out.println("Number of boomerangs: " + solution.numberOfBoomerangs(points));

    }

    /**
     * 对于每个点，计算它到其他点的距离，并将距离相等的点归类。对于每个归类的点集，如果有至少两个点，那么它们可以组成回旋镖。
     * <p>
     * 使用两层循环遍历所有点，计算它们之间的距离并将距离相等的点归类
     *
     * @param points
     * @return
     */
    public int numberOfBoomerangs(int[][] points) {
        int count = 0;

        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> distanceCountMap = new HashMap<>();

            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    int distance = calculateDistance(points[i], points[j]);
                    distanceCountMap.put(distance, distanceCountMap.getOrDefault(distance, 0) + 1);
                }
            }

            for (int freq : distanceCountMap.values()) {
                count += freq * (freq - 1);
            }
        }

        return count;
    }

    private int calculateDistance(int[] point1, int[] point2) {
        int dx = point1[0] - point2[0];
        int dy = point1[1] - point2[1];
        return dx * dx + dy * dy;
    }
}
