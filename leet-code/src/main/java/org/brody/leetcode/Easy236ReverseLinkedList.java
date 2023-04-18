package org.brody.leetcode;

import org.brody.leetcode.base.ListNode;

/**
 * <a href="https://leetcode.cn/problems/reverse-linked-list/">206. 反转链表</a>
 * <p>
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * <p>
 * 示例 1：
 * <p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/rev1ex1.jpg" style="width: 700px; height: 252px;" title="">
 * <p>
 * 输入：head = [1,2,3,4,5]
 * <p>
 * 输出：[5,4,3,2,1]
 * <p>
 * 示例 2：
 * <p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/rev1ex2.jpg" style="width: 700px; height: 252px;" title="">
 * <p>
 * 输入：head = [1,2]
 * <p>
 * 输出：[2,1]
 * <p>
 * 示例 3：
 * <p>
 * 输入：head = []
 * 输出：[]
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 * <p>
 * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 *
 * @author Brody
 */
public class Easy236ReverseLinkedList {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(new int[]{1, 2, 3, 4, 5});
        Easy236ReverseLinkedList solution = new Easy236ReverseLinkedList();
        System.out.println(solution.reverseList(listNode));
    }

    public ListNode reverseList(ListNode head) {
        // 利用双指针
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
