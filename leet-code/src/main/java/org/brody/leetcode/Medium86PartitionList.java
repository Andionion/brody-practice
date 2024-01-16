package org.brody.leetcode;

import org.brody.leetcode.base.ListNode;

/**
 * <p>
 * <a href="https://leetcode.cn/problems/partition-list/description/">86. 分隔链表</a>
 * <p>
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * <p>
 * 示例 1：
 * <p>
 * <img src="https://assets.leetcode.com/uploads/2021/01/04/partition.jpg" >
 * <p>
 * 输入：head = [1,4,3,2,5,2], x = 3
 * <p>
 * 输出：[1,2,2,4,3,5]
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [2,1], x = 2
 * <p>
 * 输出：[1,2]
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 200] 内
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 *
 * @author CYF
 */
public class Medium86PartitionList {

    public static void main(String[] args) {
        Medium86PartitionList solution = new Medium86PartitionList();
        int[] val = {1, 4, 3, 2, 5, 2, 1, 2, 4, 6, 3};
        ListNode head = new ListNode(val);
        System.out.println(solution.partition(head, 3));
    }

    /**
     * 使用两个指针，分别表示小于 x 的部分和大于等于 x 的部分，然后将链表中的节点根据值分隔到这两个部分
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if (null == head || null == head.next) {
            return head;
        }
        // 创建两个虚拟头节点
        ListNode dummySmaller = new ListNode();
        ListNode dummyGreater = new ListNode();
        // 创建两个可变节点进行遍历
        ListNode smaller = dummySmaller;
        ListNode greater = dummyGreater;
        // 开始遍历
        while (null != head) {
            // 将小于 x 的节点链接到 smaller 分区
            if (head.val < x) {
                smaller.next = head;
                smaller = smaller.next;
            } else { // 将大于等于 x 的节点链接到 greater 分区
                greater.next = head;
                greater = greater.next;
            }
            // 移动原链表的指针
            head = head.next;
        }
        // 拼接两个链表
        smaller.next = dummyGreater.next;
        // 将最后一个节点的next置为null，防止出现循环链表
        greater.next = null;
        return dummySmaller.next;
    }

}
