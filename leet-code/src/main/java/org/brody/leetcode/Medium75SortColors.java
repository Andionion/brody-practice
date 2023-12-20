package org.brody.leetcode;

import java.util.Arrays;

/**
 * <p>
 * <a href="https://leetcode.cn/problems/sort-colors/description/">75. 颜色分类</a>
 * <p>
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,0,2,1,1,0]
 * <p>
 * 输出：[0,0,1,1,2,2]
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [2,0,1]
 * <p>
 * 输出：[0,1,2]
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * <p>
 * 1 <= n <= 300
 * <p>
 * nums[i] 为 0、1 或 2
 * <p>
 * 进阶：
 * <p>
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 *
 * @author CYF
 */
public class Medium75SortColors {

    public static void main(String[] args) {
        Medium75SortColors solution = new Medium75SortColors();
        int[] nums = {2, 0, 2, 1, 1, 0};
        solution.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }


    /**
     * 这个算法被称为荷兰国旗问题的解法，数组元素被视为荷兰国旗上的三种颜色，通过一次遍历将它们按照给定的顺序进行排序。
     * <p>
     * 通过维护两个指针 pre 和 post，确保 0 在 pre 的左侧，2 在 post 的右侧。
     * <p>
     * 同时，通过遍历指针 current，将元素放到正确的位置。这个算法只需要进行一次遍历，时间复杂度为 O(n)，并且使用常数空间。
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int pre = 0, current = 0, post = nums.length - 1;

        while (current <= post) {
            if (nums[current] == 0) {
                // 如果当前元素是0，将其与pre指向的元素交换，并更新指针
                int temp = nums[current];
                nums[current] = nums[pre];
                nums[pre] = temp;
                pre++;
                current++;
            } else if (nums[current] == 2) {
                // 如果当前元素是2，将其与post指向的元素交换，并更新指针
                int temp = nums[current];
                nums[current] = nums[post];
                nums[post] = temp;
                post--;
            } else {
                // 如果当前元素是1，直接将指针向前移动
                current++;
            }
        }
    }
}
