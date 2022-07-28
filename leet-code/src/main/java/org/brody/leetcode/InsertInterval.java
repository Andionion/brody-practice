package org.brody.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * <p>
 * <p>
 * 示例1：
 * <p>
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * <p>
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10]重叠。
 * <p>
 * 示例 3：
 * <p>
 * 输入：intervals = [], newInterval = [5,7]
 * 输出：[[5,7]]
 * <p>
 * 示例 4：
 * <p>
 * 输入：intervals = [[1,5]], newInterval = [2,3]
 * 输出：[[1,5]]
 * <p>
 * 示例 5：
 * <p>
 * 输入：intervals = [[1,5]], newInterval = [2,7]
 * 输出：[[1,7]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <=intervals[i][0] <=intervals[i][1] <= 105
 * intervals 根据 intervals[i][0] 按 升序 排列
 * newInterval.length == 2
 * 0 <=newInterval[0] <=newInterval[1] <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/insert-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Brody
 */
public class InsertInterval {

    public static void main(String[] args) {
        InsertInterval insertInterval = new InsertInterval();
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        int[][] insert = insertInterval.insert(intervals, newInterval);
        System.out.println(Arrays.deepToString(insert));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 主要是如果有重叠，则取并集
        // 遍历给定数组，如果当前区间的左节点大于要插入区间的右节点，判断要插入的区间是否已经放置，否放在原给定区间左侧
        // 如果当前区间的右节点小于要插入区间的左节点，则要插入的区间还在右侧，只添加当前区间
        // 否则则是和当前区间有重叠，求这两个区间的并集并作为新的区间
        // 最后判断要插入的区间是否已经放置，如果否，则添加要插入的区间
        int left = newInterval[0];
        int right = newInterval[1];
        ArrayList<int[]> list = new ArrayList<>();
        boolean placed = false;
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                if (!placed) {
                    list.add(new int[]{left, right});
                    placed = true;
                }
                list.add(interval);
            } else if (interval[1] < left) {
                list.add(interval);
            } else {
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!placed) {
            list.add(new int[]{left, right});
        }
        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
