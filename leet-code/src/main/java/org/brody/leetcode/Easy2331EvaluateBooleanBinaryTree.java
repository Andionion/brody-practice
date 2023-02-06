package org.brody.leetcode;

import org.brody.leetcode.base.TreeNode;

/**
 * * <a href="https://leetcode.cn/problems/evaluate-boolean-binary-tree/">2331. 计算布尔二叉树的值</a>
 * <p>
 * 给你一棵 完整二叉树 的根，这棵树有以下特征：
 * <p>
 * 叶子节点 要么值为 0 要么值为 1 ，其中 0 表示 False ，1 表示 True 。
 * <p>
 * 非叶子节点 要么值为 2 要么值为 3 ，其中 2 表示逻辑或 OR ，3 表示逻辑与 AND 。
 * <p>
 * 计算 一个节点的值方式如下：
 * <p>
 * 如果节点是个叶子节点，那么节点的 值 为它本身，即 True 或者 False 。
 * <p>
 * 否则，计算 两个孩子的节点值，然后将该节点的运算符对两个孩子值进行 运算 。
 * <p>
 * 返回根节点 root 的布尔运算值。
 * <p>
 * 完整二叉树 是每个节点有 0 个或者 2 个孩子的二叉树。
 * <p>
 * 叶子节点 是没有孩子的节点。
 * <img alt="" src="https://assets.leetcode.com/uploads/2022/05/16/example1drawio1.png" style="width: 700px; height: 252px;" title="">
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [2,1,3,null,null,0,1]
 * <p>
 * 输出：true
 * <p>
 * 解释：上图展示了计算过程。
 * <p>
 * AND 与运算节点的值为 False AND True = False 。
 * <p>
 * OR 运算节点的值为 True OR False = True 。
 * <p>
 * 根节点的值为 True ，所以我们返回 true 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = [0]
 * <p>
 * 输出：false
 * <p>
 * 解释：根节点是叶子节点，且值为 false，所以我们返回 false 。
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在 [1, 1000] 之间。
 * <p>
 * 0 <= Node.val <= 3
 * <p>
 * 每个节点的孩子数为 0 或 2 。
 * <p>
 * 叶子节点的值为 0 或 1 。
 * <p>
 * 非叶子节点的值为 2 或 3 。
 *
 * @author Brody
 */
public class Easy2331EvaluateBooleanBinaryTree {

    public static void main(String[] args) {
        Easy2331EvaluateBooleanBinaryTree solution = new Easy2331EvaluateBooleanBinaryTree();
        Integer[] arr = {0};
        TreeNode treeNode = TreeNode.constructTree(arr);
        System.out.println(solution.evaluateTree(treeNode));
    }

    public boolean evaluateTree(TreeNode root) {
        // 递归调用，当左右子节点为空时，证明当前结点为叶子结点，直接返回当前值
        if (null == root.left) {
            return 1 == root.val;
        }
        int and = 3;
        int or = 2;
        // 当左右子节点不为空，判断当前值为与还是或
        if (or == root.val) {
            return evaluateTree(root.left) || evaluateTree(root.right);
        }
        if (and == root.val) {
            return evaluateTree(root.left) && evaluateTree(root.right);
        }
        return false;
    }
}
