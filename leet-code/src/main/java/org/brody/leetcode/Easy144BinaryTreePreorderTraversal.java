package org.brody.leetcode;

import org.brody.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-preorder-traversal/">144. 二叉树的前序遍历</a>
 * <p>
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * <p>
 * 示例 1：
 * <p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/09/15/inorder_1.jpg" title="">
 * <p>
 * 输入：root = [1,null,2,3]
 * <p>
 * 输出：[1,2,3]
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = []
 * <p>
 * 输出：[]
 * <p>
 * 示例 3：
 * <p>
 * 输入：root = [1]
 * <p>
 * 输出：[1]
 * <p>
 * 示例 4：
 * <p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/09/15/inorder_5.jpg" style="width: 202px; height: 202px;" title="">
 * <p>
 * 输入：root = [1,2]
 * <p>
 * 输出：[1,2]
 * <p>
 * 示例 5：
 * <p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/09/15/inorder_4.jpg" style="width: 202px; height: 202px;">
 * <p>
 * 输入：root = [1,null,2]
 * <p>
 * 输出：[1,2]
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [0, 100] 内
 * <p>
 * -100 <= Node.val <= 100
 * <p>
 * 进阶：递归算法很简单，你可以通过迭代算法完成吗？
 *
 * @author Brody
 */
public class Easy144BinaryTreePreorderTraversal {

    public static void main(String[] args) {
        Easy144BinaryTreePreorderTraversal solution = new Easy144BinaryTreePreorderTraversal();
        Integer[] arr = {1, null, 2};
        TreeNode treeNode = TreeNode.constructTree(arr);
        System.out.println(solution.preorderTraversal(treeNode));
    }

    /**
     * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorderTraversal(root, res);
        return res;
    }

    private void preorderTraversal(TreeNode treeNode, List<Integer> res) {
        if (null == treeNode) {
            return;
        }
        res.add(treeNode.val);
        preorderTraversal(treeNode.left, res);
        preorderTraversal(treeNode.right, res);
    }
}
