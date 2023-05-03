package org.brody.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/check-if-word-is-valid-after-substitutions/description/">1003. 检查替换后的词是否有效</a>
 * <p>
 * 给你一个字符串 s ，请你判断它是否 有效 。
 * <p>
 * 字符串 s 有效 需要满足：假设开始有一个空字符串 t = "" ，你可以执行 任意次 下述操作将 t 转换为 s ：
 * <p>
 * 将字符串 "abc" 插入到 t 中的任意位置。形式上，t 变为 tleft + "abc" + tright，其中 t == tleft + tright 。
 * <p>
 * 注意，tleft 和 tright 可能为 空 。
 * <p>
 * 如果字符串 s 有效，则返回 true；否则，返回 false。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aabcbc"
 * <p>
 * 输出：true
 * <p>
 * 解释：
 * <p>
 * "" -> "abc" -> "aabcbc"
 * <p>
 * 因此，"aabcbc" 有效。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "abcabcababcc"
 * <p>
 * 输出：true
 * <p>
 * 解释：
 * <p>
 * "" -> "abc" -> "abcabc" -> "abcabcabc" -> "abcabcababcc"
 * <p>
 * 因此，"abcabcababcc" 有效。
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "abccba"
 * <p>
 * 输出：false
 * <p>
 * 解释：执行操作无法得到 "abccba" 。
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 2 * 104
 * <p>
 * s 由字母 'a'、'b' 和 'c' 组成
 *
 * @author Brody
 */
public class Medium1003CheckIfWordIsValidAfterSubstitutions {

    public static void main(String[] args) {
        Medium1003CheckIfWordIsValidAfterSubstitutions solution = new Medium1003CheckIfWordIsValidAfterSubstitutions();
        String s = "abccba";
        System.out.println(solution.isValid(s));
    }

    /**
     * 使用栈，将每一个字符压入栈内
     * <p>
     * 如果栈的长度大于等于3，则开始检查栈顶的三个元素是否是"a","b","c"
     * <p>
     * 如果最后栈为空，则说明有效
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        StringBuilder stack = new StringBuilder();
        String t = "abc";
        for (int i = 0; i < s.length(); i++) {
            stack.append(s.charAt(i));
            if (stack.length() >= t.length() && stack.substring(stack.length() - t.length()).equals(t)) {
                stack.delete(stack.length() - t.length(), stack.length());
            }
        }
        return stack.length() == 0;
    }
}
