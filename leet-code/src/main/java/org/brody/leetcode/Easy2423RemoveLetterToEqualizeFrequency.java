package org.brody.leetcode;

/**
 * <a href="https://leetcode.cn/problems/remove-letter-to-equalize-frequency/">2423. 删除字符使频率相同</a>
 * <p>
 * 给你一个下标从 0 开始的字符串 word ，字符串只包含小写英文字母。你需要选择 一个 下标并 删除 下标处的字符，使得 word 中剩余每个字母出现 频率 相同。
 * <p>
 * 如果删除一个字母后，word 中剩余所有字母的出现频率都相同，那么返回 true ，否则返回 false 。
 * <p>
 * 注意：
 * <p>
 * 字母 x 的 频率 是这个字母在字符串中出现的次数。
 * <p>
 * 你 必须 恰好删除一个字母，不能一个字母都不删除。
 * <p>
 * 示例 1：
 * <p>
 * 输入：word = "abcc"
 * <p>
 * 输出：true
 * <p>
 * 解释：选择下标 3 并删除该字母，word 变成 "abc" 且每个字母出现频率都为 1 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：word = "aazz"
 * <p>
 * 输出：false
 * <p>
 * 解释：我们必须删除一个字母，所以要么 "a" 的频率变为 1 且 "z" 的频率为 2 ，要么两个字母频率反过来。所以不可能让剩余所有字母出现频率相同。
 * <p>
 * 提示：
 * <p>
 * 2 <= word.length <= 100
 * word 只包含小写英文字母。
 *
 * @author Brody
 */
public class Easy2423RemoveLetterToEqualizeFrequency {

    public static void main(String[] args) {
        Easy2423RemoveLetterToEqualizeFrequency solution = new Easy2423RemoveLetterToEqualizeFrequency();
        String word = "removelettertoequalizefrequency";
        System.out.println(solution.equalFrequency(word));
    }

    /**
     * 存储每一个字母出现的次数到数组中
     * <p>
     * 遍历数组，先将当前字母出现次数减一，然后遍历剩余的次数是否完全相同，如果是，则返回true
     * <p>
     * 遍历到最后一个，仍然无法满足，返回false
     *
     * @param word
     * @return
     */
    public boolean equalFrequency(String word) {
        int[] cnt = new int[26];
        for (char c : word.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] <= 0) {
                continue;
            }
            cnt[i]--;
            boolean ok = true;
            int temp = 0;
            for (int frequency : cnt) {
                if (0 == frequency) {
                    continue;
                }
                if (temp > 0 && temp != frequency) {
                    ok = false;
                    break;
                }
                temp = frequency;
            }
            if (ok) {
                return true;
            }
            cnt[i]++;
        }
        return false;
    }
}
