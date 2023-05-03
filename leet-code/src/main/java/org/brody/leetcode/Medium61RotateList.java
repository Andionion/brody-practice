package org.brody.leetcode;

import org.brody.leetcode.base.ListNode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/rotate-list/">61. 旋转链表</a>
 * <p>
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * <p>
 * 示例 1：
 * <p>
 * <img src="https://assets.leetcode.com/uploads/2020/11/13/rotate1.jpg" style="width: 700px; height: 252px;" title="">
 * <p>
 * 输入：head = [1,2,3,4,5], k = 2
 * <p>
 * 输出：[4,5,1,2,3]
 * <p>
 * 示例 2：
 * <p>
 * <img src="https://assets.leetcode.com/uploads/2020/11/13/roate2.jpg" style="width: 700px; height: 252px;" title="">
 * <p>
 * 输入：head = [0,1,2], k = 4
 * <p>
 * 输出：[2,0,1]
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 500] 内
 * <p>
 * -100 <= Node.val <= 100
 * <p>
 * 0 <= k <= 2 * 109
 *
 * @author Brody
 */
public class Medium61RotateList {

    public static void main(String[] args) {
        Medium61RotateList solution = new Medium61RotateList();
        ListNode head = new ListNode(new int[]{0, 1, 2});
        int k = 4;
        System.out.println(solution.rotateRight(head, k));
    }

    /**
     * 将链表连成环
     * <p>
     * 要断开的位置是 n - 1 - n % k
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        //
        int length = 1;
        ListNode temp = head;
        while (null != temp.next) {
            length++;
            temp = temp.next;
        }
        // 获取到断链的位置
        k = length - k % length;
        if (k == length) {
            return head;
        }
        // 连成环
        temp.next = head;
        // 断掉链条
        for (int i = 0; i < k; i++) {
            temp = temp.next;
        }
        ListNode res = temp.next;
        temp.next = null;
        return res;
    }
}
