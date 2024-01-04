package org.brody.leetcode;

import org.brody.leetcode.base.ListNode;

/**
 * <p>
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/description/">82. 删除排序链表中的重复元素 II</a>
 * <p>
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,2,3,3,4,4,5]
 * <p>
 * 输出：[1,2,5]
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [1,1,1,2,3]
 * <p>
 * 输出：[2,3]
 * <p>
 * 提示：
 * <p>
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 *
 * @author CYF
 */
public class Medium82RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        Medium82RemoveDuplicatesFromSortedList solution = new Medium82RemoveDuplicatesFromSortedList();
        int[] val = {1, 1, 1, 2, 3};
        ListNode head = new ListNode(val);
        System.out.println(solution.deleteDuplicates(head).toString());
    }

    /**
     * 使用 dummy 节点来简化头节点的处理，然后使用 current 指针来遍历链表。
     * <p>
     * 在遍历的过程中，如果发现当前节点与下一个节点的值相同，就删除所有重复的节点；否则，继续遍历。
     * <p>
     * 这样，最终得到的链表就是删除所有重复数字后的已排序链表
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        // 空链条或者单个节点直接返回即可
        if (null == head || null == head.next) {
            return head;
        }
        // 创建一个dummy节点，它的下一个节点指向头节点，简化对于头节点的处理
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 然后创建一个可移动节点
        ListNode current = dummy;
        // 遍历链表
        while (current.next != null && current.next.next != null) {
            // 如果后两个节点数字重复，则开始删除
            if (current.next.val == current.next.next.val) {
                int val = current.next.val;
                while (current.next != null && current.next.val == val) {
                    current.next = current.next.next;
                }
            } else {
                // 不重复，则向后移动一个即可
                current = current.next;
            }
        }
        return dummy.next;
    }

}
