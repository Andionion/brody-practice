package org.brody.leetcode;

import org.brody.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 95. 不同的二叉搜索树II
 * <p>
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 * <p>
 * 输入：n = 3
 * <p>
 * 输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 1
 * <p>
 * 输出：[[1]]
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 8
 * <p>
 * 来源：力扣（LeetCode）
 * <p>
 * 链接：https://leetcode.cn/problems/unique-binary-search-trees-ii/
 * <p>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author CYF
 */
public class Medium95UniqueBinarySearchTreesTwo {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ans = new ArrayList<>();
        if (n == 0) {
            return ans;
        }
        return getAns(1, n);
    }

    private List<TreeNode> getAns(int start, int end) {
        List<TreeNode> ans = new ArrayList<>();
        //此时没有数字，将null加入结果中
        if (start > end) {
            ans.add(null);
            return ans;
        }

        //只有一个数字，当前数字作为一棵树加入结果中
        if (start == end) {
            TreeNode tree = new TreeNode(start);
            ans.add(tree);
            return ans;
        }

        //尝试每个节点作为根节点
        for (int i = start; i <= end; i++) {
            //得到可能的左子树
            List<TreeNode> leftTrees = getAns(start, i - 1);
            //得到可能的右子树
            List<TreeNode> rightTrees = getAns(i + 1, end);
            //左右子树两两结合
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    //加入到最终结果中
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}
