package org.brody.leetcode;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * <p>
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回[-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author CYF
 */
public class Medium34FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        Medium34FindFirstAndLastPositionOfElementInSortedArray function = new Medium34FindFirstAndLastPositionOfElementInSortedArray();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println(Arrays.toString(function.searchRange(nums, target)));
    }


    public int[] searchRange(int[] nums, int target) {
        int firstIndex = -1;
        int lastIndex = -1;
        if (null == nums || nums.length == 0) {
            return new int[]{firstIndex, lastIndex};
        }
        // 找到那个和给定值相等的数字，然后下标开始向左向右移动到最后一个相等目标值的下标处
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                firstIndex = mid;
                lastIndex = mid;
                while (firstIndex > left && nums[firstIndex] == nums[firstIndex - 1]) {
                    firstIndex--;
                }
                while (lastIndex < right && nums[lastIndex] == nums[lastIndex + 1]) {
                    lastIndex++;
                }
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[]{firstIndex, lastIndex};
    }


}
