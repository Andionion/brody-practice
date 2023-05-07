package org.brody.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/pairs-of-songs-with-total-durations-divisible-by-60/description/">1010. 总持续时间可被 60 整除的歌曲</a>
 * <p>
 * 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
 * <p>
 * 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，我们希望下标数字 i 和 j 满足  i < j 且有 (time[i] + time[j]) % 60 == 0。
 * <p>
 * 示例 1：
 * <p>
 * 输入：time = [30,20,150,100,40]
 * <p>
 * 输出：3
 * <p>
 * 解释：这三对的总持续时间可被 60 整除：
 * <p>
 * (time[0] = 30, time[2] = 150): 总持续时间 180
 * <p>
 * (time[1] = 20, time[3] = 100): 总持续时间 120
 * <p>
 * (time[1] = 20, time[4] = 40): 总持续时间 60
 * <p>
 * 示例 2：
 * <p>
 * 输入：time = [60,60,60]
 * <p>
 * 输出：3
 * <p>
 * 解释：所有三对的总持续时间都是 120，可以被 60 整除。
 * <p>
 * 提示：
 * <p>
 * 1 <= time.length <= 6 * 10^4
 * <p>
 * 1 <= time[i] <= 500
 *
 * @author Brody
 */
public class Medium1010PairsOfSongsWithTotalDurationsDivisibleBy60 {

    public static void main(String[] args) {
        Medium1010PairsOfSongsWithTotalDurationsDivisibleBy60 solution = new Medium1010PairsOfSongsWithTotalDurationsDivisibleBy60();
        int[] time = {30, 20, 150, 100, 40};
        System.out.println(solution.numPairsDivisibleBy60(time));
    }

    /**
     * 如果两个数除以60的余数之和为0或者60，那么这两个数字之和一定可以整除60
     * <p>
     * 于是题目就可以转化为，数组中的每个数字都对60求余数，将余数出现的次数存储到一个长度为60的数组中
     * <p>
     * 对于余数为0的数字，需要和余数为0的数字组合到一起，但要排除自己，并且为了排除重复计算的值，结果最终要除以2
     * <p>
     * 对于余数为30的数字，需要和余数为30的数字组合到一起，但要排除自己，同样要排除重复计算的值，结果最终要除以2
     * <p>
     * 对于余数小于30的数字，需要和 60-余数 的数字组合到一起
     * <p>
     * 对于余数大于30的数字，上一步已经计算过，不需要重复计算。
     * <p>
     * 将以上的情况累加，即可得到最终的结果
     *
     * @param time
     * @return
     */
    public int numPairsDivisibleBy60(int[] time) {
        // 余数出现的次数数组
        int[] cnt = new int[60];
        // 将余数出现的次数存储到数组中
        for (int t : time) {
            cnt[t % 60]++;
        }
        // 使用long是因为数组的最大长度为6*10^4，两个长度的乘积就大于int类型的最大值了，所以使用long来接收
        long res = 0;
        // 余数为0的组合对个数
        res += (long) cnt[0] * (cnt[0] - 1) / 2;
        // 余数为30的组合对个数
        res += (long) cnt[30] * (cnt[30] - 1) / 2;
        // 余数在[1,30)的组合对个数
        for (int i = 1; i < 30; i++) {
            res += (long) cnt[i] * cnt[60 - i];
        }
        return (int) res;
    }
}
