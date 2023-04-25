package org.brody.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.cn/problems/sort-the-people/">2418. 按身高排序</a>
 * <p>
 * 给你一个字符串数组 names ，和一个由 互不相同 的正整数组成的数组 heights 。两个数组的长度均为 n 。
 * <p>
 * 对于每个下标 i，names[i] 和 heights[i] 表示第 i 个人的名字和身高。
 * <p>
 * 请按身高 降序 顺序返回对应的名字数组 names 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：names = ["Mary","John","Emma"], heights = [180,165,170]
 * <p>
 * 输出：["Mary","Emma","John"]
 * <p>
 * 解释：Mary 最高，接着是 Emma 和 John 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：names = ["Alice","Bob","Bob"], heights = [155,185,150]
 * <p>
 * 输出：["Bob","Alice","Bob"]
 * <p>
 * 解释：第一个 Bob 最高，然后是 Alice 和第二个 Bob 。
 * <p>
 * 提示：
 * <p>
 * n == names.length == heights.length
 * <p>
 * 1 <= n <= 103
 * <p>
 * 1 <= names[i].length <= 20
 * <p>
 * 1 <= heights[i] <= 105
 * <p>
 * names[i] 由大小写英文字母组成
 * <p>
 * heights 中的所有值互不相同
 *
 * @author Brody
 */
public class Easy2418SortThePeople {

    public static void main(String[] args) {
        Easy2418SortThePeople solution = new Easy2418SortThePeople();
        String[] names = {"Mary", "John", "Emma"};
        int[] heights = new int[]{180, 165, 170};
        System.out.println(Arrays.toString(solution.sortPeople(names, heights)));
    }

    /**
     * 身高互不相同，将身高作为key，姓名作为value，放入map
     * <p>
     * 对map根据key做排序，然后转换为linkedMap，返回它的values集合即可
     *
     * @param names
     * @param heights
     * @return
     */
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> heightNameMap = new HashMap<>(heights.length);
        for (int i = 0; i < heights.length; i++) {
            heightNameMap.put(heights[i], names[i]);
        }
        LinkedHashMap<Integer, String> sortedMap = heightNameMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println(sortedMap);
        return sortedMap.values().toArray(new String[0]);
    }
}
