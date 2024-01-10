package org.brody.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/minimum-string-length-after-removing-substrings/description/">2696. 删除子串后的字符串最小长度</a>
 * <p>
 * 给你一个仅由 大写 英文字符组成的字符串 s 。
 * <p>
 * 你可以对此字符串执行一些操作，在每一步操作中，你可以从 s 中删除 任一个 "AB" 或 "CD" 子字符串。
 * <p>
 * 通过执行操作，删除所有 "AB" 和 "CD" 子串，返回可获得的最终字符串的 最小 可能长度。
 * <p>
 * 注意，删除子串后，重新连接出的字符串可能会产生新的 "AB" 或 "CD" 子串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ABFCACDB"
 * <p>
 * 输出：2
 * <p>
 * 解释：你可以执行下述操作：
 * <p>
 * - 从 "ABFCACDB" 中删除子串 "AB"，得到 s = "FCACDB" 。
 * <p>
 * - 从 "FCACDB" 中删除子串 "CD"，得到 s = "FCAB" 。
 * <p>
 * - 从 "FCAB" 中删除子串 "AB"，得到 s = "FC" 。
 * <p>
 * 最终字符串的长度为 2 。
 * <p>
 * 可以证明 2 是可获得的最小长度。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "ACBBD"
 * <p>
 * 输出：5
 * <p>
 * 解释：无法执行操作，字符串长度不变。
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * <p>
 * s 仅由大写英文字母组成
 *
 * @author Brody
 */
public class Easy2696MinimumStringLengthAfterRemovingSubstrings {

    public static void main(String[] args) {
        Easy2696MinimumStringLengthAfterRemovingSubstrings solution = new Easy2696MinimumStringLengthAfterRemovingSubstrings();
        String s = "ABBC";
        System.out.println(solution.minLength(s));
    }

    /**
     * 使用栈来解决，遍历s的每个字符，当栈顶的字符和当前字符符合AB或者CD，则弹出栈顶，最后返回栈的长度即可
     *
     * @param s
     * @return
     */
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && canFormPair(stack.peek(), c)) {
                stack.pop(); // 弹出栈顶字符，表示消除了一个子串
            } else {
                stack.push(c); // 将字符放入栈中
            }
        }

        return stack.size();
    }

    private boolean canFormPair(char a, char b) {
        return (a == 'A' && b == 'B') || (a == 'C' && b == 'D');
    }
}
