package org.brody.leetcode;

/**
 * <p>
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/description/">80. 删除有序数组中的重复项 II</a>
 * <p>
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O (1) 额外空间的条件下完成。
 * <p>
 * 说明：
 * <p>
 * 为什么返回数值是整数，但输出的答案是数组呢？
 * <p>
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * <p>
 * 你可以想象内部操作如下:
 * <p>
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * <p>
 * int len = removeDuplicates(nums);
 * <p>
 * // 在函数里修改输入数组对于调用者是可见的。
 * <p>
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * <p>
 * for (int i = 0; i < len; i++) {
 * <p>
 * print(nums[i]);
 * <p>
 * }
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1,2,2,3]
 * <p>
 * 输出：5, nums = [1,1,2,2,3]
 * <p>
 * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3。 不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,1,1,1,1,2,3,3]
 * <p>
 * 输出：7, nums = [0,0,1,1,2,3,3]
 * <p>
 * 解释：函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3。不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 104
 * <p>
 * -104 <= nums[i] <= 104
 * <p>
 * nums 已按升序排列
 *
 * @author CYF
 */
public class Medium80RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        Medium80RemoveDuplicatesFromSortedArray solution = new Medium80RemoveDuplicatesFromSortedArray();
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(solution.removeDuplicates(nums));
    }

    /**
     * 可以使用双指针的方法来解决这个问题
     * <p>
     * 使用两个指针 slow 和 fast，其中 slow 表示允许重复两次的有序数组的尾部，fast 表示当前遍历的元素。
     * <p>
     * 当 nums[fast] 与 nums[slow-2] 不相等时，说明遇到了新的元素，可以将其加入允许重复两次的有序数组中。
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n; // 如果数组长度小于等于2，则无需删除重复元素
        }

        int slow = 2; // 慢指针从第三个元素开始，因为前两个元素允许重复
        for (int fast = 2; fast < n; fast++) {
            if (nums[fast] != nums[slow - 2]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }

        return slow;
    }


}
