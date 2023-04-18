package org.brody.leetcode;

import org.brody.leetcode.base.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/maximum-difference-between-node-and-ancestor/description/">1026. 节点与其祖先之间的最大差值</a>
 * <p>
 * 给定二叉树的根节点 root，找出存在于 不同 节点 A 和 B 之间的最大值 V，其中 V = |A.val - B.val|，且 A 是 B 的祖先。
 * <p>
 * （如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先）
 * <p>
 * 示例 1：
 * <p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/11/09/tmp-tree.jpg" style="width: 700px; height: 252px;" title="">
 * <p>
 * 输入：root = [8,3,10,1,6,null,14,null,null,4,7,13]
 * <p>
 * 输出：7
 * <p>
 * 解释：
 * <p>
 * 我们有大量的节点与其祖先的差值，其中一些如下：
 * <p>
 * |8 - 3| = 5
 * <p>
 * |3 - 7| = 4
 * <p>
 * |8 - 1| = 7
 * <p>
 * |10 - 13| = 3
 * <p>
 * 在所有可能的差值中，最大值 7 由 |8 - 1| = 7 得出。
 * <p>
 * 示例 2：
 * <p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/11/09/tmp-tree-1.jpg" style="width: 700px; height: 252px;" title="">
 * <p>
 * 输入：root = [1,null,2,null,0,3]
 * <p>
 * 输出：3
 * <p>
 * 提示：
 * <p>
 * 树中的节点数在 2 到 5000 之间。
 * <p>
 * 0 <= Node.val <= 105
 *
 * @author Brody
 */
public class Medium1026MaximumDifferenceBetweenNodeAndAncestor {

    public static void main(String[] args) {
        Medium1026MaximumDifferenceBetweenNodeAndAncestor solution = new Medium1026MaximumDifferenceBetweenNodeAndAncestor();
        TreeNode root = TreeNode.constructTree(new Integer[]{8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13});
        System.out.println(solution.maxAncestorDiff(root));
    }

    public int maxAncestorDiff(TreeNode root) {
        // 深度优先搜索，查找出节点的最大祖先节点和最小祖先节点，并且记录搜索路径上的节点的最小值min与最大值max
        // 计算此时节点的val和min、max的差值哪个最大，最后和左右子节点进行对比
        return dif(root, root.val, root.val);
    }

    private int dif(TreeNode treeNode, int min, int max) {
        // 首先设定退出递归的条件
        if (treeNode == null) {
            return 0;
        }
        // 计算此时的最大差值
        int res = Math.max(Math.abs(treeNode.val - min), Math.abs(treeNode.val - max));
        // 更新min和max
        min = Math.min(treeNode.val, min);
        max = Math.max(treeNode.val, max);
        // 递归调用对比左右子节点
        res = Math.max(res, dif(treeNode.left, min, max));
        res = Math.max(res, dif(treeNode.right, min, max));
        return res;
    }
}
