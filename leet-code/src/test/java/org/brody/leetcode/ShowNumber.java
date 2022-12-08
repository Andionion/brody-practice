package org.brody.leetcode;

import java.util.Scanner;

/**
 * 将一个字符串中所有的整数前后加上符号 “*”，其他字符保持不变。连续的数字视为一个整数。
 * <p>
 * 数据范围：字符串长度满足 1 \le n \le 100 \1≤n≤100
 * 输入描述：
 * 输入一个字符串
 * <p>
 * 输出描述：
 * 字符中所有出现的数字前后加上符号 “*”，其他字符保持不变
 * <p>
 * 示例 1
 * <p>
 * 输入：
 * <p>
 * Jkdi234klowe90a3
 * <p>
 * 输出：
 * <p>
 * Jkdi*234*klowe*90*a*3*
 */
public class ShowNumber {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
//            StringBuilder result = new StringBuilder();
//            String input = in.nextLine();
//            for (int i = 0; i < input.toCharArray().length; i++) {
//                if (input.charAt(i) <= '9' && input.charAt(i) >= '0') {
//                    result.append("*");
//                    int j = i;
//                    while (j < input.length() && input.charAt(j) <= '9' && input.charAt(j) >= '0') {
//                        result.append(input.charAt(j));
//                        j++;
//                    }
//                    result.append("*");
//                    i = j - 1;
//                } else {
//                    result.append(input.charAt(i));
//                }
//            }
//            System.out.println(result);

            String input = in.nextLine();
            System.out.println(input.replaceAll("([0-9]+)", "*$1*"));
        }
    }
}
