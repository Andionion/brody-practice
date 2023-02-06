package org.brody.leetcode.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayDeque;

/**
 * 二叉树结点
 *
 * @author CYF
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreeNode {
    public int val;
    /**
     * 左节点
     */
    public TreeNode left;
    /**
     * 右节点
     */
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public static TreeNode constructTree(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) {
            return null;
        }
        // 使用队列来存储每一层的非空节点，下一层的数目要比上一层高
        ArrayDeque<TreeNode> pre = new ArrayDeque<>();
        TreeNode root = new TreeNode(arr[0]);
        pre.addLast(root);
        // 表示要遍历的下一个节点
        int index = 0;
        while (!pre.isEmpty()) {
            ArrayDeque<TreeNode> cur = new ArrayDeque<>();
            while (!pre.isEmpty()) {
                TreeNode node = pre.removeFirst();
                TreeNode left = null;
                TreeNode right = null;
                // 如果对应索引上的数组不为空的话就创建一个节点,进行判断的时候，
                // 要先索引看是否已经超过数组的长度，如果索引已经超过了数组的长度，那么剩下节点的左右子节点就都是空了
                // 这里index每次都会增加，实际上是不必要的，但是这样写比较简单
                if (++index < arr.length && arr[index] != null) {
                    left = new TreeNode(arr[index]);
                    cur.addLast(left);
                }
                if (++index < arr.length && arr[index] != null) {
                    right = new TreeNode(arr[index]);
                    cur.addLast(right);
                }
                node.left = left;
                node.right = right;
            }
            pre = cur;
        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] arr = {2, 1, 3, null, null, 0, 1};
        TreeNode treeNode = TreeNode.constructTree(arr);
        treeNode.print();
    }

    public void print() {
        System.out.println("前序遍历输出：");
        printPreOrder();
        System.out.println();
        System.out.println("中序遍历输出：");
        printInOrder();
        System.out.println();
        System.out.println("后序遍历输出：");
        printPostOrder();
        System.out.println();
    }

    /**
     * 后序遍历输出
     */
    public void printPostOrder() {
        if (left != null) {
            left.printPostOrder();
        }
        if (right != null) {
            right.printPostOrder();
        }
        System.out.print(val + " ");
    }

    /**
     * 中序遍历输出
     */
    public void printInOrder() {
        if (left != null) {
            left.printInOrder();
        }
        System.out.print(val + " ");
        if (right != null) {
            right.printInOrder();
        }
    }

    /**
     * 前序遍历
     */
    public void printPreOrder() {
        System.out.print(val + " ");
        if (left != null) {
            left.printPreOrder();
        }
        if (right != null) {
            right.printPreOrder();
        }
    }
}
