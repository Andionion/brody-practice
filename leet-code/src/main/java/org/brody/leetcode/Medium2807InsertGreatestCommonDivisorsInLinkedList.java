package org.brody.leetcode;

import org.brody.leetcode.base.ListNode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/insert-greatest-common-divisors-in-linked-list/description/">2807. 在链表中插入最大公约数</a>
 * <p>
 * 给你一个链表的头 head ，每个结点包含一个整数值。
 * <p>
 * 在相邻结点之间，请你插入一个新的结点，结点值为这两个相邻结点值的 最大公约数 。
 * <p>
 * 请你返回插入之后的链表。
 * <p>
 * 两个数的 最大公约数 是可以被两个数字整除的最大正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [18,6,10,3]
 * <p>
 * 输出：[18,6,6,2,10,1,3]
 * <p>
 * 解释：第一幅图是一开始的链表，第二幅图是插入新结点后的图（蓝色结点为新插入结点）。
 * <p>
 * - 18 和 6 的最大公约数为 6 ，插入第一和第二个结点之间。
 * <p>
 * - 6 和 10 的最大公约数为 2 ，插入第二和第三个结点之间。
 * <p>
 * - 10 和 3 的最大公约数为 1 ，插入第三和第四个结点之间。
 * <p>
 * 所有相邻结点之间都插入完毕，返回链表。
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [7]
 * <p>
 * 输出：[7]
 * <p>
 * 解释：第一幅图是一开始的链表，第二幅图是插入新结点后的图（蓝色结点为新插入结点）。
 * <p>
 * 没有相邻结点，所以返回初始链表。
 * <p>
 * 提示：
 * <p>
 * 链表中结点数目在 [1, 5000] 之间。
 * <p>
 * 1 <= Node.val <= 1000
 *
 * @author Brody
 */
public class Medium2807InsertGreatestCommonDivisorsInLinkedList {

    public static void main(String[] args) {
        Medium2807InsertGreatestCommonDivisorsInLinkedList solution = new Medium2807InsertGreatestCommonDivisorsInLinkedList();
        int[] nums = {18, 6, 10, 3};
        ListNode head = new ListNode(nums);
        System.out.println(solution.insertGreatestCommonDivisors(head).toString());
    }

    /**
     * 双指针pre和post，pre在前，post在后
     * <p>
     * 每次遍历新建一个节点，节点值为最大公约数
     * <p>
     * pre节点的next是最大公约数节点，最大公约数节点的next是post节点
     * <p>
     * pre=post，post=post.next
     * <p>
     * post节点不为空为循环条件
     *
     * @param head
     * @return
     */
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }

        ListNode pre = head;
        ListNode post = head.next;

        while (null != post) {
            ListNode cur = new ListNode(getMaxDivisor(pre.val, post.val));
            pre.next = cur;
            cur.next = post;

            pre = post;
            post = post.next;
        }
        return head;
    }

    private int getMaxDivisor(int num1, int num2) {
        if (num2 == 0) {
            // 如果其中一个数字等于零，则返回非零数字作为结果
            return num1;
        } else {
            // 使用辗转相除法进行计算
            return getMaxDivisor(num2, num1 % num2);
        }
    }
}
