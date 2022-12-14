package org.brody.leetcode;

/**
 * 33. 搜索旋转排序数组
 * <p>
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组[0,1,2,4,5,6,7]可能变为[4,5,6,7,0,1,2])。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回-1。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是O(logn) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * <p>
 * 输出: 4
 * 示例2:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author CYF
 */
public class Medium33SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        Medium33SearchInRotatedSortedArray searchInRotatedSortedArray = new Medium33SearchInRotatedSortedArray();
        System.out.println(searchInRotatedSortedArray.search(nums, target));
    }

    public int search(int[] nums, int target) {
        // 旋转之后的数组可以分为两类，
        // 一类是nums[start] <= nums[mid]，此时前半部分有序。因此如果 nums[start] <= target < nums[mid]。则在前半部分找，否则去后半部分找
        // 一类是nums[start] > nums[mid]，此时后半部分有序。如果nums[mid] <target <= nums[end]。在后半部分找，否则去前半部分找
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 前半部分有序，注意此处用小于等于，因为要考虑到nums长度为偶数
            if (nums[start] <= nums[mid]) {
                // target在前半部分
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
