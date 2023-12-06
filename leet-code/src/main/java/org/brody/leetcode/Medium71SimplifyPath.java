package org.brody.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>
 * <a href="https://leetcode.cn/problems/simplify-path/description/">71. 简化路径</a>
 * <p>
 * 给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。
 * <p>
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。 对于此问题，任何其他格式的点（例如，'...'）均被视为文件 / 目录名称。
 * <p>
 * 请注意，返回的 规范路径 必须遵循下述格式：
 * <p>
 * 始终以斜杠 '/' 开头。
 * <p>
 * 两个目录名之间必须只有一个斜杠 '/' 。
 * <p>
 * 最后一个目录名（如果存在）不能 以 '/' 结尾。
 * <p>
 * 此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
 * <p>
 * 返回简化后得到的 规范路径 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：path = "/home/"
 * <p>
 * 输出："/home"
 * <p>
 * 解释：注意，最后一个目录名后面没有斜杠。
 * <p>
 * 示例 2：
 * <p>
 * 输入：path = "/../"
 * <p>
 * 输出："/"
 * <p>
 * 解释：从根目录向上一级是不可行的，因为根目录是你可以到达的最高级。
 * 示例 3：
 * <p>
 * 输入：path = "/home//foo/"
 * <p>
 * 输出："/home/foo"
 * <p>
 * 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
 * <p>
 * 示例 4：
 * <p>
 * 输入：path = "/a/./b/../../c/"
 * <p>
 * 输出："/c"
 * <p>
 * 提示：
 * <p>
 * 1 <= path.length <= 3000
 * <p>
 * path 由英文字母，数字，'.'，'/' 或 '_' 组成。
 * <p>
 * path 是一个有效的 Unix 风格绝对路径。
 *
 * @author CYF
 */
public class Medium71SimplifyPath {

    public static void main(String[] args) {
        Medium71SimplifyPath solution = new Medium71SimplifyPath();

    }

    /**
     * 根据题意，使用栈进行模拟即可。
     * <p>
     * 具体的，从前往后处理 path，每次以 item 为单位进行处理（有效的文件名），根据 item 为何值进行分情况讨论：
     * <p>
     * item 为有效值 ：存入栈中；
     * <p>
     * item 为 .. ：弹出栈顶元素（若存在）；
     * <p>
     * item 为 . ：不作处理。
     *
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        Deque<String> deque = new ArrayDeque<>();
        int n = path.length();
        for (int i = 1; i < n; ) {
            if (path.charAt(i) == '/') {
                ++i;
                continue;
            }
            int j = i + 1;
            while (j < n && path.charAt(j) != '/') {
                j++;
            }
            String item = path.substring(i, j);
            if (item.equals("..")) {
                if (!deque.isEmpty()) {
                    deque.pollLast();
                }
            } else if (!item.equals(".")) {
                deque.addLast(item);
            }
            i = j;
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append("/").append(deque.pollFirst());
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
