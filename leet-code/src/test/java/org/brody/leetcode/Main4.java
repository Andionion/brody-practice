package org.brody.leetcode;

/**
 * 字符串压缩
 * <p>
 * AAAA - A4
 * <p>
 * ABAB - AB2
 * <p>
 * ABCABCC - ABC2C
 */
public class Main4 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0};
        maxNum(nums, 3);
    }

    private static void maxNum(int[] nums, int m) {
        // 查找到最长的1的片段
        int result = 0;
        if (nums.length == 0) {
            System.out.println(0);
            return;
        }
        int maxLeft = 0;
        int maxRight = 0;
        int right;
        int left;
        for (left = 0; left < nums.length; left++) {
            if (nums[left] == 1) {
                right = left;
                while (nums[right] == 1) {
                    right++;
                }
                if (right - left > result) {
                    result = right - left;
                    maxLeft = left;
                    maxRight = right - 1;
                }
                left = right;
            }
        }
        System.out.println(maxLeft + " " + maxRight);
        // 然后开始向左向右扩展m，当扩展到最左或者最右时，检测当前下标是否时1，如果是，再继续添加这一个1的片段
        int leftResult = 0;
        int rightResult = 0;
        for (int i = maxLeft; i >= 0 && maxLeft - i < m; i--) {
            leftResult++;
        }
        System.out.println(leftResult);
        if (maxLeft - leftResult > 0 && nums[maxLeft - leftResult - 1] == 1) {
            while (maxLeft - leftResult > 0 && nums[maxLeft - leftResult - 1] == 1) {
                leftResult++;
            }
        }
        for (int i = maxRight; i <= nums.length && i - maxRight < m; i++) {
            rightResult++;
        }
        System.out.println(rightResult);
        if (maxRight + rightResult < nums.length - 1 && nums[maxRight + rightResult + 1] == 1) {
            while (maxRight + rightResult <= nums.length && nums[maxRight + rightResult + 1] == 1) {
                rightResult++;
            }
        }
        result += Math.max(leftResult, rightResult);
        System.out.println(result);
    }
}
