package org.brody.leetcode;

import org.brody.leetcode.base.TreeNode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/binary-search-tree-to-greater-sum-tree/">1038. 从二叉搜索树到更大和树</a>
 * <p>
 * 给定一个二叉搜索树 root (BST)，请将它的每个节点的值替换成树中大于或者等于该节点值的所有节点值之和。
 * <p>
 * 提醒一下， 二叉搜索树 满足下列约束条件：
 * <p>
 * 节点的左子树仅包含键 小于 节点键的节点。
 * <p>
 * 节点的右子树仅包含键 大于 节点键的节点。
 * <p>
 * 左右子树也必须是二叉搜索树。
 * <p>
 * 示例 1：
 * <p>
 * <img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/05/03/tree.png" style="width: 700px; height: 252px;" title="">
 * <p>
 * 输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * <p>
 * 输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = [0,null,1]
 * <p>
 * 输出：[1,null,1]
 * <p>
 * 提示：
 * <p>
 * 树中的节点数在 [1, 100] 范围内。
 * <p>
 * 0 <= Node.val <= 100
 * <p>
 * 树中的所有值均 不重复 。
 * <p>
 * <p>
 * 注意：该题目与<a href="https://leetcode-cn.com/problems/convert-bst-to-greater-tree/">538</a>  相同
 *
 * @author Brody
 */
public class Medium1038BinarySearchTreeToGreaterSumTree {

    public static void main(String[] args) {
        Medium1038BinarySearchTreeToGreaterSumTree solution = new Medium1038BinarySearchTreeToGreaterSumTree();
        Integer[] arr = {4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8};
        TreeNode root = TreeNode.constructTree(arr);
        solution.bstToGst(root).print();
    }

    /**
     * 这是一个全局变量，用来存储最大的和
     */
    private int s = 0;

    /**
     * 这题一定与递归有关
     * 然后联想到，二叉树的递归，有前序，中序和后序遍历，仔细看题目中的条件，每个右子树都比左子树大
     * 所以，应该是一个逆中序遍历，也即，先右，再根，再左
     *
     * @param root
     * @return
     */
    public TreeNode bstToGst(TreeNode root) {
        dfs(root);
        return root;
    }


    private void dfs(TreeNode root) {
        // 跳出条件，当前结点为空
        if (null == root) {
            return;
        }
        // 递归右节点
        dfs(root.right);
        // 此时 s 就是 >= node.val 的所有数之和
        s += root.val;
        root.val = s;
        // 递归左节点
        dfs(root.left);
    }
}
