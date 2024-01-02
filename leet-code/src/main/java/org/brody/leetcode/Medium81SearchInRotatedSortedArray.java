package org.brody.leetcode;

/**
 * <p>
 * <a href="https://leetcode.cn/problems/search-in-rotated-sorted-array-ii/description/">81. 搜索旋转排序数组 II</a>
 * <p>
 * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
 * <p>
 * 你必须尽可能减少整个操作步骤。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,5,6,0,0,1,2], target = 0
 * <p>
 * 输出：true
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [2,5,6,0,0,1,2], target = 3
 * <p>
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5000
 * <p>
 * -104 <= nums[i] <= 104
 * <p>
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * <p>
 * -104 <= target <= 104
 *
 * @author CYF
 */
public class Medium81SearchInRotatedSortedArray {

    public static void main(String[] args) {
        Medium81SearchInRotatedSortedArray solution = new Medium81SearchInRotatedSortedArray();
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        System.out.println(solution.search(nums, 0));
    }

    /**
     * 这是一个在旋转有序数组中搜索目标值的问题，可以通过修改二分搜索算法进行解决。
     * <p>
     * 在这个代码中，使用两个指针 left 和 right 来表示搜索范围。
     * <p>
     * 通过二分搜索的思想，首先计算中间位置 mid。
     * <p>
     * 接着，判断左半部分是否有序，如果有序并且目标值在该范围内，则在左半部分进行搜索；
     * <p>
     * 如果左半部分无序，则在右半部分有序的范围内进行搜索；如果左右两部分都无法确定有序，就将搜索范围缩小。
     * <p>
     * 这样的算法可以在 O (log n) 的时间内完成搜索，其中 n 是数组的长度。
     *
     * @param nums
     * @return
     */
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return true;
            }

            // 处理左半部分有序
            if (nums[left] < nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // 处理右半部分有序
            else if (nums[left] > nums[mid]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            // 无法确定哪一部分有序，缩小搜索范围
            else {
                left++;
            }
        }

        return false;
    }


}
