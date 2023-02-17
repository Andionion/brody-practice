package org.brody.leetcode;

import org.brody.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-postorder-traversal/">145. 二叉树的后续遍历</a>
 * <p>
 * 给你二叉树的根节点 root ，返回它节点值的 后序 遍历。
 * <p>
 * 示例 1：
 * <p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/09/15/inorder_1.jpg" title="">
 * <p>
 * 输入：root = [1,null,2,3]
 * <p>
 * 输出：[3,2,1]
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
public class Easy145BinaryTreePostorderTraversal {

    public static void main(String[] args) {
        Easy145BinaryTreePostorderTraversal solution = new Easy145BinaryTreePostorderTraversal();
        Integer[] arr = {1, null, 2, 3};
        TreeNode treeNode = TreeNode.constructTree(arr);
        System.out.println(solution.postorderTraversal(treeNode));
    }

    /**
     * 给你二叉树的根节点 root ，返回它节点值的 后序 遍历。
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorderTraversal(root, res);
        return res;
    }

    private void postorderTraversal(TreeNode treeNode, List<Integer> res) {
        if (null == treeNode) {
            return;
        }
        postorderTraversal(treeNode.left, res);
        postorderTraversal(treeNode.right, res);
        res.add(treeNode.val);
    }
}
