package org.brody.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * <a href="https://leetcode.cn/problems/word-search/description/">79. 单词搜索</a>
 * <p>
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中 “相邻” 单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例 1：
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * <p>
 * 输出：true
 * <p>
 * 示例 2：
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * <p>
 * 输出：true
 * <p>
 * 示例 3：
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * <p>
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * m == board.length
 * <p>
 * n = board[i].length
 * <p>
 * 1 <= m, n <= 6
 * <p>
 * 1 <= word.length <= 15
 * <p>
 * board 和 word 仅由大小写英文字母组成
 * <p>
 * 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？
 *
 * @author CYF
 */
public class Medium79WordSearch {

    public static void main(String[] args) {
        Medium79WordSearch solution = new Medium79WordSearch();
        int[] nums = {1, 2, 3};
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println(solution.exist(board, word));
    }

    /**
     * 这是一个经典的深度优先搜索 (DFS) 的问题，通常可以使用递归或者显式地使用栈来实现
     * <p>
     * exist 方法用于遍历整个二维字符网格，寻找起始字符，并调用 dfs 方法进行递归搜索。
     * <p>
     * dfs 方法用于在给定位置开始搜索，每次递归搜索上、下、左、右四个方向。
     * <p>
     * 搜索过程中标记已访问的字符，防止重复访问。如果找到匹配的单词，返回 true，否则返回 false。
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;

        // 遍历整个二维字符网格
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 如果找到起始字符并开始搜索
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        // 在整个二维字符网格中未找到匹配的单词
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        // 边界条件检查
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        // 如果单词已经全部匹配
        if (index == word.length() - 1) {
            return true;
        }

        // 保存当前字符并标记为已访问
        char temp = board[i][j];
        board[i][j] = ' ';

        // 在上、下、左、右四个方向递归搜索
        boolean result = dfs(board, word, i - 1, j, index + 1) ||
                dfs(board, word, i + 1, j, index + 1) ||
                dfs(board, word, i, j - 1, index + 1) ||
                dfs(board, word, i, j + 1, index + 1);

        // 恢复当前字符
        board[i][j] = temp;

        return result;
    }


}
